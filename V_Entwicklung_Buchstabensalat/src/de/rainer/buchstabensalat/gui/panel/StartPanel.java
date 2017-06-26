package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.gui.button.ExitButton;
import de.rainer.buchstabensalat.gui.button.GameStartButton;
import de.rainer.buchstabensalat.gui.label.TextLabel;

public class StartPanel extends DefaultPanel {

	private static final long serialVersionUID = 1L;

	public StartPanel() {
		super(new LineBorder(Color.BLACK, 1), new BorderLayout(), Color.YELLOW);
		DefaultPanel northCenterNorth = new DefaultPanel(new BorderLayout(),
				Color.YELLOW);
		TextLabel ueberschrift = new TextLabel("Buchstabensalat", new Font(
				"Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		northCenterNorth.add(ueberschrift, BorderLayout.CENTER);
		DefaultPanel northCenter = new DefaultPanel(new LineBorder(Color.BLACK,
				1), Color.YELLOW);
		northCenter.add(northCenterNorth);
		DefaultPanel center = new DefaultPanel(new LineBorder(Color.BLACK, 1),
				null, Color.YELLOW);
		GameStartButton startBtn = new GameStartButton();
		center.add(startBtn);
		ExitButton endeBtn = new ExitButton("Beenden", new Point(774, 350));
		center.add(endeBtn);
		DefaultPanel north = new DefaultPanel(new BorderLayout(), Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);
		super.add(north, BorderLayout.NORTH);
		super.add(center, BorderLayout.CENTER);
	}
}