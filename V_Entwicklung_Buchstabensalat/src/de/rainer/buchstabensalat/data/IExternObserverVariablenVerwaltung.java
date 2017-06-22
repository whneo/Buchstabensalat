package de.rainer.buchstabensalat.data;

public interface IExternObserverVariablenVerwaltung extends
		IExternObserverVerwaltung {
	public abstract boolean isFinish();

	public abstract void setFinish(boolean finish);
}
