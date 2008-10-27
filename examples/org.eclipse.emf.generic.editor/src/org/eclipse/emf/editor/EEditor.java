/**
 * <copyright> 
 *
 * Copyright (c) 2008 itemis AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   itemis AG - Initial API and implementation
 *
 * </copyright>
 *
 */
package org.eclipse.emf.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.editor.extxpt.ExtXptFacade;
import org.eclipse.emf.editor.extxpt.WorkspaceResourceManager;
import org.eclipse.emf.editor.provider.ExtendedLabelProvider;
import org.eclipse.emf.editor.provider.ExtendedReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.editor.provider.ExtendedReflectiveItemProviderAdapterFactory.ExtendedReflectiveItemProvider;
import org.eclipse.emf.editor.ui.EEDetailsPageProvider;
import org.eclipse.emf.editor.ui.EEMasterDetailsBlock;
import org.eclipse.emf.editor.ui.ImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.shared.ui.Activator;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

/**
 * @author Dennis H�bner - Initial contribution and API
 * 
 */
public class EEditor extends EcoreEditor implements ChangeListener {

	private static final String ESTRUCTURALFEATURE_KEY = EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName();
	protected static final String MARKER_ID = Activator.getId() + ".problem";
	private ManagedForm managedForm;
	private EEMasterDetailsBlock mdBlock;

	private IProject project;
	private ExtXptFacade facade;
	private ExtendedReflectiveItemProvider extendedReflectiveItemProvider;

