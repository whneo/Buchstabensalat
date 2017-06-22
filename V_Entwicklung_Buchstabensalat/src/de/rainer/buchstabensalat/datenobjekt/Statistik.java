package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.util.ArrayList;

import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public class Statistik {

	private Benutzer benutzer;
	private ArrayList<Sitzung> sitzungen;

	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public ArrayList<Sitzung> getSitzungen() {
		return sitzungen;
	}

	private void setSitzungen(ArrayList<Sitzung> sitzungen) {
		this.sitzungen = sitzungen;
	}

	public Statistik(Benutzer benutzer, ArrayList<Sitzung> sitzungen) {
		super();
		this.setBenutzer(benutzer);
		this.setSitzungen(sitzungen);
	}

	public Statistik() {
		this(new Benutzer(), new ArrayList<Sitzung>());
	}

	@Override
	public String toString() {
		return "Statistik [benutzer=" + this.getBenutzer() + ", sitzungen="
				+ this.getSitzungen().toString() + "]";
	}

	public Statistik getStatsFromDbByBenutzerLogin(String login) {
		Statistik statistik = new Statistik();
		statistik
				.setBenutzer(statistik.getBenutzer().getBenutzerByLogin(login));
		String query = "SELECT * FROM Sitzung WHERE benutzer_id = "
				+ statistik.getBenutzer().getBenutzer_Id();
		ResultSet rst = WortsalatDbManager.getInstance().getDbh().select(query);
		try {
			rst.beforeFirst();
			while (rst.next()) {
				statistik.getSitzungen().add(
						new Sitzung(rst.getInt("sitzung_id"), rst
								.getLong("spielBeginn"), rst
								.getLong("spielEnde"), rst
								.getInt("richtigeWorte"), rst
								.getInt("falscheWorte"), statistik
								.getBenutzer(), new Schwierigkeit(rst
								.getInt("schwierigkeit_id"), "")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			WortsalatDbManager.getInstance().getDbh().getDbc()
					.closeResultSet(rst);
		}
		return statistik;
	}
}