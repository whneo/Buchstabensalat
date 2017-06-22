package de.rainer.buchstabensalat.data;

import java.util.ArrayList;

import de.rainer.buchstabensalat.datenobjekt.Sitzung;
import de.rainer.buchstabensalat.gui.label.funktional.LetterGameLabel;
import de.rainer.buchstabensalat.gui.label.funktional.PlaceGameLabel;

public class DataProvider {

	private static DataProvider instance;
	private GameObserver gameObserver;
	private ExternObserver externObserver;
	private ArrayList<PlaceGameLabel> placeList;
	private ArrayList<LetterGameLabel> letterList;
	private ArrayList<String> wortArray;
	private int wortIndex;
	private Sitzung sitzung;

	public static DataProvider getInstance() {
		if (DataProvider.instance == null) {
			DataProvider.setInstance(new DataProvider());
		}
		return DataProvider.instance;
	}

	private static void setInstance(DataProvider instance) {
		DataProvider.instance = instance;
	}

	public GameObserver getGameObserver() {
		return this.gameObserver;
	}

	private void setGameObserver(GameObserver gameObserver) {
		this.gameObserver = gameObserver;
	}

	public ExternObserver getExternObserver() {
		return this.externObserver;
	}

	private void setExternObserver(ExternObserver externObserver) {
		this.externObserver = externObserver;
	}

	public ArrayList<PlaceGameLabel> getPlaceList() {
		return this.placeList;
	}

	public void setPlaceList(ArrayList<PlaceGameLabel> placeList) {
		this.placeList = placeList;
	}

	public ArrayList<LetterGameLabel> getLetterList() {
		return this.letterList;
	}

	public void setLetterList(ArrayList<LetterGameLabel> letterList) {
		this.letterList = letterList;
	}

	public ArrayList<String> getWortArray() {
		return this.wortArray;
	}

	public void setWortArray(ArrayList<String> wortArray) {
		this.wortArray = wortArray;
	}

	public int getWortIndex() {
		return wortIndex;
	}

	public void setWortIndex(int wortIndex) {
		this.wortIndex = wortIndex;
	}

	public Sitzung getSitzung() {
		return this.sitzung;
	}

	private void setSitzung(Sitzung sitzung) {
		this.sitzung = sitzung;
	}

	private DataProvider(GameObserver gameObserver,
			ExternObserver externObserver, ArrayList<PlaceGameLabel> placeList,
			ArrayList<LetterGameLabel> letterList, ArrayList<String> wortArray,
			int wortIndex, Sitzung sitzung, String usedButton) {
		super();
		this.setGameObserver(gameObserver);
		this.setExternObserver(externObserver);
		this.setPlaceList(placeList);
		this.setLetterList(letterList);
		this.setWortArray(wortArray);
		this.setWortIndex(wortIndex);
		this.setSitzung(sitzung);
	}

	private DataProvider() {
		this(new GameObserver(), new ExternObserver(),
				new ArrayList<PlaceGameLabel>(),
				new ArrayList<LetterGameLabel>(), new ArrayList<String>(), 0,
				new Sitzung(), "");
	}

	public void clearData() {
		this.setPlaceList(new ArrayList<PlaceGameLabel>());
		this.setLetterList(new ArrayList<LetterGameLabel>());
		this.setWortArray(new ArrayList<String>());
		this.setWortIndex(0);
		this.getSitzung().setFalscheWorte(0);
		this.getSitzung().setRichtigeWorte(0);
	}

}