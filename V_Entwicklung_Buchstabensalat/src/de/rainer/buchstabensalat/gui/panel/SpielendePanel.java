package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.button.ExitButton;
import de.rainer.buchstabensalat.gui.button.PlayAgainButton;
import de.rainer.buchstabensalat.gui.label.SpielendeFalschLabel;
import de.rainer.buchstabensalat.gui.label.SpielendeRichtigLabel;
import de.rainer.buchstabensalat.gui.label.TextLabel;

public class SpielendePanel extends DefaultPanel {

	private static final long serialVersionUID = 1L;

	public SpielendePanel() {
		super(new LineBorder(Color.BLACK, 1), new BorderLayout(), Color.YELLOW);
		this.init();
	}

	private void init() {
		DefaultPanel northCenterNorth = new DefaultPanel(new BorderLayout(),
				Color.YELLOW);
		TextLabel ueberschrift = new TextLabel("Buchstabensalat", new Font(
				"Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		northCenterNorth.add(ueberschrift, BorderLayout.CENTER);
		TextLabel label = new TextLabel(DataProvider.getInstance().getSitzung()
				.getSchwierigkeit().getName(),
				new Font("Tahoma", Font.BOLD, 20), SwingConstants.CENTER);
		northCenterNorth.add(label, BorderLayout.SOUTH);
		DefaultPanel northCenter = new DefaultPanel(new LineBorder(Color.BLACK,
				1), Color.YELLOW);
		northCenter.add(northCenterNorth);
		DefaultPanel north = new DefaultPanel(new BorderLayout(), Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);
		this.initCenter();
		super.add(north, BorderLayout.NORTH);
	}

	private void initCenter() {
		DefaultPanel center = new DefaultPanel(new LineBorder(Color.BLACK, 1),
				null, Color.YELLOW);
		TextLabel endeLabel = new TextLabel(
				"<html><center>Runde beendet</center></html>", new Font(
						"Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		endeLabel.setBounds(570, 0, 420, 100);
		center.add(endeLabel);
		SpielendeRichtigLabel richtig = new SpielendeRichtigLabel(
				"<html><center>Richtig</center><br><center>"
						+ DataProvider.getInstance().getSitzung()
								.getRichtigeWorte() + "</center></html>");
		center.add(richtig);
		SpielendeFalschLabel falsch = new SpielendeFalschLabel(
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
