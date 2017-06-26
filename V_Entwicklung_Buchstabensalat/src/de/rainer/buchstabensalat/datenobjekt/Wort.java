package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.rainer.buchstabensalat.datenbank.DbManager;

public class Wort {

	private int wort_id;
	private String name;
	private int wortliste_id;

	private int getWort_id() {
		return this.wort_id;
	}

	private void setWort_id(int wort_id) {
		this.wort_id = wort_id;
	}

	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getWortliste_id() {
		return this.wortliste_id;
	}

	private void setWortliste_id(int wortliste_id) {
		this.wortliste_id = wortliste_id;
	}

	public Wort(int wort_id, String name, int wortliste_id) {
		super();
		this.setWort_id(wort_id);
		this.setName(name);
		this.setWortliste_id(wortliste_id);
	}

	public Wort() {
		this(0, "name", 0);
	}

	@Override
	public String toString() {
		return "Wort [wort_id=" + this.getWort_id() + ", name="
				+ this.getName() + ", wortliste_id=" + this.getWortliste_id()
				+ "]";
	}

	public ArrayList<Wort> getWoerterByWortlisteId(int wortliste_id) {
		ArrayList<Wort> wortArray = new ArrayList<Wort>();
		ResultSet rst = DbManager
				.getInstance()
				.getDml()
				.select("SELECT * FROM Wort WHERE wortliste_id = "
						+ wortliste_id);
		try {
			while (rst.next()) {
				wortArray.add(new Wort(rst.getInt("wort_id"), new Wortliste()
						.checkUmlaute(rst.getString("name")), wortliste_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().getDbCon().closeResultSet(rst);
		}
		return wortArray;
	}
}