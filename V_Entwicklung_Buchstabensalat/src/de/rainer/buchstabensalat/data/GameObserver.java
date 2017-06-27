package de.rainer.buchstabensalat.data;

import java.util.ArrayList;

<<<<<<< HEAD
import de.rainer.buchstabensalat.schnittstelle.IGameObserver;
import de.rainer.buchstabensalat.schnittstelle.IGameObserverVariablenVerwaltung;

=======
>>>>>>> branch 'master' of https://github.com/whneo/Buchstabensalat.git
public class GameObserver implements IGameObserverVariablenVerwaltung {

	private ArrayList<IGameObserver> gameObserverList;
	private String command;

	private ArrayList<IGameObserver> getGameObserverList() {
		return this.gameObserverList;
	}

	private void setGameObserverList(ArrayList<IGameObserver> gameObserverList) {
		this.gameObserverList = gameObserverList;
	}

	@Override
	public String getCommand() {
		return this.command;
	}

	@Override
	public void setCommand(String command) {
		this.command = command;
		this.notifyAllGameObserver(command);
	}

	public GameObserver(ArrayList<IGameObserver> gameObserverList,
			String command) {
		super();
		this.setGameObserverList(gameObserverList);
		this.setCommand(command);
	}

	public GameObserver() {
		this(new ArrayList<IGameObserver>(), "");
	}

	@Override
	public void addGameObserver(IGameObserver gameObserver) {
		this.getGameObserverList().add(gameObserver);
	}

	@Override
	public void removeGameObserver(IGameObserver gameObserver) {
		this.getGameObserverList().remove(gameObserver);
	}

	@Override
	public void notifyAllGameObserver(String str) {
		if (this.getGameObserverList().size() > 0) {
			for (int i = 0; i < this.getGameObserverList().size(); i++) {
				this.getGameObserverList().get(i).gameUpdate(str);
			}
		}
	}

}
