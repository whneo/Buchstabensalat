package de.rainer.buchstabensalat.datenbank;

interface IWortsalatDbConstants {

	final String CLASS_NAME = "org.sqlite.JDBC";
	final String DB_PATH = "datenbank/";
	final String DB_NAME = "Wortsalat.sqlite";
	final String CONNECTION = "jdbc:sqlite:" + DB_PATH + DB_NAME;
	final String DDL_FILE = "Wortsalat_DDL.sql";
	final String DML_FILE = "Wortsalat_DML.sql";
}
