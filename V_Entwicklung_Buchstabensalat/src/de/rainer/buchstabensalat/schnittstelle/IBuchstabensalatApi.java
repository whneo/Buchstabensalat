package de.rainer.buchstabensalat.schnittstelle;

import de.rainer.buchstabensalat.data.DataProvider;
import de.rainer.buchstabensalat.data.IExternObserver;
import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;
import de.rainer.buchstabensalat.datenobjekt.Benutzer;
import de.rainer.buchstabensalat.datenobjekt.Statistik;
import de.rainer.buchstabensalat.gui.panel.MainPanel;

public interface IBuchstabensalatApi {

	public default MainPanel startBuchstabensalat(String login) {
		WortsalatDbManager.getInstance().createDatabase();
		DataProvider.getInstance().getSitzung()
				.setBenutzer(new Benutzer().getBenutzerByLogin(login));
		return new MainPanel();
	};

	public default void addExternObserver(IExternObserver externObserver) {
		DataProvider.getInstance().getExternObserver()
				.addExternObserver(externObserver);
	}

	public default Statistik getStatistik(String login) {
		Statistik statistik = new Statistik()
				.getStatsFromDbByBenutzerLogin(login);
		return statistik;
	}

}