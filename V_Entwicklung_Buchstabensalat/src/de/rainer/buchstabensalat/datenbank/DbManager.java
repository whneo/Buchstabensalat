package de.rainer.buchstabensalat.datenbank;

public final class DbManager {

	private static DbManager instance;
	static final String CLASS_NAME = "org.sqlite.JDBC";
	static final String DB_PATH = "datenbank/";
	static final String DB_NAME = "Wortsalat.sqlite";
	static final String CONNECTION = "jdbc:sqlite:" + DB_PATH + DB_NAME;
	static final String DDL_FILE = "Wortsalat_DDL.sql";
	static final String DML_FILE = "Wortsalat_DML.sql";
	private DbConnection dbCon;
	private DbManipulation dml;
	private DbDefinition ddl;

	public static DbManager getInstance() {
		if (DbManager.instance == null) {
			DbManager.setInstance(new DbManager());
		}
		return DbManager.instance;
	}

	private static void setInstance(DbManager instance) {
		DbManager.instance = instance;
	}

	public DbConnection getDbCon() {
		return this.dbCon;
	}

	private void setDbCon(DbConnection dbCon) {
		this.dbCon = dbCon;
	}

	public DbManipulation getDml() {
		return this.dml;
	}

	private void setDml(DbManipulation dml) {
		this.dml = dml;
	}

	public DbDefinition getDdl() {
		return this.ddl;
	}

	private void setDdl(DbDefinition ddl) {
		this.ddl = ddl;
	}

	private DbManager(DbConnection dbCon, DbManipulation dml, DbDefinition ddl) {
		super();
		this.setDbCon(dbCon);
		this.setDml(dml);
		this.setDdl(ddl);
	}

	private DbManager() {
		this(DbConnection.getInstance(), DbManipulation.getInstance(),
				DbDefinition.getInstance());
	}
}