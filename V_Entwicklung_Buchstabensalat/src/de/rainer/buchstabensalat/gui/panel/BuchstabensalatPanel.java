package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.datenobjekt.Wort;
import de.rainer.buchstabensalat.gui.button.AufloesenButton;
import de.rainer.buchstabensalat.gui.button.BeendenButton;
import de.rainer.buchstabensalat.gui.button.SessionContinueButton;
import de.rainer.buchstabensalat.gui.button.SessionStartButton;
import de.rainer.buchstabensalat.gui.label.TextLabel;
import de.rainer.buchstabensalat.gui.label.LetterGameLabel;
import de.rainer.buchstabensalat.gui.label.PlaceGameLabel;
import de.rainer.buchstabensalat.gui.label.SolutionGameLabel;

public class BuchstabensalatPanel extends JPanel {

	private static final long serialVersionUID = -3367434892195229507L;

	private final DataProvider data = DataProvider.getInstance();
	private JPanel mainCenter;
	private JPanel center;
	private AufloesenButton aufloesen;

	private DataProvider getData() {
		return data;
	}

	private JPanel getMainCenter() {
		return this.mainCenter;
	}

	private void setMainCenter(JPanel mainCenter) {
		this.mainCenter = mainCenter;
	}

	private JPanel getCenter() {
		return this.center;
	}

	private void setCenter(JPanel center) {
		this.center = center;
	}

	public AufloesenButton getAufloesen() {
		return this.aufloesen;
	}

	private void setAufloesen(AufloesenButton aufloesen) {
		this.aufloesen = aufloesen;
	}

	public BuchstabensalatPanel(JPanel mainCenter, JPanel center,
			AufloesenButton aufloesen) {
		super();
		this.setMainCenter(mainCenter);
		this.setCenter(center);
		this.setAufloesen(aufloesen);
		this.init();
	}

	public BuchstabensalatPanel() {
		this(new GamePanel(new LineBorder(Color.BLACK, 1), new BorderLayout(),
				Color.YELLOW), new GamePanel(new LineBorder(Color.BLACK, 1),
				null, Color.YELLOW), new AufloesenButton(null));
	}

	private void init() {
		super.setLayout(new BorderLayout());
		BeendenButton beenden = new BeendenButton();
		this.setAufloesen(new AufloesenButton(this));
		TextLabel benutzer = new TextLabel(this.getData().getSitzung()
				.getBenutzer().getVorname(),
				new Font("Tahoma", Font.PLAIN, 20), SwingConstants.CENTER);
		GamePanel northCenterNorth = new GamePanel(new BorderLayout(),
				Color.YELLOW);
		TextLabel ueberschrift = new TextLabel("Buschstabensalat",
				new Font("Tahoma", Font.BOLD, 30), SwingConstants.CENTER);
		northCenterNorth.add(ueberschrift, BorderLayout.CENTER);
		TextLabel level = new TextLabel(BuchstabensalatPanel.this
				.getData().getSitzung().getSchwierigkeit().getName(), new Font(
				"Tahoma", Font.BOLD, 20), SwingConstants.CENTER);
		northCenterNorth.add(level, BorderLayout.SOUTH);
		GamePanel northCenter = new GamePanel(new LineBorder(Color.BLACK, 1),
				Color.YELLOW);
		northCenter.add(northCenterNorth);
		GamePanel northWest = new GamePanel(new LineBorder(Color.BLACK, 1),
				new BorderLayout(), Color.YELLOW);
		northWest.add(benutzer, BorderLayout.NORTH);
		northWest.add(beenden, BorderLayout.SOUTH);
		GamePanel northEast = new GamePanel(new LineBorder(Color.BLACK, 1),
				new BorderLayout(), Color.YELLOW);
		northEast.add(this.getAufloesen(), BorderLayout.SOUTH);
		GamePanel north = new GamePanel(new BorderLayout(), Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);
		north.add(northEast, BorderLayout.EAST);
		north.add(northWest, BorderLayout.WEST);
		SessionStartButton start = new SessionStartButton(this);
		this.getCenter().add(start);
		this.getMainCenter().add(this.getCenter(), BorderLayout.CENTER);
		this.getMainCenter().add(north, BorderLayout.NORTH);
		super.add(this.getMainCenter(), BorderLayout.CENTER);
	}

