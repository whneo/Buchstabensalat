package de.rainer.buchstabensalat.gui.label;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import de.rainer.buchstabensalat.data.DataProvider;

public abstract class ADynBuchstabenLabel extends JLabel {

	private static final long serialVersionUID = -9068158652150571367L;

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

	public ADynBuchstabenLabel(String text) {
		super(text);
		this.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.setFocusable(false);
	}

	public ADynBuchstabenLabel() {
		this("?");
	}

	protected Point createCords() {
		Point p = new Point((int) (Math.random() * 1465),
				(int) (Math.random() * 560));
		if (DataProvider.getInstance().getLetterList().size() != 0) {
			for (LetterGameLabel lgl : DataProvider.getInstance()
					.getLetterList()) {
				if (p.getX() >= lgl.getX() - 100
						&& p.getX() <= lgl.getX() + 100) {
					if (p.getY() >= lgl.getY() - 100
							&& p.getY() <= lgl.getY() + 100) {
						p = this.createCords();
						break;
					}
				}
			}
		}
		return p;
	}
}
