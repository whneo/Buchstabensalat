package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

public final class TextLabel extends ADefaultLabel {

	private static final long serialVersionUID = 5887700953279008194L;

	public TextLabel(String text, Font font, int hAlignment) {
		super(text, font);
		if (hAlignment != -1) {
			this.setHorizontalAlignment(hAlignment);
		}
	}

	public TextLabel(String text, Font font) {
		this(text, font, -1);
	}
}
