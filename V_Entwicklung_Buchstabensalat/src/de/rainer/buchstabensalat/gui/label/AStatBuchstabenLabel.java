package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public abstract class AStatBuchstabenLabel extends JLabel {

	private static final long serialVersionUID = 3592958316607966763L;
	public static final int LETTER_LABEL_SIZE = 65;
	
	public AStatBuchstabenLabel(String text, Color fgColor) {
		super(text);
		this.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.setFocusable(false);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 1));
		this.setForeground(fgColor);
	}
	
	public AStatBuchstabenLabel() {
		this("?", Color.RED);
	}
}
