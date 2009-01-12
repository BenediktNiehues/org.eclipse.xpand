package org.eclipse.xpand.internal.tests.evaluate;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllPackageTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.xpand.internal.tests.evaluate");
		//$JUnit-BEGIN$
		suite.addTestSuite(AopFeatureTest.class);
		suite.addTestSuite(ProtectedRegionsTest.class);
		suite.addTestSuite(StatementEvaluatorTest.class);
		//$JUnit-END$
		return suite;
	}

}
