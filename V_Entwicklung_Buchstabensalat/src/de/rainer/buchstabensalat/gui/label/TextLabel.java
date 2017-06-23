package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

import javax.swing.JLabel;

public final class TextLabel extends JLabel {

	private static final long serialVersionUID = 5887700953279008194L;

	public TextLabel(String text, Font font, int hAlignment) {
		super(text);
		this.setFont(font);
		if (hAlignment != -1) {
			this.setHorizontalAlignment(hAlignment);
		}
		this.setFocusable(false);
	}

	public TextLabel(String text, Font font) {
		this(text, font, -1);
	}
}
