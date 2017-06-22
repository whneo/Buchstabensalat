package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class FieldButton extends MainButton {

	private static final long serialVersionUID = 2674832688973818013L;

	public FieldButton(String text, ActionListener al, Color bColor, Point point) {
		super(text, new Font("Tahoma", Font.BOLD, 30), false, true, true, al);
		this.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBackground(bColor);
		this.setBounds((int) point.getX(), (int) point.getY(), 200, 100);
	}

	public FieldButton() {
		this("defaultText", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}, Color.BLACK, new Point(0, 0));
	}
}
