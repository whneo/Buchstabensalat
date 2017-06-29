package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.rainer.buchstabensalat.datenbank.DbManager;

public final class Wortliste {

	private int wortliste_id;
	private String name;
	private ArrayList<Wort> woerter;

	int getWortliste_id() {
		return this.wortliste_id;
	}

	public void setWortliste_id(int wortliste_id) {
		this.wortliste_id = wortliste_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Wort> getWoerter() {
		return this.woerter;
	}

	public void setWoerter(ArrayList<Wort> woerter) {
		this.woerter = woerter;
	}

	public Wortliste(int wortliste_id, String name, ArrayList<Wort> woerter) {
		super();
		this.setWortliste_id(wortliste_id);
		this.setName(name);
		this.setWoerter(woerter);
	}

	public Wortliste() {
		this(0, "name", new ArrayList<Wort>());
	}

	@Override
	public String toString() {
		return "Wortliste [wortliste_id=" + this.getWortliste_id() + ", name="
				+ this.getName() + ", woerter=" + this.getWoerter().toString()
				+ "]";
	}

	public Wortliste getWortlisteById(int wortliste_id) {
		Wortliste wortliste = new Wortliste();
		ResultSet rst = DbManager
				.getInstance()
				.getDml()
				.select("SELECT * FROM Wortliste WHERE wortliste_id = "
						+ wortliste_id);
		try {
			while (rst.next()) {
				wortliste.setWortliste_id(wortliste_id);
				wortliste.setName(this.checkUmlaute(rst.getString("name")));
				wortliste.setWoerter(new Wort()
						.getWoerterByWortlisteId(wortliste_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().getDbCon().closeResultSet(rst);
		}
		return wortliste;
	}

	String checkUmlaute(String str) {
		String strNeu = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '&') {
				switch (str.charAt(i + 1)) {
				case 'a': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "ä";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 'A': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "Ä";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 'o': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "ö";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 'O': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "Ö";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 'u': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "ü";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 'U': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "Ü";
					strNeu = strNeu + str.substring(i + 6);
					break;
				}
				case 's': {
					strNeu = str.substring(0, i);
					strNeu = strNeu + "ß";
					strNeu = strNeu + str.substring(i + 7);
					break;
				}
				default:
					break;
				}
			}
		}
		if (strNeu.equals("")) {
			strNeu = str;
		}
		return strNeu;
	}
}