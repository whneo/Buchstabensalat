package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class SessionContinueButtonActionListener extends
		AActionListenerInklBuchstabensalatPanel {

	public SessionContinueButtonActionListener(BuchstabensalatPanel bsp) {
		super(bsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (DATA.getWortArray().size() - 1 == DATA.getWortIndex()) {
			DATA.getSitzung().setSpielEnde(System.currentTimeMillis());
			DATA.getSitzung().save(DATA.getSitzung());
			DATA.getGameObserver().setCommand(e.getActionCommand());
		} else {
			DATA.setWortIndex(DATA.getWortIndex() + 1);
			this.getBsp().switchCenter(e.getActionCommand());
		}
	}

}
