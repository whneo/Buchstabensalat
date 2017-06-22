package de.rainer.buchstabensalat.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.gui.button.AbbruchButton;
import de.rainer.buchstabensalat.gui.button.SchwierigkeitButton;
import de.rainer.buchstabensalat.gui.label.GameTextLabel;
import de.rainer.buchstabensalat.gui.panel.GamePanel;

public class SchwierigkeitDialog extends JDialog {

	private static final long serialVersionUID = 8274285215416744440L;

	public SchwierigkeitDialog() {
		super();
		this.init();
	}

	private void init() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int width = 500;
		int height = 150;
		int x = (int) ((d.getWidth() - width) / 2);
		int y = (int) (((d.getHeight() - height) / 2) + 40);
		super.setBounds(x, y, width, height);
		super.setUndecorated(true);
		super.setModal(true);
		GamePanel panel = new GamePanel(new LineBorder(Color.BLACK, 2),
				new BorderLayout(), Color.WHITE);
		GamePanel labelPanel = new GamePanel(Color.WHITE);
		GameTextLabel label = new GameTextLabel("Schwierigkeitsgrad", new Font(
				"Tahoma", Font.BOLD, 30));
		labelPanel.add(label);
		GamePanel buttonPanel = new GamePanel(Color.WHITE);
		SchwierigkeitButton lButton = new SchwierigkeitButton("leicht", this);
		// lButton.addActionListener(new SchwierigkeitButtonActionListener(this));
		// lButton.addKeyListener(new SchwierigkeitButtonActionListener(this));
		SchwierigkeitButton mButton = new SchwierigkeitButton("mittel", this);
		// mButton.addActionListener(new SchwierigkeitButtonActionListener(this));
		// mButton.addKeyListener(new SchwierigkeitButtonActionListener(this));
		SchwierigkeitButton sButton = new SchwierigkeitButton("schwer", this);
		// sButton.addActionListener(new SchwierigkeitButtonActionListener(this));
		// sButton.addKeyListener(new SchwierigkeitButtonActionListener(this));
//		SchwierigkeitButton abbruch = new SchwierigkeitButton("abbruch", this);
		AbbruchButton abbruch = new AbbruchButton(this);
		// abbruch.addActionListener(new SchwierigkeitButtonActionListener(this,
		// true));
		// abbruch.addKeyListener(new SchwierigkeitButtonActionListener(this, true));
		buttonPanel.add(lButton);
		buttonPanel.add(mButton);
		buttonPanel.add(sButton);
		buttonPanel.add(abbruch);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		panel.add(labelPanel, BorderLayout.CENTER);
		super.add(panel);
		super.setVisible(true);
	}
}