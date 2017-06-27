package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
<<<<<<< HEAD
import de.rainer.buchstabensalat.schnittstelle.IGameObserver;
=======
import de.rainer.buchstabensalat.data.IGameObserver;
>>>>>>> branch 'master' of https://github.com/whneo/Buchstabensalat.git

public class MainPanel extends DefaultPanel implements IGameObserver {

	private static final long serialVersionUID = 1L;
	private JPanel main;

	private JPanel getMain() {
		return main;
	}

	private void setMain(JPanel main) {
		this.main = main;
	}

	public MainPanel(JPanel main) {
		super(new LineBorder(Color.BLACK, 2), new BorderLayout(), Color.WHITE);
		DataProvider.getInstance().getGameObserver().addGameObserver(this);
		this.setMain(main);
		this.init();
	}

	public MainPanel() {
		this(new DefaultPanel(new LineBorder(Color.BLACK, 2),
				new BorderLayout(), Color.YELLOW));
	}

	private void init() {
		DefaultPanel north = new DefaultPanel(Color.WHITE);
		DefaultPanel south = new DefaultPanel(Color.WHITE);
		DefaultPanel east = new DefaultPanel(Color.WHITE);
		DefaultPanel west = new DefaultPanel(Color.WHITE);
		this.setMain(new StartPanel());
		super.add(north, BorderLayout.NORTH);
		super.add(south, BorderLayout.SOUTH);
		super.add(east, BorderLayout.EAST);
		super.add(west, BorderLayout.WEST);
		super.add(this.getMain(), BorderLayout.CENTER);
	}

	@Override
	public void gameUpdate(String str) {
		this.switchMain(str);
	}

	private void switchMain(String str) {
		super.setVisible(false);
		super.remove(this.getMain());
		if (str.equals("Weiter") || str.equals("Spiel beenden")) {
			this.setMain(new SpielendePanel());
		} else {
			if (str.equals("Nochmal")) {
				this.setMain(new StartPanel());
			} else {
				this.setMain(new BuchstabensalatPanel());
			}
		}
		super.add(this.getMain(), BorderLayout.CENTER);
		super.setVisible(true);
	}
}