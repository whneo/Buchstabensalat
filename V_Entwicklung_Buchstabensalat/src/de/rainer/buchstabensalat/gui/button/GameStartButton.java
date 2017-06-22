package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Point;

import de.rainer.buchstabensalat.gui.button.buttonactionlistener.GameStartButtonActionListener;

public final class GameStartButton extends FieldButton {

	private static final long serialVersionUID = 2065139205426766746L;

	public GameStartButton() {
		super("Start", new GameStartButtonActionListener(), Color.GREEN,
				new Point(564, 350));
	}
}
