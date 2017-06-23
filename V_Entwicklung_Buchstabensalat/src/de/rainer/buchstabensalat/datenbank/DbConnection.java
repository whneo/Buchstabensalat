package de.rainer.buchstabensalat.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbConnection {

	private static DbConnection instance;
	private DbManager dbm;
	private Connection con;

	static DbConnection getInstance() {
		if (DbConnection.instance == null) {
			DbConnection.setInstance(new DbConnection());
		}
		return DbConnection.instance;
	}

	private static void setInstance(DbConnection instance) {
		DbConnection.instance = instance;
	}

	@SuppressWarnings("unused")
	private DbManager getDbm() {
		return dbm;
	}

	private void setDbm(DbManager dbm) {
		this.dbm = dbm;
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

	private DbConnection(Connection con, DbManager dbm) {
		super();
		this.setCon(con);
		this.setDbm(dbm);
	}

	private DbConnection() {
		this(null, DbManager.getInstance());
	}

	void connect() {
		try {
			Class.forName(DbManager.CLASS_NAME);
			this.setCon(DriverManager.getConnection(DbManager.CONNECTION));
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