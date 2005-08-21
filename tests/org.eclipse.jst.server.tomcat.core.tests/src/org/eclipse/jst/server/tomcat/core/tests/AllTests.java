/**********************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - Initial API and implementation
 **********************************************************************/
package org.eclipse.jst.server.tomcat.core.tests;

import org.eclipse.jst.server.tomcat.core.tests.internal.UtilTestCase;
import org.eclipse.jst.server.tomcat.core.tests.module.DeleteModuleTestCase;
import org.eclipse.jst.server.tomcat.core.tests.module.ModuleTestCase;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.jst.server.tomcat.core.tests");
		//$JUnit-BEGIN$
		System.setProperty("wtp.autotest.noninteractive", "true");
		
		suite.addTestSuite(ExistenceTest.class);
		suite.addTest(new OrderedTestSuite(TomcatRuntimeTestCase.class));
		suite.addTest(new OrderedTestSuite(ModuleTestCase.class));
		
		String s = System.getProperty("org.eclipse.jst.server.tomcat.32"); 
		//s = "D:\\Tools\\tomcat\\jakarta-tomcat-3.2.4";
		if (s != null && s.length() > 0) {
			RuntimeLocation.runtimeLocation = s;
			suite.addTest(new OrderedTestSuite(Tomcat32RuntimeTestCase.class));
			suite.addTest(new OrderedTestSuite(Tomcat32ServerTestCase.class));
		} else {
			System.err.println("Warning: Tomcat 3.2 not found - tests skipped");
		}
		
		s = System.getProperty("org.eclipse.jst.server.tomcat.40");
		if (s != null && s.length() > 0) {
			RuntimeLocation.runtimeLocation = s;
			suite.addTest(new OrderedTestSuite(Tomcat40RuntimeTestCase.class));
			suite.addTest(new OrderedTestSuite(Tomcat40ServerTestCase.class));
		} else {
			System.err.println("Warning: Tomcat 4.0 not found - tests skipped");
		}
		
		s = System.getProperty("org.eclipse.jst.server.tomcat.41");
		if (s != null && s.length() > 0) {
			RuntimeLocation.runtimeLocation = s;
			suite.addTest(new OrderedTestSuite(Tomcat41RuntimeTestCase.class));
			suite.addTest(new OrderedTestSuite(Tomcat41ServerTestCase.class));
		} else {
			System.err.println("Warning: Tomcat 4.1 not found - tests skipped");
		}
		
		s = System.getProperty("org.eclipse.jst.server.tomcat.50");
		//s = "D:\\Tools\\tomcat\\jakarta-tomcat-5.0.19";
		if (s != null && s.length() > 0) {
			RuntimeLocation.runtimeLocation = s;
			suite.addTest(new OrderedTestSuite(Tomcat50RuntimeTestCase.class));
			suite.addTest(new OrderedTestSuite(Tomcat50ServerTestCase.class));
		} else {
			System.err.println("Warning: Tomcat 5.0 not found - tests skipped");
		}
		
		s = System.getProperty("org.eclipse.jst.server.tomcat.55");
		if (s != null && s.length() > 0) {
			RuntimeLocation.runtimeLocation = s;
			suite.addTest(new OrderedTestSuite(Tomcat55RuntimeTestCase.class));
			suite.addTest(new OrderedTestSuite(Tomcat55ServerTestCase.class));
		} else {
			System.err.println("Warning: Tomcat 5.5 not found - tests skipped");
		}
		
		suite.addTestSuite(UtilTestCase.class);
		
		suite.addTest(new OrderedTestSuite(DeleteModuleTestCase.class));
		//$JUnit-END$
		return suite;
	}
}