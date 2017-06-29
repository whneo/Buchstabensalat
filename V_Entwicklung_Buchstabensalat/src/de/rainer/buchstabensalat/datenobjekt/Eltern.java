package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.rainer.buchstabensalat.datenbank.DbManager;

public final class Eltern {

	private int eltern_id;
	private String login;
	private String passwort;

	public int getEltern_Id() {
		return this.eltern_id;
	}

	public void setEltern_Id(int eltern_id) {
		this.eltern_id = eltern_id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Eltern(int eltern_id, String login, String passwort) {
		super();
		this.setEltern_Id(eltern_id);
		this.setLogin(login);
		this.setPasswort(passwort);
	}

	public Eltern() {
		this(0, "login", "passwort");
	}

	public Eltern(String login, String passwort) {
		this(0, login, passwort);
	}

	@Override
	public String toString() {
		return "Eltern [eltern_id=" + this.getEltern_Id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort() + "]";
	}

	public Eltern getElternById(int eltern_id) {
		Eltern eltern = new Eltern();
		ResultSet rst = DbManager.getInstance().getDml()
				.select("SELECT * FROM Eltern WHERE eltern_id = " + eltern_id);
		try {
			while (rst.next()) {
				eltern.setEltern_Id(eltern_id);
				eltern.setLogin(rst.getString("login"));
				eltern.setPasswort(rst.getString("passwort"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().getDbCon().closeResultSet(rst);
		}
		return eltern;
	}
}