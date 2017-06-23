package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public abstract class AFieldLabel extends JLabel {

	private static final long serialVersionUID = -5936881540562272308L;

	public AFieldLabel(String text, Color bgColor, int xPosition) {
		super(text);
		this.setOpaque(true);
		this.setFocusable(false);
		this.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBounds(xPosition, 300, 200, 200);
		this.setBackground(bgColor);
	}

	public AFieldLabel() {
		this("?", Color.BLACK, -1);
	}
}
