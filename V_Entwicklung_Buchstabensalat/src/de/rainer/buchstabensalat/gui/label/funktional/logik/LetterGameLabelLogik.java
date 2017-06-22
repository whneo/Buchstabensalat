package de.rainer.buchstabensalat.gui.label.funktional.logik;

import java.awt.Point;

import javax.swing.JLabel;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.label.funktional.LetterGameLabel;

public class LetterGameLabelLogik {

	public static Point linkeEckeOben(JLabel label) {
		return label.getLocation();
	}

	public static Point linkeEckeUnten(JLabel label) {
		return new Point((int) label.getLocation().getX(), (int) label
				.getLocation().getY() + 65);
	}

	public static Point rechteEckeOben(JLabel label) {
		return new Point((int) label.getLocation().getX() + 65, (int) label
				.getLocation().getY());
	}

	public static Point rechteEckeUnten(JLabel label) {
		return new Point((int) label.getLocation().getX() + 65, (int) label
				.getLocation().getY() + 65);
	}

	public static Point createCords() {
		Point p = new Point((int) (Math.random() * 1465),
				(int) (Math.random() * 560));
		if (DataProvider.getInstance().getLetterList().size() != 0) {
			for (LetterGameLabel lgl : DataProvider.getInstance()
					.getLetterList()) {
				if (p.getX() >= lgl.getX() - 100
						&& p.getX() <= lgl.getX() + 100) {
					if (p.getY() >= lgl.getY() - 100
							&& p.getY() <= lgl.getY() + 100) {
						p = LetterGameLabelLogik.createCords();
						break;
					}
				}
			}
		}
		return p;
	}
}
