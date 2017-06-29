package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Point;

import de.rainer.buchstabensalat.gui.actionlistener.PlayAgainButtonActionListener;

public final class PlayAgainButton extends FieldButton {

	private static final long serialVersionUID = 8211413495156837956L;

	public PlayAgainButton() {
		super("Nochmal", new PlayAgainButtonActionListener(), Color.GREEN,
				new Point(570, 600));
	}
}