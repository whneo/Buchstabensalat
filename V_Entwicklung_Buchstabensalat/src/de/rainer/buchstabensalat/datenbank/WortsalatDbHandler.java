package de.rainer.buchstabensalat.datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.rainer.buchstabensalat.datenobjekt.Sitzung;

public class WortsalatDbHandler {

	private static WortsalatDbHandler instance;
	private WortsalatDbConnector dbc;

	static WortsalatDbHandler getInstance() {
		if (WortsalatDbHandler.instance == null) {
			WortsalatDbHandler.setInstance(new WortsalatDbHandler());
		}
		return WortsalatDbHandler.instance;
	}

	private static void setInstance(WortsalatDbHandler instance) {
		WortsalatDbHandler.instance = instance;
	}

	public WortsalatDbConnector getDbc() {
		return dbc;
	}

	private void setDbc(WortsalatDbConnector dbc) {
		this.dbc = dbc;
	}

	private WortsalatDbHandler(WortsalatDbConnector dbc) {
		super();
		this.setDbc(dbc);
	}

	private WortsalatDbHandler() {
		this(WortsalatDbConnector.getInstance());
	}

	public void insert(Sitzung sitzung) {
		PreparedStatement pst = null;
		Statement st = null;
		String sql = "INSERT INTO Sitzung (spielBeginn, spielEnde, richtigeWorte, falscheWorte, benutzer_id, schwierigkeit_id) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pst = this.getDbc().getCon().prepareStatement(sql);
			pst.setLong(1, sitzung.getSpielBeginn());
			pst.setLong(2, sitzung.getSpielEnde());
			pst.setInt(3, sitzung.getRichtigeWorte());
			pst.setInt(4, sitzung.getFalscheWorte());
			pst.setInt(5, sitzung.getBenutzer().getBenutzer_Id());
			pst.setInt(6, sitzung.getSchwierigkeit().getSchwierigkeit_id());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getDbc().closePreparedStatement(pst);
			this.getDbc().closeStatemant(st);
		}
	}

	public ResultSet select(String query) {
		Statement st = null;
		ResultSet rst = null;
		try {
			st = this.getDbc().getCon().createStatement();
			rst = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
}