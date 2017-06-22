package de.rainer.buchstabensalat.datenobjekt;

import de.rainer.buchstabensalat.datenbank.WortsalatDbManager;

public class Sitzung {

	private int sitzung_id;
	private long spielBeginn;
	private long spielEnde;
	private int richtigeWorte;
	private int falscheWorte;
	private Benutzer benutzer;
	private Schwierigkeit schwierigkeit;

	public int getSitzung_Id() {
		return this.sitzung_id;
	}

	private void setSitzung_Id(int sitzung_id) {
		this.sitzung_id = sitzung_id;
	}

	public long getSpielBeginn() {
		return this.spielBeginn;
	}

	public void setSpielBeginn(long spielBeginn) {
		this.spielBeginn = spielBeginn;
	}

	public long getSpielEnde() {
		return this.spielEnde;
	}

	public void setSpielEnde(long spielEnde) {
		this.spielEnde = spielEnde;
	}

	public int getRichtigeWorte() {
		return this.richtigeWorte;
	}

	public void setRichtigeWorte(int richtigeWorte) {
		this.richtigeWorte = richtigeWorte;
	}

	public int getFalscheWorte() {
		return this.falscheWorte;
	}

	public void setFalscheWorte(int falscheWorte) {
		this.falscheWorte = falscheWorte;
	}

	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Schwierigkeit getSchwierigkeit() {
		return this.schwierigkeit;
	}

	public void setSchwierigkeit(Schwierigkeit schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

	public Sitzung(int sitzung_id, long spielBeginn, long spielEnde,
			int richtigeWorte, int falscheWorte, Benutzer benutzer,
			Schwierigkeit schwierigkeit) {
		super();
		this.setSitzung_Id(sitzung_id);
		this.setSpielBeginn(spielBeginn);
		this.setSpielEnde(spielEnde);
		this.setRichtigeWorte(richtigeWorte);
		this.setFalscheWorte(falscheWorte);
		this.setBenutzer(benutzer);
		this.setSchwierigkeit(schwierigkeit);
	}

	public Sitzung() {
		this(0, 0, 0, 0, 0, new Benutzer(), new Schwierigkeit());
	}

	@Override
	public String toString() {
		return "Sitzung [sitzung_id=" + this.getSitzung_Id() + ", spielBeginn="
				+ this.getSpielBeginn() + ", spielEnde=" + this.getSpielEnde()
				+ ", richtigeWorte=" + this.getRichtigeWorte()
				+ ", falscheWorte=" + this.getFalscheWorte() + ", benutzer="
				+ this.getBenutzer().toString() + ", schwierigkeit="
				+ this.getSchwierigkeit().toString() + "]";
	}
	
	public void save(Sitzung sitzung) {
		WortsalatDbManager.getInstance().getDbh().insert(sitzung);
	}
}