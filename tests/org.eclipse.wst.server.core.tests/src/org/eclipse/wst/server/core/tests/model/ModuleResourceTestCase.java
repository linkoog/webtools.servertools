/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.core.tests.model;

import junit.framework.Test;
import junit.framework.TestCase;

import org.eclipse.wst.server.core.tests.OrderedTestSuite;
import org.eclipse.wst.server.core.tests.impl.TestModuleResource;

public class ModuleResourceTestCase extends TestCase {
	protected static TestModuleResource resource;

	public static Test suite() {
		return new OrderedTestSuite(ModuleResourceTestCase.class, "ModuleResourceTestCase");
	}

	public void test00CreateDelegate() throws Exception {
		resource = new TestModuleResource();
	}
	
	public void test01Name() throws Exception {
		assertNull(resource.getName());
	}
	
	public void test02Path() throws Exception {
		assertNull(resource.getModuleRelativePath());
	}
}