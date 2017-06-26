package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;

import javax.swing.border.LineBorder;

public abstract class AStatBuchstabenLabel extends ABuchstabenLabel {

	private static final long serialVersionUID = 3592958316607966763L;

	public AStatBuchstabenLabel(String text, Color fgColor) {
		super(text);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 1));
		this.setForeground(fgColor);
	}

	public AStatBuchstabenLabel() {
		this("", Color.RED);
	}

	public AStatBuchstabenLabel(Color fgColor) {
		this("", fgColor);
	}
}
