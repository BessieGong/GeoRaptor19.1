package org.GeoRaptor;

import javax.swing.JOptionPane;

import org.geotools.util.logging.Logger;
import org.geotools.util.logging.Logging;

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
	
	private static final Logger LOGGER = Logging.getLogger(ViewController.class.getName());
	
	/**
	 * VIEW_SUBMENU_1_ACTION_ID Open Map
	 * VIEW_SUBMENU_2_ACTION_ID Manage All Metadata
	 * VIEW_SUBMENU_3_ACTION_ID Load Shapefile
	 * VIEW_SUBMENU_4_ACTION_ID About GeoRaptor
	 */
	private static final int VIEW_SUBMENU_1_ACTION_ID = Ide.findOrCreateCmdID("VIEW_SUBMENU_1_ACTION_ID");
	private static final int VIEW_SUBMENU_2_ACTION_ID = Ide.findOrCreateCmdID("VIEW_SUBMENU_2_ACTION_ID");
	private static final int VIEW_SUBMENU_3_ACTION_ID = Ide.findOrCreateCmdID("VIEW_SUBMENU_3_ACTION_ID");
	private static final int VIEW_SUBMENU_4_ACTION_ID = Ide.findOrCreateCmdID("VIEW_SUBMENU_4_ACTION_ID");
	
	

	public ViewController() {
		super();
	}
	
	private void show (String message) {
		JOptionPane.showMessageDialog(null, message, Resources.getString("DIALOG_SHOW_TITLE"), JOptionPane.INFORMATION_MESSAGE);
	}

	
	@Override
	public boolean handleEvent(IdeAction action, Context context) {
		int cmdId = action.getCommandId();
	
		if (cmdId == VIEW_SUBMENU_1_ACTION_ID) {
			show("GeoRaptor1");
		}else if(cmdId == VIEW_SUBMENU_2_ACTION_ID){
			show("Action CmdID: " + cmdId + " Name: " + action.getValue("Name"));
		}else if (cmdId == VIEW_SUBMENU_3_ACTION_ID) {
			show("GeoRaptor3");
		}else if (cmdId == VIEW_SUBMENU_4_ACTION_ID) {
			AboutDialog.getInstance().setVisible(true);
		}
		return true;
	}

	@Override
	public boolean update(IdeAction action, Context context) {
		action.setEnabled(true);
		return action.isEnabled();
	}

}
