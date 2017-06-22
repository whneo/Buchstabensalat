package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.gui.button.ExitButton;
import de.rainer.buchstabensalat.gui.button.GameStartButton;
import de.rainer.buchstabensalat.gui.label.GameTextLabel;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public StartPanel() {
		super();
		super.setLayout(new BorderLayout());
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 1));
		GamePanel northCenterNorth = new GamePanel(new BorderLayout(),
				Color.YELLOW);
		GameTextLabel ueberschrift = new GameTextLabel("Buchstabensalat",
				new Font("Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		northCenterNorth.add(ueberschrift, BorderLayout.CENTER);
		GamePanel northCenter = new GamePanel(new LineBorder(Color.BLACK, 1),
				Color.YELLOW);
		northCenter.add(northCenterNorth);
		GamePanel center = new GamePanel(new LineBorder(Color.BLACK, 1), null,
				Color.YELLOW);
		GameStartButton startBtn = new GameStartButton();
		center.add(startBtn);
		ExitButton endeBtn = new ExitButton("Beenden", new Point(774, 350));
		center.add(endeBtn);
		GamePanel north = new GamePanel(new BorderLayout(), Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);
		super.add(north, BorderLayout.NORTH);
		super.add(center, BorderLayout.CENTER);
	}
}