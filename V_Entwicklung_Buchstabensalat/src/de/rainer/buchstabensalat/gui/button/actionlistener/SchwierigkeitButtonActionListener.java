package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import de.rainer.buchstabensalat.data.IDataProvider;
import de.rainer.buchstabensalat.datenobjekt.Schwierigkeit;
import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class SchwierigkeitButtonActionListener extends
		AActionListenerInklSchwierigkeitDialog implements IDataProvider {

	public SchwierigkeitButtonActionListener(SchwierigkeitDialog dialog) {
		super(dialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Schwierigkeit s = new Schwierigkeit().getSchwierigkeitByName(e
				.getActionCommand());
		DATA.getSitzung().setSchwierigkeit(s);
		DATA.getGameObserver().setCommand(s.getName());
		this.getDialog().dispatchEvent(
				new WindowEvent(this.getDialog(), WindowEvent.WINDOW_CLOSING));
	}
}
