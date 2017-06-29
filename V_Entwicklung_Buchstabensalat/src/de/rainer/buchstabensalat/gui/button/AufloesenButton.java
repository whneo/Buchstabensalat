package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;

import de.rainer.buchstabensalat.gui.actionlistener.AufloesenButtonActionListener;
import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class AufloesenButton extends MainButton {

	private static final long serialVersionUID = -7037560505492991422L;

	public AufloesenButton(BuchstabensalatPanel bsp) {
		super("Auflösen", new Font("Tahoma", Font.BOLD, 20), false, false,
				false, new AufloesenButtonActionListener(bsp));
	}
}