package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;

import de.rainer.buchstabensalat.gui.button.buttonactionlistener.SchwierigkeitButtonActionListener;
import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class SchwierigkeitButton extends MainButton {

	private static final long serialVersionUID = -1202650057754907149L;

	public SchwierigkeitButton(String text, SchwierigkeitDialog dialog) {
		super(text, new Font("Tahoma", Font.BOLD, 20), false, false, true,
				new SchwierigkeitButtonActionListener(dialog));
	}
}
