package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.datenbank.DbManager;
import de.rainer.buchstabensalat.schnittstelle.IActionListener;

public final class ExitButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		DbManager.getInstance().getDbCon().disconnect();
		DATA.getExternObserver().setFinish(true);
	}

}
