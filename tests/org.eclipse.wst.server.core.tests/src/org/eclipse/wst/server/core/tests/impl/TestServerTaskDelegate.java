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
package org.eclipse.wst.server.core.tests.impl;

import java.util.List;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IOptionalTask;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.model.ServerTaskDelegate;

public class TestServerTaskDelegate extends ServerTaskDelegate {
	public IOptionalTask[] getTasks(IServer server, List[] parents, IModule[] modules) {
		return null;
	}
}