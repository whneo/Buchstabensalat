package de.rainer.buchstabensalat.gui.label.funktional.logik;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.label.funktional.LetterGameLabel;
import de.rainer.buchstabensalat.gui.label.funktional.PlaceGameLabel;

public class PlaceGameLabelLogik {

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

	public static void intersect(LetterGameLabel lgl) {
		Rectangle raOrigin = new Rectangle(lgl.getWidth(), lgl.getHeight());
		Point letterLo = LetterGameLabelLogik.linkeEckeOben(lgl);
		Point letterLu = LetterGameLabelLogik.linkeEckeUnten(lgl);
		Point letterRo = LetterGameLabelLogik.rechteEckeOben(lgl);
		Point letterRu = LetterGameLabelLogik.rechteEckeUnten(lgl);
		for (int i = 0; i < DataProvider.getInstance().getPlaceList().size(); i++) {
			PlaceGameLabel pgl = DataProvider.getInstance().getPlaceList()
					.get(i);
			if (pgl.getText().equals("")) {
				Point placeLo = PlaceGameLabelLogik.linkeEckeOben(pgl);
				Point placeLu = PlaceGameLabelLogik.linkeEckeUnten(pgl);
				Point placeRo = PlaceGameLabelLogik.rechteEckeOben(pgl);
				Point placeRu = PlaceGameLabelLogik.rechteEckeUnten(pgl);
				if ((letterLo.getX() >= (int) placeLo.getX() && letterLo.getY() >= (int) placeLo
						.getY())
						&& (letterLo.getX() <= (int) placeRu.getX() && letterLo
								.getY() <= (int) placeRu.getY())) {
					Rectangle raIntersect = new Rectangle(
							((int) placeRu.getX()) - ((int) letterLo.getX()),
							((int) placeRu.getY()) - ((int) letterLo.getY()));
					if ((raIntersect.getSize().getHeight() * raIntersect
							.getSize().getWidth()) >= (raOrigin.getSize()
							.getHeight() * raOrigin.getSize().getWidth()) / 2) {
						lgl.setLocation(pgl.getLocation());
						pgl.setText(lgl.getText());
						lgl.removeMouseListener(lgl.getMouseListeners()[0]);
						lgl.removeMouseMotionListener(lgl
								.getMouseMotionListeners()[0]);
						lgl.setForeground(Color.GRAY);
						pgl.setLocation(lgl.getLocation());
						lgl.setVisible(false);
						DataProvider.getInstance().getLetterList().set(i, lgl);
						break;
					}
				}
				if ((letterLu.getX() >= (int) placeLo.getX() && letterLu.getY() >= (int) placeLo
						.getY())
						&& (letterLu.getX() <= (int) placeRu.getX() && letterLu
								.getY() <= (int) placeRu.getY())) {
					Rectangle raIntersect = new Rectangle(
							((int) placeRo.getX()) - ((int) letterLu.getX()),
							((int) letterLu.getY()) - ((int) placeRo.getY()));
					if ((raIntersect.getSize().getHeight() * raIntersect
							.getSize().getWidth()) >= (raOrigin.getSize()
							.getHeight() * raOrigin.getSize().getWidth()) / 2) {
						lgl.setLocation(pgl.getLocation());
						pgl.setText(lgl.getText());
						lgl.removeMouseListener(lgl.getMouseListeners()[0]);
						lgl.removeMouseMotionListener(lgl
								.getMouseMotionListeners()[0]);
						lgl.setForeground(Color.GRAY);
						pgl.setLocation(lgl.getLocation());
						lgl.setVisible(false);
						DataProvider.getInstance().getLetterList().set(i, lgl);
						break;
					}
				}
				if ((letterRo.getX() >= (int) placeLo.getX() && letterRo.getY() >= (int) placeLo
						.getY())
						&& (letterRo.getX() <= (int) placeRu.getX() && letterRo
								.getY() <= (int) placeRu.getY())) {
					Rectangle raIntersect = new Rectangle(
							((int) letterRo.getX()) - ((int) placeLu.getX()),
							((int) placeLu.getY()) - ((int) letterRo.getY()));
					if ((raIntersect.getSize().getHeight() * raIntersect
							.getSize().getWidth()) >= (raOrigin.getSize()
							.getHeight() * raOrigin.getSize().getWidth()) / 2) {
						lgl.setLocation(pgl.getLocation());
						pgl.setText(lgl.getText());
						lgl.removeMouseListener(lgl.getMouseListeners()[0]);
						lgl.removeMouseMotionListener(lgl
								.getMouseMotionListeners()[0]);
						lgl.setForeground(Color.GRAY);
						pgl.setLocation(lgl.getLocation());
						lgl.setVisible(false);
						DataProvider.getInstance().getLetterList().set(i, lgl);
						break;
					}
				}
				if ((letterRu.getX() >= (int) placeLo.getX() && letterRu.getY() >= (int) placeLo
						.getY())
						&& (letterRu.getX() <= (int) placeRu.getX() && letterRu
								.getY() <= (int) placeRu.getY())) {
					Rectangle raIntersect = new Rectangle(
							((int) letterRu.getX()) - ((int) placeLo.getX()),
							((int) letterRu.getY()) - ((int) placeLo.getY()));
					if ((raIntersect.getSize().getHeight() * raIntersect
							.getSize().getWidth()) >= (raOrigin.getSize()
							.getHeight() * raOrigin.getSize().getWidth()) / 2) {
						lgl.setLocation(pgl.getLocation());
						pgl.setText(lgl.getText());
						lgl.removeMouseListener(lgl.getMouseListeners()[0]);
						lgl.removeMouseMotionListener(lgl
								.getMouseMotionListeners()[0]);
						lgl.setForeground(Color.GRAY);
						pgl.setLocation(lgl.getLocation());
						lgl.setVisible(false);
						DataProvider.getInstance().getLetterList().set(i, lgl);
						break;
					}
				}
			}
		}
	}
}
