package de.rainer.buchstabensalat.gui.button.buttonactionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class GameStartButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new SchwierigkeitDialog();
	}

}
