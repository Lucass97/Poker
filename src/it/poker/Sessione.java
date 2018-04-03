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
	private boolean start;
	
	/**
	 * Questo metodo restituirà lo stato della partita.
	 * @return true se la partita è cominciata, false altrimenti.
	 */
	public boolean isStart() {
		return this.start;
	}
	
	/**
	 * Questo metodo aggiunge un nuovo giocatore alla lista di giocatori della sessione.
	 * @param nome - indica il nome del nuovo giocatore.
	 * @return true se è stato aggiunto corretamente il giocatore, false altrimenti
	 * viene lanciata un eccezzione.
	 */
	public boolean aggiungiGiocatore(String nome){
		if(elencoGiocatori.size() == 10)
			return false;
		Giocatore player = new Giocatore(nome);
		for(Giocatore giocatore : elencoGiocatori) {
			if(giocatore.equals(player)) {
				return false;
			}
		}
		return elencoGiocatori.add(player);
	}
	
	/**
	 * Questo metodo distribuisce le carte fra tutti i giocatori.
	 * Saranno pescate casualmente 5 carte per giocatore.
	 * @throws Exception - se non ci sono almeno due giocatori, viene lanciata un eccezzione.
	 */
	private void distribuisciCarte() throws Exception{
		if(elencoGiocatori.size() < 2)
			throw new Exception();
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
		this.start = true;
		distribuisciCarte();
	}
	
	/**
	 * Questo metodo cerca il giocatore all'interno dell'elenco giocatori della sessione.
	 * @param nome - che verrà usato come parametro di ricerca
	 * @return il giocatore desiderato, null se non viene trovato.
	 */
	public Giocatore getPlayer(String nome) throws NullPointerException{
		if(elencoGiocatori.size() == 0 )
			throw new NullPointerException();
		for(Giocatore player: elencoGiocatori) {
			if(player.getNome().equals(nome))
				return player;
		}
		throw new NullPointerException();
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
	
	public void stampaCarteGiocatore(int indexGiocatore) {
		elencoGiocatori.get(indexGiocatore).stampa();
	}
	
	public Sessione() {
		this.start = false;
		this.elencoGiocatori = new ArrayList<Giocatore>();
		this.mazzo = new Mazzo();
	}
}
