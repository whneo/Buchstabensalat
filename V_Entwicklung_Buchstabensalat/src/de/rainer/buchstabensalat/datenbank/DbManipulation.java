package de.rainer.buchstabensalat.datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.rainer.buchstabensalat.datenobjekt.Sitzung;

public final class DbManipulation {

	private static DbManipulation instance;

	static DbManipulation getInstance() {
		if (DbManipulation.instance == null) {
			DbManipulation.setInstance(new DbManipulation());
		}
		return DbManipulation.instance;
	}

	private static void setInstance(DbManipulation instance) {
		DbManipulation.instance = instance;
	}

	private DbManipulation() {
		super();
	}

	public void insert(Sitzung sitzung) {
		PreparedStatement pst = null;
		Statement st = null;
		String sql = "INSERT INTO Sitzung (spielBeginn, spielEnde, richtigeWorte, falscheWorte, benutzer_id, schwierigkeit_id) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pst = DbConnection.getInstance().getCon().prepareStatement(sql);
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
			DbConnection.getInstance().closePreparedStatement(pst);
			DbConnection.getInstance().closeStatemant(st);
		}
	}

	public ResultSet select(String query) {
		Statement st = null;
		ResultSet rst = null;
		try {
			st = DbConnection.getInstance().getCon().createStatement();
			rst = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
}