package org.GeoRaptor;

import javax.swing.JOptionPane;

import oracle.ide.Context;
import oracle.ide.Ide;
import oracle.ide.controller.Controller;
import oracle.ide.controller.IdeAction;

/**
 * 
 * @author Bessie Gong 
 * @version 24 Jul 2019
 *
 */
public class ViewController implements Controller {
	
	private static final int VIEW_MENU_CMD_ID = Ide.findOrCreateCmdID("VIEW_MENU_ACTION_ID");
	

	public ViewController() {
		super();
	}
	
	private void show (String message) {
		JOptionPane.showMessageDialog(null, message, ViewResources.getString("DIALOG_SHOW_TITLE"), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public boolean handleEvent(IdeAction action, Context context) {
		int cmdId = action.getCommandId();
		if (cmdId == VIEW_MENU_CMD_ID) {
			show("GeoRaptor");
		} else {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}
		return true;
	}

	@Override
	public boolean update(IdeAction action, Context context) {
		action.setEnabled(true);
		return action.isEnabled();
	}

}
