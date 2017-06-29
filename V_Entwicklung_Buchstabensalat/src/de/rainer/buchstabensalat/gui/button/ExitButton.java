package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Point;

import de.rainer.buchstabensalat.gui.actionlistener.ExitButtonActionListener;

public final class ExitButton extends FieldButton {

	private static final long serialVersionUID = 3220006849941604749L;

	public ExitButton(String text, Point point) {
		super(text, new ExitButtonActionListener(), Color.RED, point);
	}
}
