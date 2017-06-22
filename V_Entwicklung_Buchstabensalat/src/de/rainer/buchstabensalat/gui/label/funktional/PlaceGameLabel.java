package de.rainer.buchstabensalat.gui.label.funktional;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;

public class PlaceGameLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public PlaceGameLabel(int x, char text) {
		super();
		this.init(x, text);
	}

	public PlaceGameLabel() {
		this(0, '?');
	}

	public PlaceGameLabel(int x) {
		this(x, '?');
	}

	private void init(int x, char text) {
		if (DataProvider.getInstance().getPlaceList().size() != 0) {
			x = DataProvider.getInstance().getPlaceList()
					.get(DataProvider.getInstance().getPlaceList().size() - 1)
					.getX() + 75;
		}
		int width_height = 65;
		super.setBounds(x, 635, width_height, width_height);
		super.setHorizontalAlignment(SwingConstants.CENTER);
		super.setFont(new Font("Tahoma", Font.BOLD, 40));
		super.setBorder(new LineBorder(Color.BLACK, 1));
		super.setForeground(Color.LIGHT_GRAY);
		if (text != '?') {
			super.setText("" + text);
		}
		super.setOpaque(true);
		DataProvider.getInstance().getPlaceList().add(this);
		super.setVisible(true);
	}
}