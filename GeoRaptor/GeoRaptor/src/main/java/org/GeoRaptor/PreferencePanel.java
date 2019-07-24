package org.GeoRaptor;

import javax.swing.JCheckBox;

import oracle.ide.panels.DefaultTraversablePanel;
import oracle.ide.panels.TraversableContext;
import oracle.ide.panels.TraversalException;
import oracle.javatools.ui.layout.FieldLayoutBuilder;

/**
 * 
 * @author Bessie Gong 
 * @version 24 Jul 2019
 *
 */
public class PreferencePanel extends DefaultTraversablePanel {

	private static final long serialVersionUID = 1L;
	private final JCheckBox showPasswordCheckBox = new JCheckBox();
	private final JCheckBox implicitConnectCheckBox = new JCheckBox();

	public PreferencePanel() {
		this.layoutControls();
	}

	private void layoutControls() {
		final FieldLayoutBuilder builder = new FieldLayoutBuilder(this);
		builder.setAlignLabelsLeft(true);
		builder.add(builder.field().label().withText(PreferenceResources.getString("PREF_SHOW_PASSWORD_LABEL"))
				.component(showPasswordCheckBox));
		builder.add(builder.field().label().withText(PreferenceResources.getString("PREF_IMPLICIT_CONNECT_LABEL"))
				.component(implicitConnectCheckBox));
		builder.addVerticalSpring();
	}

	@Override
	public void onEntry(final TraversableContext tc) {
		PreferenceModel info = PreferencePanel.getUserInformation(tc);
		showPasswordCheckBox.setSelected(info.isShowPassword());
		implicitConnectCheckBox.setSelected(info.isImplicitConnect());
		super.onEntry(tc);
	}

	@Override
	public void onExit(final TraversableContext tc) throws TraversalException {
		PreferenceModel info = PreferencePanel.getUserInformation(tc);
		info.setShowPassword(showPasswordCheckBox.isSelected());
		info.setImplicitConnect(implicitConnectCheckBox.isSelected());
		super.onExit(tc);
	}

	private static PreferenceModel getUserInformation(final TraversableContext tc) {
		return PreferenceModel.getInstance(tc.getPropertyStorage());
	}

}
