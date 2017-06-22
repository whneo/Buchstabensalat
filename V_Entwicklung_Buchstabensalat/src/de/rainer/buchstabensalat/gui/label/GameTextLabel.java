package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

import javax.swing.JLabel;

public class GameTextLabel extends JLabel {

	private static final long serialVersionUID = 5887700953279008194L;

	public GameTextLabel(String text, Font font, int hAlignment) {
		super(text);
		super.setFont(font);
		if (hAlignment != -1) {
			super.setHorizontalAlignment(hAlignment);
		}
	}

	public GameTextLabel() {
		this(null, null, -1);
	}

	public GameTextLabel(String text, Font font) {
		this(text, font, -1);
	}
}
