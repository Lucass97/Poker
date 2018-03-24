package it.core;
import java.util.ArrayList;

public class Sessione {
	
	private ArrayList<Giocatore> elencoGiocatori;
	private Mazzo mazzo;
	
	public void aggiungiGiocatore(String nome) throws Exception{
		if(elencoGiocatori.size() == 10)
			throw new Exception("Errore numero massimo giocatori raggiunti");
		Giocatore player = new Giocatore(nome);
		elencoGiocatori.add(player);
	}
	
	public void start() throws Exception {
		if(elencoGiocatori.size() < 2)
			throw new Exception("Errore! non ci sono abbastanza giocatori!");
	}
	
	/*public void setElencoGiocatori (ArrayList<Giocatore> elencoGiocatori) throws Exception{
	if (elencoGiocatori.size() <2 || elencoGiocatori.size() > 10) {
		throw new Exception("asd");
	}
	this.elencoGiocatori = elencoGiocatori;
		
	}*/
	
	public Sessione() {
		this.elencoGiocatori = new ArrayList<Giocatore>();
		mazzo = new Mazzo();
	}
}