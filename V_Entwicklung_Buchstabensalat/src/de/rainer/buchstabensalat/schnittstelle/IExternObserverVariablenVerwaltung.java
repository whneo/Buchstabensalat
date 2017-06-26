package de.rainer.buchstabensalat.schnittstelle;

public interface IExternObserverVariablenVerwaltung extends
		IExternObserverVerwaltung {
	public abstract boolean isFinish();

	public abstract void setFinish(boolean finish);
}
