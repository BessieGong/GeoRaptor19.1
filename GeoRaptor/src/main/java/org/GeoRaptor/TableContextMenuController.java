package org.GeoRaptor;

import javax.swing.JOptionPane;

import oracle.ide.Context;
import oracle.ide.Ide;
import oracle.ide.controller.Controller;
import oracle.ide.controller.IdeAction;

/**
 * @author Bessie Gong Email: sadbessie@gmail.com
 * @version 11 Sep 2019
 *
 */
public class TableContextMenuController implements Controller{
	
	
	/**
	 * CONTEXT_SUBMENU_1_ACTION_ID Zoom to Map
	 * CONTEXT_SUBMENU_2_ACTION_ID Add to Map
	 * CONTEXT_SUBMENU_3_ACTION_ID Create Spatial Index
	 * CONTEXT_SUBMENU_4_ACTION_ID Drop Spatial Index
	 * CONTEXT_SUBMENU_5_ACTION_ID Manage Metadata
	 * CONTEXT_SUBMENU_6_ACTION_ID Drop Metadata
	 * CONTEXT_SUBMENU_7_ACTION_ID Export
	 * CONTEXT_SUBMENU_8_ACTION_ID Validate geometry
	 */
	
	private static final int CONTEXT_SUBMENU_1_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_1_ACTION_ID");
	private static final int CONTEXT_SUBMENU_2_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_2_ACTION_ID");
	private static final int CONTEXT_SUBMENU_3_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_3_ACTION_ID");
	private static final int CONTEXT_SUBMENU_4_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_4_ACTION_ID");
	private static final int CONTEXT_SUBMENU_5_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_5_ACTION_ID");
	private static final int CONTEXT_SUBMENU_6_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_6_ACTION_ID");
	private static final int CONTEXT_SUBMENU_7_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_7_ACTION_ID");
	private static final int CONTEXT_SUBMENU_8_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_SUBMENU_8_ACTION_ID");
	private static final int CONTEXT_TABLESUBMENU_ACTION_ID = Ide.findOrCreateCmdID("CONTEXT_TABLESUBMENU_ACTION_ID");

	private void show (String message) {
		JOptionPane.showMessageDialog(null, message, Resources.getString("DIALOG_SHOW_TITLE"), JOptionPane.INFORMATION_MESSAGE);
	}
	@Override
	public boolean handleEvent(IdeAction action, Context context) {
		int cmdId = action.getCommandId();
		
		if (cmdId == CONTEXT_SUBMENU_1_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if(cmdId == CONTEXT_SUBMENU_2_ACTION_ID){
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_3_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_4_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_5_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_6_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_7_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_SUBMENU_8_ACTION_ID) {
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == CONTEXT_TABLESUBMENU_ACTION_ID) {
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
