package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.button.ExitButton;
import de.rainer.buchstabensalat.gui.button.PlayAgainButton;
import de.rainer.buchstabensalat.gui.label.GameTextLabel;
import de.rainer.buchstabensalat.gui.label.SpielendeLabel;

public class SpielendePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SpielendePanel() {
		super(new BorderLayout());
		this.init();
	}

	private void init() {
		super.setBackground(Color.YELLOW);
		super.setBorder(new LineBorder(Color.BLACK, 1));
		GamePanel northCenterNorth = new GamePanel(new BorderLayout(),
				Color.YELLOW);
		GameTextLabel ueberschrift = new GameTextLabel("Buchstabensalat",
				new Font("Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		northCenterNorth.add(ueberschrift, BorderLayout.CENTER);
		GameTextLabel label = new GameTextLabel(DataProvider.getInstance()
				.getSitzung().getSchwierigkeit().getName(), new Font("Tahoma",
				Font.BOLD, 20), SwingConstants.CENTER);
		northCenterNorth.add(label, BorderLayout.SOUTH);
		GamePanel northCenter = new GamePanel(new LineBorder(Color.BLACK, 1),
				Color.YELLOW);
		northCenter.add(northCenterNorth);
		GamePanel north = new GamePanel(new BorderLayout(), Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);
		this.initCenter();
		super.add(north, BorderLayout.NORTH);
	}

	private void initCenter() {
		GamePanel center = new GamePanel(new LineBorder(Color.BLACK, 1), null,
				Color.YELLOW);
		GameTextLabel endeLabel = new GameTextLabel(
				"<html><center>Runde beendet</center></html>", new Font(
						"Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		endeLabel.setBounds(570, 0, 420, 100);
		center.add(endeLabel);
		SpielendeLabel richtig = new SpielendeLabel(
				"<html><center>Richtig</center><br><center>"
						+ DataProvider.getInstance().getSitzung()
								.getRichtigeWorte() + "</center></html>");
		center.add(richtig);
		SpielendeLabel falsch = new SpielendeLabel(
				"<html><body><center>Falsch</center><br><center>"
						+ DataProvider.getInstance().getSitzung()
								.getFalscheWorte() + "</center></body></html>");
		center.add(falsch);
		PlayAgainButton neustartBtn = new PlayAgainButton();
		center.add(neustartBtn);
		ExitButton endeBtn = new ExitButton("Ende", new Point(790, 600));
		center.add(endeBtn);
		super.add(center, BorderLayout.CENTER);
	}
}
