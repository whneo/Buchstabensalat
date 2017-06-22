package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.rainer.buchstabensalat.data.IDataProvider;

public final class BeendenButtonActionListener implements IDataProvider,
		ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.getSitzung().setSpielEnde(System.currentTimeMillis());
		if ((DATA.getSitzung().getFalscheWorte() > 0 || DATA.getSitzung()
				.getRichtigeWorte() > 0)
				&& DATA.getSitzung().getSpielBeginn() > 0) {
			DATA.getSitzung().save(DATA.getSitzung());
		}
		DATA.getGameObserver().setCommand(e.getActionCommand());
	}
}