package de.rainer.buchstabensalat.schnittstelle;

public interface IExternObserverVerwaltung {
	public abstract void addExternObserver(IExternObserver externObserver);

	public abstract void removeExternObserver(IExternObserver externObserver);

	public abstract void notifyAllExternObserver();
}
