package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionEvent;

<<<<<<< HEAD
import de.rainer.buchstabensalat.schnittstelle.IActionListener;

=======
>>>>>>> branch 'master' of https://github.com/whneo/Buchstabensalat.git
public final class BeendenButtonActionListener implements IActionListener {

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