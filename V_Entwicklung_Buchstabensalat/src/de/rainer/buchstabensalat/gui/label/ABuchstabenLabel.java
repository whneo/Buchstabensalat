package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class ABuchstabenLabel extends JLabel {

	private static final long serialVersionUID = -8790258267102779397L;
	public static final int LETTER_LABEL_SIZE = 65;

	public ABuchstabenLabel(String text) {
		super(text);
		this.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.setFocusable(false);
	}

	public ABuchstabenLabel() {
		this("");
	}
}
