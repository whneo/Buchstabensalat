package de.rainer.buchstabensalat.gui.button.buttonactionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import de.rainer.buchstabensalat.gui.listener.actionlistener.AActionListenerInklSchwierigkeitDialog;

public final class AbbruchButtonActionListener extends
		AActionListenerInklSchwierigkeitDialog {

	public AbbruchButtonActionListener(JDialog dialog) {
		super(dialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getDialog().dispatchEvent(
				new WindowEvent(this.getDialog(), WindowEvent.WINDOW_CLOSING));
	}
}