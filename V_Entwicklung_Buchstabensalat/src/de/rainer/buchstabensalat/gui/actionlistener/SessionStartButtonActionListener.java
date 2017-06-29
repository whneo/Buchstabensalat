package de.rainer.buchstabensalat.gui.actionlistener;

import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class SessionStartButtonActionListener extends
		AActionListenerInklBuchstabensalatPanel {

	public SessionStartButtonActionListener(BuchstabensalatPanel bsp) {
		super(bsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DATA.getSitzung().setSpielBeginn(System.currentTimeMillis());
		this.getBsp().getAufloesen().setEnabled(true);
		this.getBsp().switchCenter(e.getActionCommand());
	}

}