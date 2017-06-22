package de.rainer.buchstabensalat.gui.mouseadapter;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import de.rainer.buchstabensalat.gui.label.funktional.LetterGameLabel;
import de.rainer.buchstabensalat.gui.label.funktional.logik.PlaceGameLabelLogik;

public class LetterGameLabelMouseAdapter extends MouseAdapter {

	private LetterGameLabel lgl;

	private LetterGameLabel getLgl() {
		return this.lgl;
	}

	private void setLgl(LetterGameLabel lgl) {
		this.lgl = lgl;
	}

	public LetterGameLabelMouseAdapter(LetterGameLabel lgl) {
		super();
		this.setLgl(lgl);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.getLgl().setLabelX(e.getX());
		this.getLgl().setLabelY(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		PlaceGameLabelLogik.intersect((LetterGameLabel) e.getSource());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Rectangle r = this.getLgl().getBounds();
		this.getLgl().setBounds(
				(int) r.getX() + e.getX() - this.getLgl().getLabelX(),
				(int) r.getY() + e.getY() - this.getLgl().getLabelY(),
				this.getLgl().getWidth(), this.getLgl().getHeight());
		this.getLgl().repaint();
	}
}
