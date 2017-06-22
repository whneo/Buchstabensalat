package de.rainer.buchstabensalat.datenbank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WortsalatDbManager implements IWortsalatDbConstants {

	private static WortsalatDbManager instance;
	private WortsalatDbConnector dbc;
	private WortsalatDbHandler dbh;

	public static WortsalatDbManager getInstance() {
		if (WortsalatDbManager.instance == null) {
			WortsalatDbManager.setInstance(new WortsalatDbManager());
		}
		return WortsalatDbManager.instance;
	}

	private static void setInstance(WortsalatDbManager instance) {
		WortsalatDbManager.instance = instance;
	}

	private WortsalatDbConnector getDbc() {
		return this.dbc;
	}

	private void setDbc(WortsalatDbConnector dbc) {
		this.dbc = dbc;
	}

	public WortsalatDbHandler getDbh() {
		return this.dbh;
	}

	private void setDbh(WortsalatDbHandler dbh) {
		this.dbh = dbh;
	}

	private WortsalatDbManager(WortsalatDbConnector dbc, WortsalatDbHandler dbh) {
		super();
		this.setDbc(dbc);
		this.setDbh(dbh);
	}

	private WortsalatDbManager() {
		this(WortsalatDbConnector.getInstance(), WortsalatDbHandler
				.getInstance());
	}

	public void createDatabase() {
		if (this.createDatabaseFile()) {
			String sql = this.readSqlFile(DDL_FILE);
			Statement st = null;
			try {
				Connection con = this.getDbc().getCon();
				st = con.createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.getDbc().closeStatemant(st);
			}
			this.fillDatabase();
		}
	}

	private boolean createDatabaseFile() {
		boolean result = true;
		File file = new File(DB_PATH + DB_NAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				result = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String readSqlFile(String fileName) {
		String zeile = "";
		String text = "";
		try {
			FileReader fr = new FileReader(DB_PATH + fileName);
			BufferedReader br = new BufferedReader(fr);
			while ((zeile = br.readLine()) != null) {
				text = text.concat(zeile);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	private void fillDatabase() {
		String sql = this.readSqlFile(DML_FILE);
		Statement st = null;
		try {
			Connection con = this.getDbc().getCon();
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getDbc().closeStatemant(st);
		}
	}
}
