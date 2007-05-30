/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal.view.servers;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.ui.internal.Messages;
/**
 * Action for monitoring a server.
 */
public class MonitorServerAction extends Action {
	protected IServer server;
	protected Shell shell;

	/**
	 * MonitorServerAction constructor.
	 * 
	 * @param shell a shell
	 * @param server a server
	 */
	public MonitorServerAction(Shell shell, IServer server) {
		super(Messages.actionMonitorProperties);
		this.shell = shell;
		this.server = server;
	}

	/**
	 * Invoked when an action occurs. 
	 */
	public void run() {
		MonitorServerDialog msd = new MonitorServerDialog(shell, server);
		msd.open();
	}
}