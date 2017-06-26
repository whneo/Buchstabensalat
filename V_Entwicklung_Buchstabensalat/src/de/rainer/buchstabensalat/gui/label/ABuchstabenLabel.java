package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

import javax.swing.SwingConstants;

public abstract class ABuchstabenLabel extends ADefaultLabel {

	private static final long serialVersionUID = -8790258267102779397L;
	public static final int LETTER_LABEL_SIZE = 65;

	public ABuchstabenLabel(String text) {
		super(text, new Font("Tahoma", Font.BOLD, 40), true);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public ABuchstabenLabel() {
		this("");
	}
}
