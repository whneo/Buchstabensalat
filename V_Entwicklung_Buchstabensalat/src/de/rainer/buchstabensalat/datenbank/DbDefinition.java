package de.rainer.buchstabensalat.datenbank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbDefinition {

	private static DbDefinition instance;

	static DbDefinition getInstance() {
		if (DbDefinition.instance == null) {
			DbDefinition.setInstance(new DbDefinition());
		}
		return DbDefinition.instance;
	}

	private static void setInstance(DbDefinition instance) {
		DbDefinition.instance = instance;
	}

	private DbDefinition() {
		super();
	}

	public void createDatabase() {
		if (this.createDatabaseFile()) {
			String sql = this.readSqlFile(DbManager.DDL_FILE);
			Statement st = null;
			try {
				st = DbConnection.getInstance().getCon().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbConnection.getInstance().closeStatemant(st);
			}
			this.fillDatabase();
		}
	}

	private boolean createDatabaseFile() {
		boolean result = true;
		File file = new File(DbManager.DB_PATH + DbManager.DB_NAME);
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
			FileReader fr = new FileReader(DbManager.DB_PATH + fileName);
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
		String sql = this.readSqlFile(DbManager.DML_FILE);
		Statement st = null;
		try {
			st = DbConnection.getInstance().getCon().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.getInstance().closeStatemant(st);
		}
	}
}
