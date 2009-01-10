/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;

public class ExtensionFile extends SyntaxElement implements XtendFile {

    private List<ImportStatement> nsImports;

    private List<ImportStatement> extImports;

    private List<Extension> extensions;

	private List<Around> arounds;

	private List<Check> checks;
	
	public List<Check> getChecks() {
		return checks;
	}

    public ExtensionFile(final List<ImportStatement> nsImports, final List<ImportStatement> extImports,
            final List<Extension> extensions, final List<Around> arounds, final List<Check> checks) {
        this.nsImports = nsImports;
        this.extImports = extImports;
        this.extensions = extensions;
        this.arounds = arounds;
        this.checks = checks;
        for (Extension extension : extensions) {
            extension.setExtensionFile(this);
        }
        for (Around around : arounds) {
        	around.setParent(this);
        }
    }
    
    public List<Around> getArounds() {
		return arounds;
	}

    public List<Extension> getExtensions() {
        return extensions;
    }

    public List<ImportStatement> getExtImports() {
        return extImports;
    }

    public List<ImportStatement> getNsImports() {
        return nsImports;
    }

    public String[] getImportedNamespaces() {
        final List<String> namespaces = new ArrayList<String>();
        for (ImportStatement nsImport : nsImports) {
            namespaces.add(nsImport.getImportedId().getValue());
        }
        return namespaces.toArray(new String[namespaces.size()]);
    }
    
    public List<String> getImportedNamespacesAsList() {
        return Arrays.asList(getImportedNamespaces());
    }

    public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        ctx = ctx.cloneWithResource(this);

        // try to load all declared imported extensions. Add error issues if the resource cannot be located
        // by the ResourceManager
        for (ImportStatement imp : extImports) {
            final XtendFile xf = (XtendFile) ctx.getResourceManager().loadResource(imp.getImportedId().getValue(),
                    XtendFile.FILE_EXTENSION);
            if (xf == null) {
            	final String msg = "Error while importing extension: File " + imp.getImportedId().getValue() +  " not found.";
            	issues.add(new AnalysationIssue(AnalysationIssue.RESOURCE_NOT_FOUND, msg, imp));
            	return;
            }
        }

        for (Extension ext : extensions) {
        	try {
        		ext.analyze(ctx, issues);
        	} catch (RuntimeException ex) {
        		Map<String,Object> info = new HashMap<String,Object>();
        		info.put("extension", ext);
        		ctx.handleRuntimeException(ex, this, info);
        	}
        }
        
        for (Around around : arounds) {
        	try {
        		around.analyze(ctx, issues);
        	} catch (RuntimeException ex) {
        		Map<String,Object> info = new HashMap<String,Object>();
        		info.put("around", around);
        		ctx.handleRuntimeException(ex, this, info);
        	}
        }
        
        for (final Check check : checks) {
        	try {
        		check.analyze(ctx, issues);
            } catch (RuntimeException ex) {
            	ctx.handleRuntimeException(ex, this, null);
            }
        }
    }

    private String fullyQualifiedName;

    public void setFullyQualifiedName(final String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public String[] getImportedExtensions() {
        final List<String> namespaces = new ArrayList<String>();
        for (ImportStatement extImport : extImports) {
            namespaces.add(extImport.getImportedId().getValue());
        }
        return getImportedExtensionsAsList().toArray(new String[namespaces.size()]);
    }
    
    public List<String> getImportedExtensionsAsList () {
        final List<String> namespaces = new ArrayList<String>();
        for (ImportStatement extImport : extImports) {
            namespaces.add(extImport.getImportedId().getValue());
        }
        return namespaces;
    }

    public List<Extension> getPublicExtensions(final ResourceManager rm, ExecutionContext ctx) {
        return getPublicExtensions(rm, ctx, new HashSet<String>());
    }
        
    public List<Extension> getPublicExtensions(final ResourceManager rm, ExecutionContext ctx, Set<String> flowoverCache) {
        if (flowoverCache.contains(getFullyQualifiedName()))
            return new ArrayList<Extension>();
        flowoverCache.add (getFullyQualifiedName());
        
        final List<Extension> result = new ArrayList<Extension>();
        
        for (Extension ext : extensions) {
            if (!ext.isPrivate()) {
                result.add(ext);
            }
        }
        for (ImportStatement imp : extImports) {
            if (imp.isExported()) {
                final XtendFile xf = (XtendFile) rm.loadResource(imp.getImportedId().getValue(),
                        XtendFile.FILE_EXTENSION);
                ExecutionContext context = ctx.cloneWithResource(xf);
                List<Extension> publicExtensions = xf.getPublicExtensions(rm, context, flowoverCache);
                for (Extension extension : publicExtensions) {
                	extension.init(context);
                	if (!result.contains(extension))
                		result.add(extension);
				}
            }
        }
        return result;
    }
    
    public void check(ExecutionContext ctx, final Collection<?> objects, final Issues issues, boolean warnIfNothingChecked) {
        ctx = ctx.cloneWithResource(this);
        for (final Check check : checks) {
            check.validate(ctx, objects, issues, warnIfNothingChecked);
        }
    }
}
