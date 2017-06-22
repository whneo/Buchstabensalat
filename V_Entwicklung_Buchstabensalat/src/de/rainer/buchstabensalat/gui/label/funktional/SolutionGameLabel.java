package de.rainer.buchstabensalat.gui.label.funktional;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;

public class SolutionGameLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public SolutionGameLabel(int i, char text) {
		super();
		this.init(i, text);
	}

	public SolutionGameLabel() {
		this(0, '?');
	}

	private void init(int i, char text) {
		int x = DataProvider.getInstance().getPlaceList().get(i).getX();
		int width_height = 65;
		super.setBackground(Color.WHITE);
		super.setBounds(x, 710, width_height, width_height);
		super.setHorizontalAlignment(SwingConstants.CENTER);
		super.setFont(new Font("Tahoma", Font.BOLD, 40));
		super.setBorder(new LineBorder(Color.BLACK, 1));
		super.setText("" + text);
		super.setForeground(Color.BLACK);
		super.setOpaque(true);
		super.setVisible(true);
	}

}