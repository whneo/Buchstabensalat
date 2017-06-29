package de.rainer.buchstabensalat.data;

public interface IGameObserverVerwaltung {
	public abstract void addGameObserver(IGameObserver gameObserver);

	public abstract void removeGameObserver(IGameObserver gameObserver);

	public abstract void notifyAllGameObserver(String str);
}
