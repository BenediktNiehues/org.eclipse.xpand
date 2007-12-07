package org.eclipse.xtend.expression;

import java.util.regex.Matcher;

import junit.framework.TestCase;

public class EvaluationExceptionTest extends TestCase {
	public void testOawID() throws Exception {
		Matcher m =EvaluationException.P.matcher(" dsvdfgv df df gvd fgdf  stuff::Test.ext[3,56] dnvfd gvdf bvdfgbvd");
		assertTrue(m.find());
		String text = m.group();
		System.out.println(text);
		assertEquals("stuff::Test",EvaluationException.getExtXptNamespace(text));
		assertEquals("ext",EvaluationException.getExtXptExtension(text));
		assertEquals(new Integer(3),EvaluationException.getOffSet(text));
		assertEquals(new Integer(56),EvaluationException.getLength(text));
	}
}
