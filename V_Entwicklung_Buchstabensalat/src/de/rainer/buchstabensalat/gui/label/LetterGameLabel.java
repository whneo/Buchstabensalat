package de.rainer.buchstabensalat.gui.label;

import java.awt.Color;
import java.awt.Point;

import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.mouseadapter.LetterGameLabelMouseAdapter;

public final class LetterGameLabel extends ADynBuchstabenLabel {

	private static final long serialVersionUID = 7597040392189993326L;

	public LetterGameLabel(int labelX, int labelY, char text) {
		super("" + text);
		this.setBackground(Color.WHITE);
		this.setLabelX(labelX);
		this.setLabelY(labelY);
		Point p = this.createCords();
		int width_heigt = 65;
		this.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBounds((int) p.getX(), (int) p.getY(), width_heigt, width_heigt);
		this.addMouseListener(new LetterGameLabelMouseAdapter(this));
		this.addMouseMotionListener(new LetterGameLabelMouseAdapter(this));
		DataProvider.getInstance().getLetterList().add(this);
	}

	public LetterGameLabel(char text) {
		this(0, 0, text);
	}
}