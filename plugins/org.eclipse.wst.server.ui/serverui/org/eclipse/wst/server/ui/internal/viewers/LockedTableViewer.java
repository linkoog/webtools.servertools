/*******************************************************************************
 * Copyright (c) 2003, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal.viewers;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swt.widgets.Display;
/**
 *
 */
public class LockedTableViewer extends TableViewer {
	protected Color color;

	public LockedTableViewer(Composite parent) {
		super(parent);
		createColor(parent);
	}
	
	public LockedTableViewer(Composite parent, int style) {
		super(parent, style);
		createColor(parent);
	}

	public LockedTableViewer(Table table) {
		super(table);
		createColor(table);
	}

	protected void createColor(Control c) {
		if (Display.getDefault().getHighContrast())
			color = new Color(c.getDisplay(), 0, 0, 0);
		else
			color = new Color(c.getDisplay(), 255, 255, 225);
		c.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				color.dispose();
			}
		});
	}

	public void doUpdateItem(Widget widget, Object element, boolean fullMap) {
		if (color == null)
			return;
		if (widget instanceof TableItem) {
			TableItem item = (TableItem) widget;
			if (getLabelProvider() instanceof ILockedLabelProvider) {
				ILockedLabelProvider provider = (ILockedLabelProvider) getLabelProvider();
				if (provider.isLocked(element)) {
					item.setBackground(color);
					item.setImage(0, null);
				} else
					item.setBackground(null);
			}
		}
		super.doUpdateItem(widget, element, fullMap);
	}
}