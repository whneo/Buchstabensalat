package de.rainer.buchstabensalat.gui.button.buttonactionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.rainer.buchstabensalat.data.IDataProvider;
import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class PlayAgainButtonActionListener implements IDataProvider, ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DATA.getGameObserver().setCommand(e.getActionCommand());
		new SchwierigkeitDialog();
	}
}