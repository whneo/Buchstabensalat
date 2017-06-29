package de.rainer.buchstabensalat.gui.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class PlayAgainButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DATA.getGameObserver().setCommand(e.getActionCommand());
		new SchwierigkeitDialog();
	}
}