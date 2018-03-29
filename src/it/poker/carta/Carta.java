package it.poker.carta;

/**
 * Questa classe rappresenta una carta da gioco per il poker
 * @author Luca Gregori
 * @version 1.0
 * @see Seme
 * @see Valore
 * @see Stato
 */
public class Carta {

	private Seme seme;
	private Valore valore;
	private Stato stato;
	
	/**
	 * Questo metodo permette di cambiare lo stato della carta
	 * @param stato - nuovo stato della carta
	 */
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	/**
	 * Questo metodo restituisce il valore della carta
	 * @return valore della carta
	 */
	public Valore getValore() {
		return this.valore;
	}
	
	/**
	 * Questo metodo restituisce lo stato della carta
	 * @return stato della carta
	 */
	public Stato getStato() {
		return this.stato;
	}
	
	/**
	 * Questo metodo stampa su console la carta, specificando seme, valore e stato
	 */
	public void stampaCarta() {
		System.out.println(this.toString());
	}
	
	/**
	 * Questo metodo trasforma in stringa la carta
	 * @return stringa che rappresenta la carta
	 */
	@Override
	public String toString() {
		return seme.toString() + " " + valore.toString() + " " + stato.toString();
	}
	
	/**
	 * Questo metodo confronta due carte.
	 * Due carte sono uguali se hanno lo stesso seme e lo stesso valore
	 * @param carta - seconda carta da confrontare con questa
	 * @return true se le carte sono uguali, false altrimenti
	 */
	@Override
	public boolean equals(Object o) {
		Carta carta = (Carta) o;
		if(this.seme != carta.seme)
			return false;
		if(this.valore != carta.valore)
			return false;
		return true;
	}
	
	/**
	 * Costruttore che permette di creare una carta, specificando seme, valore e stato
	 * @param seme
	 * @param valore
	 * @param stato
	 */
	public Carta (Seme seme, Valore valore, Stato stato) {
		this.seme = seme;
		this.valore = valore;
		this.stato = stato;
	}
}
