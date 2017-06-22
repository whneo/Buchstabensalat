package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SpielendeLabel extends JLabel {

	private static final long serialVersionUID = -2555523119547453318L;

	public SpielendeLabel(String text) {
		super(text);
		this.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.setFocusable(false);
		this.setBorder(new LineBorder(Color.BLACK, 1));
		if (text.contains("Richtig")) {
			this.setBackground(Color.GREEN);
			this.setBounds(570, 300, 200, 200);
		} else {
			this.setBackground(Color.RED);
			this.setBounds(790, 300, 200, 200);
		}
	}
}
