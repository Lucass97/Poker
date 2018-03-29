package it.poker;
import java.util.ArrayList;

import it.poker.carta.Carta;
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
	
	/**
	 * Questo metodo distribuisce le carte fra tutti i giocatori.
	 * Saranno pescate casualmente 5 carte per giocatore.
	 */
	private void distribuisciCarte() {
		for(Giocatore player: elencoGiocatori) {
			for(int i=0; i<5; i++) {
				player.addCarta(mazzo.pescaCartaCasuale(Stato.GIOCATORE));
			}
			player.resetDispCambioCarte();
		}
	}
	
	/**
	 * Questo metodo permette di cominciare una partita
	 * @throws Exception
	 */
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

	public void cambioCarteGiocatore(Giocatore player, int indexCarta){
		if(player.getDispCambioCarte() > 0) {
			player.getCartaByIndex(indexCarta, Stato.MAZZO);
			player.removeCartaByIndex(indexCarta);
			Carta cartaPescata = mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			player.addCarta(cartaPescata,indexCarta);
			player.reduceDispCambioCarte();
		}
	}
	
	public Sessione() {
		this.elencoGiocatori = new ArrayList<Giocatore>();
		this.mazzo = new Mazzo();
	}
}
