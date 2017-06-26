package de.rainer.buchstabensalat.schnittstelle;

public interface IGameObserverVerwaltung {
	public abstract void addGameObserver(IGameObserver gameObserver);

	public abstract void removeGameObserver(IGameObserver gameObserver);

	public abstract void notifyAllGameObserver(String str);
}
