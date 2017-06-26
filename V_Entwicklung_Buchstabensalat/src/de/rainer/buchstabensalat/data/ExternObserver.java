package de.rainer.buchstabensalat.data;

import java.util.ArrayList;

import de.rainer.buchstabensalat.schnittstelle.IExternObserver;
import de.rainer.buchstabensalat.schnittstelle.IExternObserverVariablenVerwaltung;

public class ExternObserver implements IExternObserverVariablenVerwaltung {

	private ArrayList<IExternObserver> externObserverList;
	private boolean finish;

	private ArrayList<IExternObserver> getExternObserverList() {
		return this.externObserverList;
	}

	private void setExternObserverList(
			ArrayList<IExternObserver> externObserverList) {
		this.externObserverList = externObserverList;
	}

	@Override
	public boolean isFinish() {
		return this.finish;
	}

	@Override
	public void setFinish(boolean finish) {
		this.finish = finish;
		if (finish) {
			this.notifyAllExternObserver();
		}
	}

	public ExternObserver(ArrayList<IExternObserver> externObserverList,
			boolean finish) {
		super();
		this.setExternObserverList(externObserverList);
		this.setFinish(finish);
	}

	public ExternObserver() {
		this(new ArrayList<IExternObserver>(), false);
	}

	@Override
	public void addExternObserver(IExternObserver externObserver) {
		this.getExternObserverList().add(externObserver);
	}

	@Override
	public void removeExternObserver(IExternObserver externObserver) {
		this.getExternObserverList().remove(externObserver);
	}

	@Override
	public void notifyAllExternObserver() {
		if (this.getExternObserverList().size() > 0) {
			for (int i = 0; i < this.getExternObserverList().size(); i++) {
				this.getExternObserverList().get(i).externUpdate();
			}
		}
	}

}
