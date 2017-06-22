package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.rainer.buchstabensalat.data.IDataProvider;
import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public final class ExitButtonActionListener implements IDataProvider,
		ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.clearData();
		WortsalatDbManager.getInstance().getDbh().getDbc().disconnect();
		DATA.getExternObserver().setFinish(true);
	}

}
