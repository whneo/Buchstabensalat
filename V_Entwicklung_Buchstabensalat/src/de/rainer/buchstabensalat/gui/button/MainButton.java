package de.rainer.buchstabensalat.gui.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainButton extends JButton {

	private static final long serialVersionUID = -2941781674394938188L;

	public MainButton(String text, Font font, boolean isFocusable,
			boolean isOpaque, boolean isEnable, ActionListener al) {
		super(text);
		this.setFont(font);
		this.setFocusable(isFocusable);
		this.setOpaque(isOpaque);
		this.setEnabled(isEnable);
		this.addActionListener(al);
	}

	public MainButton() {
		this("defaultText", new Font("Tahoma", Font.ITALIC, 5), false, false,
				true, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					}
				});
	}
}
