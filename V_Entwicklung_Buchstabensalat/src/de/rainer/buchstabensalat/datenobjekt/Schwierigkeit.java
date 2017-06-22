package de.rainer.buchstabensalat.datenobjekt;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public class Schwierigkeit {

	private int schwierigkeit_id;
	private String name;

	public int getSchwierigkeit_id() {
		return this.schwierigkeit_id;
	}

	public void setSchwierigkeit_id(int schwierigkeit_id) {
		this.schwierigkeit_id = schwierigkeit_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Schwierigkeit(int schwierigkeit_id, String name) {
		super();
		this.setSchwierigkeit_id(schwierigkeit_id);
		switch (schwierigkeit_id) {
		case 1: {
			this.setName("leicht");
			break;
		}
		case 2: {
			this.setName("mittel");
			break;
		}
		case 3: {
			this.setName("schwer");
			break;
		}
		default:
			this.setName(name);
			break;
		}
	}

	public Schwierigkeit() {
		this(0, "");
	}

	@Override
	public String toString() {
		return "Schwierigkeit [schwierigkeit_id=" + this.getSchwierigkeit_id()
				+ ", name=" + this.getName() + "]";
	}

	public Schwierigkeit getSchwierigkeitByName(String name) {
		Schwierigkeit s = new Schwierigkeit();
		String query = "SELECT * FROM Schwierigkeit WHERE name = '" + name
				+ "'";
		ResultSet rst = WortsalatDbManager.getInstance().getDbh().select(query);
		try {
			if (rst.next()) {
				s.setSchwierigkeit_id(rst.getInt("schwierigkeit_id"));
				s.setName(rst.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			WortsalatDbManager.getInstance().getDbh().getDbc()
					.closeResultSet(rst);
		}
		return s;
	}
}