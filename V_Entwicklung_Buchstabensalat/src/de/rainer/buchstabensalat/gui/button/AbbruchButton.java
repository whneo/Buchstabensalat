package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;

import javax.swing.JDialog;

import de.rainer.buchstabensalat.gui.button.buttonactionlistener.AbbruchButtonActionListener;

public final class AbbruchButton extends MainButton {

	private static final long serialVersionUID = -7301375695853751650L;

	public AbbruchButton(JDialog dialog) {
		super("abbruch", new Font("Tahoma", Font.BOLD, 20), false, false, true,
				new AbbruchButtonActionListener(dialog));
	}
}
