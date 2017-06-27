package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.datenbank.DbManager;
<<<<<<< HEAD
import de.rainer.buchstabensalat.schnittstelle.IActionListener;
=======
>>>>>>> branch 'master' of https://github.com/whneo/Buchstabensalat.git

public final class ExitButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DbManager.getInstance().getDbCon().disconnect();
		DATA.getExternObserver().setFinish(true);
	}

}
