package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;

import de.rainer.buchstabensalat.gui.button.actionlistener.BeendenButtonActionListener;

public final class BeendenButton extends MainButton {

	private static final long serialVersionUID = 1731379336803986842L;

	public BeendenButton() {
		super("Spiel beenden", new Font("Tahoma", Font.BOLD, 20), false, false,
				true, new BeendenButtonActionListener());
	}
}
