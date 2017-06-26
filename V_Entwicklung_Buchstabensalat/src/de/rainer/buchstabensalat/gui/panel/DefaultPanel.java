package de.rainer.buchstabensalat.gui.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -2328741332862919218L;

	public GamePanel(Border border, LayoutManager layout, Color bgColor) {
		super();
		if (border != null) {
			super.setBorder(border);
		}
		super.setLayout(layout);
		super.setBackground(bgColor);
	}

	public GamePanel() {
		this(null, new FlowLayout(), null);
	}

	public GamePanel(Color bgColor) {
		this(null, new FlowLayout(), bgColor);
	}

	public GamePanel(Border border, Color bgColor) {
		this(border, new FlowLayout(), bgColor);
	}

	public GamePanel(LayoutManager layout, Color bgColor) {
		this(null, layout, bgColor);
	}

}