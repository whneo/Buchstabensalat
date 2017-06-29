package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.rainer.buchstabensalat.datenbank.DbManager;

public final class Benutzer {

	private int benutzer_id;
	private String login;
	private String passwort;
	private String vorname;
	private String nachname;
	private int maximale_Spielzeit;
	private Eltern eltern;
	private Wortliste wortliste;
	private Lehrer lehrer;

	public int getBenutzer_Id() {
		return this.benutzer_id;
	}

	public void setBenutzer_Id(int benutzer_id) {
		this.benutzer_id = benutzer_id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	private String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	private String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	private int getMaximale_Spielzeit() {
		return this.maximale_Spielzeit;
	}

	public void setMaximale_Spielzeit(int maximale_Spielzeit) {
		this.maximale_Spielzeit = maximale_Spielzeit;
	}

	public Eltern getEltern() {
		return this.eltern;
	}

	public void setEltern(Eltern eltern) {
		this.eltern = eltern;
	}

	public Wortliste getWortliste() {
		return this.wortliste;
	}

	public void setWortliste(Wortliste wortliste) {
		this.wortliste = wortliste;
	}

	public Lehrer getLehrer() {
		return this.lehrer;
	}

	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}

	public Benutzer(int benutzer_id, String login, String passwort,
			String vorname, String nachname, int maximale_Spielzeit,
			Eltern eltern, Wortliste wortliste, Lehrer lehrer) {
		super();
		this.setBenutzer_Id(benutzer_id);
		this.setLogin(login);
		this.setPasswort(passwort);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setMaximale_Spielzeit(maximale_Spielzeit);
		this.setEltern(eltern);
		this.setWortliste(wortliste);
		this.setLehrer(lehrer);
	}

	public Benutzer() {
		this(0, "login", "passwort", "vorname", "nachname", 0, new Eltern(),
				new Wortliste(), new Lehrer());
	}

	@Override
	public String toString() {
		return "Kind [benutzer_id=" + this.getBenutzer_Id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort()
				+ ", vorname=" + this.getVorname() + ", nachname="
				+ this.getNachname() + ", maximale_Spielzeit"
				+ this.getMaximale_Spielzeit() + ", eltern="
				+ this.getEltern().toString() + ", wortliste="
				+ this.getWortliste().toString() + ", lehrer="
				+ this.getLehrer().toString() + "]";
	}

	public Benutzer getBenutzerByLogin(String login) {
		Benutzer benutzer = new Benutzer();
		String query = "SELECT * FROM Benutzer WHERE login = '" + login + "'";
		ResultSet rst = DbManager.getInstance().getDml().select(query);
		try {
			if (rst.next()) {
				benutzer.setBenutzer_Id(rst.getInt("benutzer_id"));
				benutzer.setLogin(rst.getString("login"));
				benutzer.setPasswort(rst.getString("passwort"));
				benutzer.setVorname(rst.getString("vorname"));
				benutzer.setNachname(rst.getString("nachname"));
				benutzer.setMaximale_Spielzeit(rst.getInt("maximale_Spielzeit"));
				benutzer.setEltern(benutzer.getEltern().getElternById(
						rst.getInt("eltern_id")));
				benutzer.setWortliste(benutzer.getWortliste().getWortlisteById(
						rst.getInt("wortliste_id")));
				benutzer.setLehrer(benutzer.getLehrer().getLehrerById(
						rst.getInt("lehrer_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().getDbCon().closeResultSet(rst);
		}
		return benutzer;
	}
}