	public void switchCenter(String switchCommand) {
		super.setVisible(false);
		this.getMainCenter().remove(this.getCenter());
		this.setCenter(new GamePanel(new LineBorder(Color.BLACK, 1), null,
				Color.YELLOW));
		switch (switchCommand) {
		case "Start": {
			this.getAufloesen().setEnabled(true);
			for (Wort wort : this.getData().getSitzung().getBenutzer()
					.getWortliste().getWoerter()) {
				this.getData().getWortArray().add(wort.getName());
			}
			ArrayList<String> list = this.getData().getWortArray();
			Collections.shuffle(list, new Random(System.currentTimeMillis()));
			this.getData().setWortArray(list);
			String str = this.getData().getWortArray()
					.get(this.getData().getWortIndex());
			int pointOfStart = this.checkWordLength(str);
			this.setGameLabel(str, pointOfStart);
			int pointOfEnd = pointOfStart + (str.length() * 65)
					+ ((str.length() - 1) * 10);
			TextLabel label = new TextLabel(this.getData().getSitzung()
					.getBenutzer().getWortliste().getName(), new Font("Tahoma",
					Font.BOLD, 35), SwingConstants.CENTER);
			label.setBounds(pointOfStart, 710, pointOfEnd - pointOfStart, 65);
			this.getCenter().add(label);
			break;
		}
		case "Auflösen": {
			this.getAufloesen().setEnabled(false);
			SessionContinueButton weiter = new SessionContinueButton(this);
			this.getCenter().add(weiter);
			for (int i = 0; i < this.getData().getPlaceList().size(); i++) {
				this.getCenter().add(this.getData().getPlaceList().get(i));
			}
			String str = BuchstabensalatPanel.this.getData().getWortArray()
					.get(BuchstabensalatPanel.this.getData().getWortIndex());
			for (int i = 0; i < str.length(); i++) {
				SolutionGameLabel sl = new SolutionGameLabel(i, str.charAt(i));
				this.getCenter().add(sl);
			}
			break;
		}
		case "Weiter": {
			this.getAufloesen().setEnabled(true);
			this.getData().setLetterList(new ArrayList<LetterGameLabel>());
			this.getData().setPlaceList(new ArrayList<PlaceGameLabel>());
			String str = this.getData().getWortArray()
					.get(this.getData().getWortIndex());
			int pointOfStart = this.checkWordLength(str);
			this.setGameLabel(str, pointOfStart);
			int pointOfEnd = pointOfStart + (str.length() * 65)
					+ ((str.length() - 1) * 10);
			TextLabel label = new TextLabel(this.getData().getSitzung()
					.getBenutzer().getWortliste().getName(), new Font("Tahoma",
					Font.BOLD, 35), SwingConstants.CENTER);
			label.setBounds(pointOfStart, 710, pointOfEnd - pointOfStart, 65);
			this.getCenter().add(label);
			break;
		}
		}
		this.getMainCenter().add(this.getCenter(), BorderLayout.CENTER);
		super.setVisible(true);
	}

	private int checkWordLength(String str) {
		int pointOfStart = 0;
		if (str.length() % 2 == 0) {
			pointOfStart = (770 - 5) - (65 * (str.length() / 2))
					- (((str.length() / 2) - 1) * 10);
		} else {
			pointOfStart = (770 - (65 / 2) - (65 * (str.length() / 2)) - ((str
					.length() / 2) * 10));
		}
		return pointOfStart;
	}

	private void setGameLabel(String str, int pointOfStart) {
		switch (this.getData().getSitzung().getSchwierigkeit().getName()) {
		case "leicht": {
			int zaehler = str.length() / 2;
			if (str.length() % 2 != 0) {
				zaehler = zaehler + 1;
			}
			for (int i = 0; i < str.length(); i++) {
				if (i < zaehler) {
					new LetterGameLabel(str.charAt(i));
				} else {
					LetterGameLabel l = new LetterGameLabel(str.charAt(i));
					this.getCenter().add(l);
				}
			}
			for (int i = 0; i < str.length(); i++) {
				if (i < zaehler) {
					PlaceGameLabel pl = new PlaceGameLabel(pointOfStart,
							str.charAt(i));
					this.getCenter().add(pl);
				} else {
					PlaceGameLabel pl = new PlaceGameLabel(pointOfStart);
					this.getCenter().add(pl);
				}
			}
			break;
		}
		case "mittel": {
			int zaehler = str.length() / 3;
			if (str.length() % 3 != 0) {
				zaehler = zaehler + 1;
			}
			int[] random = new int[zaehler];
			for (int i = 0; i < random.length; i++) {
				double randomDouble = Math.random();
				int randomInt = (int) (randomDouble * str.length());
				for (int j = 0; j < random.length; j++) {
					if (random[j] == randomInt) {
						i = i - 1;
						break;
					}
					if (j == random.length - 1) {
						random[i] = randomInt;
					}
				}
			}
			for (int i = 0; i < str.length(); i++) {
				boolean isLetterSet = false;
				for (int j = 0; j < random.length; j++) {
					if (i == random[j]) {
						new LetterGameLabel(str.charAt(i));
						isLetterSet = true;
					}
				}
				if (!isLetterSet) {
					LetterGameLabel l = new LetterGameLabel(str.charAt(i));
					this.getCenter().add(l);
				}
			}
			for (int i = 0; i < str.length(); i++) {
				boolean isLetterSet = false;
				for (int j = 0; j < random.length; j++) {
					if (i == random[j]) {
						PlaceGameLabel pl = new PlaceGameLabel(pointOfStart,
								str.charAt(i));
						this.getCenter().add(pl);
						isLetterSet = true;
					}
				}
				if (!isLetterSet) {
					PlaceGameLabel pl = new PlaceGameLabel(pointOfStart);
					this.getCenter().add(pl);
				}
			}
			break;
		}
		case "schwer": {
			for (int i = 0; i < str.length(); i++) {
				LetterGameLabel l = new LetterGameLabel(str.charAt(i));
				this.getCenter().add(l);
			}
			for (int i = 0; i < str.length(); i++) {
				PlaceGameLabel pl = new PlaceGameLabel(pointOfStart);
				this.getCenter().add(pl);
			}
			break;
		}
		}
	}
}