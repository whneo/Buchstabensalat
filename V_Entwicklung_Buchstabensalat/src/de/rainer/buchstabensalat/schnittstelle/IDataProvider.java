package de.rainer.buchstabensalat.schnittstelle;

import de.rainer.buchstabensalat.data.DataProvider;

public interface IDataProvider {

	public final DataProvider DATA = DataProvider.getInstance();
}
