package de.rainer.buchstabensalat.gui.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.datenbank.DbManager;

public final class ExitButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DbManager.getInstance().getDbCon().disconnect();
		DATA.getExternObserver().setFinish(true);
	}

}
