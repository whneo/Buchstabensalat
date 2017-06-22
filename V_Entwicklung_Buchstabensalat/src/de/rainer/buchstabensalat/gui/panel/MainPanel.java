package de.rainer.buchstabensalat.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.data.IGameObserver;

public class MainPanel extends JPanel implements IGameObserver {

	private static final long serialVersionUID = 1L;
	private JPanel main;

	private JPanel getMain() {
		return main;
	}

	private void setMain(JPanel main) {
		this.main = main;
	}

	public MainPanel(JPanel main) {
		super();
		DataProvider.getInstance().getGameObserver().addGameObserver(this);
		this.setMain(main);
		this.init();
	}

	public MainPanel() {
		this(new GamePanel(new LineBorder(Color.BLACK, 2), new BorderLayout(),
				Color.YELLOW));
	}

	private void init() {
		super.setLayout(new BorderLayout());
		super.setBorder(new LineBorder(Color.BLACK, 2));
		GamePanel north = new GamePanel(Color.WHITE);
		GamePanel south = new GamePanel(Color.WHITE);
		GamePanel east = new GamePanel(Color.WHITE);
		GamePanel west = new GamePanel(Color.WHITE);
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