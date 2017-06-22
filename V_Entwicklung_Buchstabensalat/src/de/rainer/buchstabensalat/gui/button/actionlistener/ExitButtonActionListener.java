package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public final class ExitButtonActionListener implements IActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		WortsalatDbManager.getInstance().getDbh().getDbc().disconnect();
		DATA.getExternObserver().setFinish(true);
	}

}
