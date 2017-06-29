package de.rainer.buchstabensalat.gui.actionlistener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class AufloesenButtonActionListener extends
		AActionListenerInklBuchstabensalatPanel {

	public AufloesenButtonActionListener(BuchstabensalatPanel bsp) {
		super(bsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean richtig = true;
		for (int i = 0; i < DATA.getLetterList().size(); i++) {
			String str = DATA.getWortArray().get(DATA.getWortIndex());
			String placeText = DATA.getPlaceList().get(i).getText();
			if (placeText.equals("" + str.charAt(i))) {
				DATA.getPlaceList().get(i).setBackground(Color.GREEN);
				DATA.getPlaceList().get(i).setForeground(Color.BLACK);
			} else {
				DATA.getPlaceList().get(i).setBackground(Color.RED);
				DATA.getPlaceList().get(i).setForeground(Color.BLACK);
				richtig = false;
			}
		}
		if (richtig == true) {
			DATA.getSitzung().setRichtigeWorte(
					DATA.getSitzung().getRichtigeWorte() + 1);
		} else {
			DATA.getSitzung().setFalscheWorte(
					DATA.getSitzung().getFalscheWorte() + 1);
		}
		this.getBsp().switchCenter(e.getActionCommand());
	}

}
