package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;

import de.rainer.buchstabensalat.gui.actionlistener.AbbruchButtonActionListener;
import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public final class AbbruchButton extends MainButton {

	private static final long serialVersionUID = -7301375695853751650L;

	public AbbruchButton(SchwierigkeitDialog dialog) {
		super("abbruch", new Font("Tahoma", Font.BOLD, 20), false, false, true,
				new AbbruchButtonActionListener(dialog));
	}
}
