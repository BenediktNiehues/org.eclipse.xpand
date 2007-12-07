package org.eclipse.xtend.util.stdlib.texttest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

public abstract class FileTestComponent extends AbstractWorkflowComponent {

	private Issues issues;
	
    private final Log log = LogFactory.getLog(getClass());
	
	public void checkConfiguration(Issues issues) {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		this.issues = issues;
		try {
			test();
			log.info("  tests completed successfully.");
		} catch ( Failed f ) {
			issues.addError( f.getMessage() );
			log.info("  TESTS FAILED!");
		}
	}

	@Override
	public String getLogMessage() {
		return "running tests...";
	}
	
	protected abstract void test();
	
	protected boolean assertTrue( boolean condition, String message ) {
		if (!condition) issues.addError(message);
		return condition;
	}

	protected void assertTrueFatal( boolean condition, String message ) {
		if (!condition) issues.addError(message);
		throw new RuntimeException("TEST STOPPED: "+message);
	}
	
	protected Handle getHandleGenerated(String idlFileName) {
		Handle handle = new Handle(idlFileName);
		return handle;
	}
	
	protected Handle getHandleCompare(String idlFileName) {
		Handle handle = new Handle(idlFileName);
		return handle;
	}
	

}
