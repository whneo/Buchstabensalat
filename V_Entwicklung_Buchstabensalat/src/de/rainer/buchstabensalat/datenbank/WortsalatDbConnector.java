package de.rainer.buchstabensalat.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WortsalatDbConnector implements IWortsalatDbConstants {

	private static WortsalatDbConnector instance;
	private Connection con;

	static WortsalatDbConnector getInstance() {
		if (WortsalatDbConnector.instance == null) {
			WortsalatDbConnector.setInstance(new WortsalatDbConnector());
		}
		return WortsalatDbConnector.instance;
	}

	private static void setInstance(WortsalatDbConnector instance) {
		WortsalatDbConnector.instance = instance;
	}

	Connection getCon() throws SQLException {
		if (this.con == null || this.con.isClosed()) {
			this.connect();
		}
		return this.con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}

	private WortsalatDbConnector(Connection con) {
		super();
		this.setCon(con);
	}

	private WortsalatDbConnector() {
		this(null);
	}

	void connect() {
		try {
			Class.forName(CLASS_NAME);
			this.setCon(DriverManager.getConnection(CONNECTION));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (!this.getCon().isClosed()) {
				this.getCon().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void closePreparedStatement(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void closeStatemant(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}