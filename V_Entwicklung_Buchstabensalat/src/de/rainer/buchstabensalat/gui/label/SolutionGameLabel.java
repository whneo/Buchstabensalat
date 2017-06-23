package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;

import de.rainer.buchstabensalat.data.DataProvider;

public final class SolutionGameLabel extends AStatBuchstabenLabel {

	private static final long serialVersionUID = 1L;

	public SolutionGameLabel(int i, char text) {
		super("" + text, Color.BLACK);
		int x = DataProvider.getInstance().getPlaceList().get(i).getX();
		this.setBounds(x, 710, LETTER_LABEL_SIZE, LETTER_LABEL_SIZE);
	}
}