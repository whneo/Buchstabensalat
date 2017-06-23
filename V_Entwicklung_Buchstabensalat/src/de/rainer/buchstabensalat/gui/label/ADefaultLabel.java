package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

import javax.swing.JLabel;

public abstract class ADefaultLabel extends JLabel {

	private static final long serialVersionUID = 9121354955188130216L;

	public ADefaultLabel(String text, Font font, boolean isOpaque) {
		super(text);
		this.setFont(font);
		this.setFocusable(false);
		this.setOpaque(isOpaque);
	}

	public ADefaultLabel(String text, Font font) {
		this(text, font, false);
	}

	public ADefaultLabel() {
		this("", new Font("Tahoma", Font.BOLD, 5), false);
	}
}
