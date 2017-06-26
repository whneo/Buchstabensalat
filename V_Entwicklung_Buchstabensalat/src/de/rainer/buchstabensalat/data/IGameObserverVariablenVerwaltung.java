package de.rainer.buchstabensalat.data;

public interface IGameObserverVariablenVerwaltung extends
		IGameObserverVerwaltung {
	public abstract String getCommand();

	public abstract void setCommand(String command);
}
