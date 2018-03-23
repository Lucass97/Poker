package it.core;
import java.util.ArrayList;

public class Sessione {
	private ArrayList<Giocatore> elencoGiocatori;
	
	private void setElencoGiocatori (ArrayList<Giocatore> elencoGiocatori){
		if (elencoGiocatori.size() <2 || elencoGiocatori.size() > 10) {
			
		}
		this.elencoGiocatori = elencoGiocatori;
			
	}	
	public void start() {
		
	}
	
	public Sessione() {
		
	}
}
