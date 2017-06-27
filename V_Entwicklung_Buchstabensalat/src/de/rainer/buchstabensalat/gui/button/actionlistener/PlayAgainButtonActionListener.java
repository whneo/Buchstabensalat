package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;
<<<<<<< HEAD
import de.rainer.buchstabensalat.schnittstelle.IActionListener;
=======
>>>>>>> branch 'master' of https://github.com/whneo/Buchstabensalat.git

public final class PlayAgainButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DATA.getGameObserver().setCommand(e.getActionCommand());
		new SchwierigkeitDialog();
	}
}