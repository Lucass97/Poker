package it.poker;
import java.util.ArrayList;

import it.poker.carta.Seme;
import it.poker.carta.Stato;
import it.poker.carta.Valore;

/**
 * Questa classe rappresenta una sessione di gioco (poker)
 * @author Luca Gregori
 * @version 1.0
 * @see Giocatore
 * @see Mazzo
 * @see Carta
 */
public class Sessione {
	
	private ArrayList<Giocatore> elencoGiocatori;
	private Mazzo mazzo;
	
	public void aggiungiGiocatore(String nome) throws Exception{
		if(elencoGiocatori.size() == 10)
			throw new Exception("Errore numero massimo giocatori raggiunti");
		Giocatore player = new Giocatore(nome);
		elencoGiocatori.add(player);
	}
	
	private void distribuisciCarte() {
		for(Giocatore player: elencoGiocatori) {
			for(int i=0; i<5; i++) {
				player.addCarta(mazzo.pescaCartaCasuale(Stato.GIOCATORE));
			}
		}
	}
	public void start() throws Exception {
		if(elencoGiocatori.size() < 2)
			throw new Exception("Errore! non ci sono abbastanza giocatori!");
		distribuisciCarte();
	}
	
	public Giocatore getPlayer(String nome) {
		for(Giocatore player: elencoGiocatori) {
			if(player.getNome().equals(nome))
				return player;
		}
		return null;
	}
	
	/*public void setElencoGiocatori (ArrayList<Giocatore> elencoGiocatori) throws Exception{
	if (elencoGiocatori.size() <2 || elencoGiocatori.size() > 10) {
		throw new Exception("asd");
	}
	this.elencoGiocatori = elencoGiocatori;
		
	}*/
	
	public Sessione() {
		this.elencoGiocatori = new ArrayList<Giocatore>();
		this.mazzo = new Mazzo();
	}
}
