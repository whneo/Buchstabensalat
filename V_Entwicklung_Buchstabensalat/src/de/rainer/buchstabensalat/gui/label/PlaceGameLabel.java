package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import de.rainer.buchstabensalat.data.DataProvider;

public final class PlaceGameLabel extends AStatBuchstabenLabel {

	private static final long serialVersionUID = 1L;

	public PlaceGameLabel(int x, char text) {
		super("" + text, Color.LIGHT_GRAY);
		if (DataProvider.getInstance().getPlaceList().size() != 0) {
			x = DataProvider.getInstance().getPlaceList()
					.get(DataProvider.getInstance().getPlaceList().size() - 1)
					.getX() + 75;
		}
		this.setBounds(x, 635, LETTER_LABEL_SIZE, LETTER_LABEL_SIZE);
		DataProvider.getInstance().getPlaceList().add(this);
	}

	public PlaceGameLabel(int x) {
		this(x, '?');
	}

	private Point linkeEckeOben(JLabel label) {
		return label.getLocation();
	}

	private Point linkeEckeUnten(JLabel label) {
		return new Point((int) label.getLocation().getX(), (int) label
				.getLocation().getY() + 65);
	}

	private Point rechteEckeOben(JLabel label) {
		return new Point((int) label.getLocation().getX() + 65, (int) label
				.getLocation().getY());
	}

	private Point rechteEckeUnten(JLabel label) {
		return new Point((int) label.getLocation().getX() + 65, (int) label
				.getLocation().getY() + 65);
	}

	public void intersect(LetterGameLabel lgl) {
		Rectangle raOrigin = new Rectangle(lgl.getWidth(), lgl.getHeight());
		Point letterLo = this.linkeEckeOben(lgl);
		Point letterLu = this.linkeEckeUnten(lgl);
		Point letterRo = this.rechteEckeOben(lgl);
		Point letterRu = this.rechteEckeUnten(lgl);
		for (int i = 0; i < DataProvider.getInstance().getPlaceList().size(); i++) {
			PlaceGameLabel pgl = DataProvider.getInstance().getPlaceList()
					.get(i);
			if (pgl.getText().equals("")) {
				Point placeLo = this.linkeEckeOben(pgl);
				Point placeLu = this.linkeEckeUnten(pgl);
				Point placeRo = this.rechteEckeOben(pgl);
				Point placeRu = this.rechteEckeUnten(pgl);
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