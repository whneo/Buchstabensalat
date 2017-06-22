package de.rainer.buchstabensalat.gui.label.funktional;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.gui.label.funktional.logik.LetterGameLabelLogik;
import de.rainer.buchstabensalat.gui.mouseadapter.LetterGameLabelMouseAdapter;

public class LetterGameLabel extends JLabel {

	private static final long serialVersionUID = 7597040392189993326L;
	private int labelX;
	private int labelY;

	public int getLabelX() {
		return this.labelX;
	}

	public void setLabelX(int labelX) {
		this.labelX = labelX;
	}

	public int getLabelY() {
		return this.labelY;
	}

	public void setLabelY(int labelY) {
		this.labelY = labelY;
	}

	public LetterGameLabel(int labelX, int labelY, char text) {
		super();
		this.setLabelX(labelX);
		this.setLabelY(labelY);
		this.init(text);
	}

	public LetterGameLabel() {
		this(0, 0, '?');
	}

	public LetterGameLabel(char text) {
		this(0, 0, text);
	}

	private void init(char text) {
		Point p = LetterGameLabelLogik.createCords();
		int width_heigt = 65;
		super.setHorizontalAlignment(SwingConstants.CENTER);
		super.setFont(new Font("Tahoma", Font.BOLD, 40));
		super.setBorder(new LineBorder(Color.BLACK, 1));
		super.setBounds((int) p.getX(), (int) p.getY(), width_heigt,
				width_heigt);
		super.setBackground(Color.WHITE);
		super.setText("" + text);
		super.setOpaque(true);
		super.addMouseListener(new LetterGameLabelMouseAdapter(this));
		super.addMouseMotionListener(new LetterGameLabelMouseAdapter(this));
		DataProvider.getInstance().getLetterList().add(this);
		super.setVisible(true);
	}
}