	public EEditor() {
		super();
		// editingDomain already created by superclass
		ImageRegistry.getDefault().addChangeListener(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		ImageRegistry.getDefault().removeChangeListener(this);
	}

	/**
	 * To provide custom (oAW-Powered) labels and images
	 * 
	 * @param caf
	 * 
	 */
	private void rejectFactory(ComposedAdapterFactory caf) {
		// REMOVE reflective factory
		caf.removeAdapterFactory(caf.getFactoryForType(EcorePackage.eINSTANCE.getEFactoryInstance().create(
				EcorePackage.Literals.EOBJECT)));
		// ADD extended factory
		ExtendedLabelProvider customProvider = new ExtendedLabelProvider(facade);
		ExtendedReflectiveItemProviderAdapterFactory extendedReflectiveItemProviderAdapterFactory = new ExtendedReflectiveItemProviderAdapterFactory(
				customProvider);
		caf.addAdapterFactory(extendedReflectiveItemProviderAdapterFactory);

		// register item provider for details view
		this.extendedReflectiveItemProvider = (ExtendedReflectiveItemProvider) extendedReflectiveItemProviderAdapterFactory
				.createAdapter(null);
	}

	/**
	 * Model is already created by superclass. Provides a container for EMF's
	 * TreeViewer (currentViewer)
	 * 
	 * @see org.eclipse.ui.part.MultiPageEditorPart#createPageContainer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Composite createPageContainer(Composite parent) {
		parent.setLayout(new FillLayout());
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		ScrolledForm form = new ScrolledForm(parent) {
			@Override
			public void reflow(boolean flushCache) {
				// super.reflow(flushCache);
			}
		};
		form.setExpandHorizontal(true);
		form.setExpandVertical(true);
		form.setBackground(toolkit.getColors().getBackground());
		form.setForeground(toolkit.getColors().getColor(IFormColors.TITLE));
		form.setFont(JFaceResources.getHeaderFont());
		toolkit.adapt(parent);
		managedForm = new ManagedForm(toolkit, form);
		managedForm.getForm().setText("Generic Editor - " + getFile().getName());
		managedForm.getToolkit().decorateFormHeading(managedForm.getForm().getForm());
		managedForm.getForm().getForm().setToolBarVerticalAlignment(SWT.TOP);
		managedForm.getForm().getForm().addMessageHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				try {
					Object eventData = event.getHref();
					if (eventData instanceof IMessage[]) {
						final IMessage[] messages = (IMessage[]) eventData;

						getSite().getShell().getDisplay().syncExec(new Runnable() {
							public void run() {
								Object object = null;
								Control c = null;
								for (IMessage message : messages) {
									object = ((List<?>) message.getData()).get(0);
									if (object != null) {
										getViewer().setSelection(new StructuredSelection(object), true);
									}
									if (message.getData() instanceof Map) {
										EStructuralFeature f = (EStructuralFeature) ((List<?>) message.getData())
												.get(1);
										if (f != null) {
											c = mdBlock.findControl(ESTRUCTURALFEATURE_KEY, f);
										}
									}
									break;
								}

								if (c != null && !c.isDisposed()) {
									c.forceFocus();
								}
							}
						});
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mdBlock = new EEMasterDetailsBlock(new EEDetailsPageProvider(this)) {
			@Override
			protected void createMoreToolBarActions(IToolBarManager toolBarManager) {
				Action action = new Action("Check") {
					@Override
					public void run() {
						checkModel();
					}
				};
				action.setImageDescriptor(EEPlugin.getImageDescriptor("icons/complete_task.gif"));
				toolBarManager.add(action);
			}
		};
		mdBlock.createContent(managedForm);

		final Composite c = (Composite) mdBlock.getMasterSectionPart().getSection().getClient();
		//
		this.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof TreeSelection && !event.getSelection().isEmpty())
					managedForm.fireSelectionChanged(mdBlock.getMasterSectionPart(), event.getSelection());
			}

		});
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.presentation.EcoreEditor#createPages()
	 */
	@Override
	public void createPages() {
		initInternal();
		super.createPages();
	}

	/**
	 * 
	 */
	private void initInternal() {
		project = getFile().getProject();
		facade = createExtXptFacade();
		if (editingDomain.getAdapterFactory() instanceof ComposedAdapterFactory) {
			ComposedAdapterFactory caf = (ComposedAdapterFactory) editingDomain.getAdapterFactory();
			rejectFactory(caf);
		}
	}

	@Override
	public void createModel() {
		try {
			super.createModel();
			// checkModel();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		try {
			checkModel();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			super.doSave(progressMonitor);
		}
	}

	/**
	 * 
	 */
	public void checkModel() {
		final List<MessageData> messages = new ModelCheckor(facade).check(getEditingDomain().getResourceSet());
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IMessageManager messageManager = managedForm.getMessageManager();
				messageManager.removeMessages();
				messageManager.setAutoUpdate(false);
				for (MessageData md : messages) {
					messageManager.addMessage(md.getKey(), md.getMessage(), md.getData(), md.getStatus());
					if (getFile() != null)
						addMarker(getFile(), md.getMessage(), md.getStatus());
				}
				messageManager.update();
				messageManager.setAutoUpdate(true);
			}
		});
	}

	private void addMarker(final IFile file, final String message, final int severity) {
		try {
			new WorkspaceModifyOperation() {

				@Override
				protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
						InterruptedException {

					try {
						// FIXME own MarkerType
						IMarker marker = file.createMarker(MARKER_ID);
						marker.setAttribute(IMarker.MESSAGE, message);
						int status = IMarker.SEVERITY_INFO;
						switch (severity) {
							case IMessageProvider.ERROR:
								status = IMarker.SEVERITY_ERROR;
								break;
							case IMessageProvider.WARNING:
								status = IMarker.SEVERITY_WARNING;
								break;
						}
						marker.setAttribute(IMarker.SEVERITY, status);
					}
					catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}.run(new NullProgressMonitor());
		}
		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private ExtXptFacade createExtXptFacade() {
		final List<EPackage> packs = findMetaModelPackages();
		TypeSystemImpl ts = new TypeSystemImpl();
		ts.registerMetaModel(new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return packs.toArray(new EPackage[packs.size()]);
			}
		});
		ExecutionContext context = new ExecutionContextImpl(new WorkspaceResourceManager(Activator
				.getExtXptModelManager().findProject(project)), ts, null);
		return new ExtXptFacade(project, context);

	}

	private List<EPackage> findMetaModelPackages() {
		createModel(); // initialize resources
		final List<EPackage> packs = new ArrayList<EPackage>();
		EcoreUtil.resolveAll(getEditingDomain().getResourceSet());
		EList<Resource> resources = getEditingDomain().getResourceSet().getResources();
		if (resources != null) {
			for (Resource res : resources) {
				TreeIterator<EObject> allContents = res.getAllContents();
				if (allContents.hasNext()) {
					EObject rootObject = allContents.next();
					if (rootObject instanceof EPackage)
						packs.add((EPackage) rootObject);
				}
			}
		}
		return packs;
	}

	public IFile getFile() {
		return (IFile) getEditorInput().getAdapter(IFile.class);
	}

	public ExtendedReflectiveItemProvider getExtendedReflectiveItemProvider() {

		return extendedReflectiveItemProvider;
	}

	public void stateChanged(ChangeEvent e) {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				currentViewer.refresh();
			}
		});
	}

	public ExtXptFacade getExtXptFacade() {
		return facade;
	}

	public static int formularOrientation() {
		IPreferenceStore store = EEPlugin.getDefault().getPreferenceStore();
		int pref = store.getInt(org.eclipse.emf.editor.ui.IPreferenceConstants.FORMULAR_ORIENTATION);
		if (pref != SWT.VERTICAL && pref != SWT.HORIZONTAL)
			return SWT.VERTICAL;
		return pref;
	}
}
