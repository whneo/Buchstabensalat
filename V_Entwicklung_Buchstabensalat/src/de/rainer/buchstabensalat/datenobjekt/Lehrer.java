package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public class Lehrer {

	private int lehrer_id;
	private String login;
	private String passwort;

	public int getLehrer_Id() {
		return this.lehrer_id;
	}

	public void setLehrer_Id(int lehrer_id) {
		this.lehrer_id = lehrer_id;
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

	public Lehrer(int lehrer_id, String login, String passwort) {
		super();
		this.setLehrer_Id(lehrer_id);
		this.setLogin(login);
		this.setPasswort(passwort);
	}

	public Lehrer() {
		this(0, "login", "passwort");
	}

	public Lehrer(String login, String passwort) {
		this(0, login, passwort);
	}

	@Override
	public String toString() {
		return "Lehrer [lehrer_id=" + this.getLehrer_Id() + ", login="
				+ this.getLogin() + ", passwort=" + this.getPasswort() + "]";
	}

	public Lehrer getLehrerById(int lehrer_id) {
		Lehrer lehrer = new Lehrer();
		ResultSet rst = WortsalatDbManager.getInstance().getDbh()
				.select("SELECT * FROM Lehrer WHERE lehrer_id = " + lehrer_id);
		try {
			while (rst.next()) {
				lehrer.setLehrer_Id(lehrer_id);
				lehrer.setLogin(rst.getString("login"));
				lehrer.setPasswort(rst.getString("passwort"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			WortsalatDbManager.getInstance().getDbh().getDbc()
					.closeResultSet(rst);
		}
		return lehrer;
	}
}