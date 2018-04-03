package it.poker;
import java.util.ArrayList;
import java.util.Iterator;

import it.poker.carta.*;

public class Giocatore{
	
	private String nome;
	private ArrayList <Carta> elencoCarte;
	private static final int MAX_NUMERO_CARTE = 5;
	private int dispCambioCarte;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void resetDispCambioCarte() {
		this.dispCambioCarte = 4;
	}
	public void reduceDispCambioCarte(){
		if(this.dispCambioCarte > 0)
			this.dispCambioCarte--;
	}
	public int getDispCambioCarte() {
		return this.dispCambioCarte;
	}
	
	public void stampa() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public Carta getCarta(Carta cartaDaTrovare, Stato stato) {
		if(elencoCarte.size() == 0)
			return null;
		for(Carta carta: elencoCarte) {
			if (carta.equals(cartaDaTrovare)) {
				carta.setStato(stato);
				return carta;
			}
		}
		return null;
	}
	
	public Carta getCartaByIndex(int index, Stato stato){
		Carta carta = elencoCarte.get(index);
		carta.setStato(stato);
		return carta;
	}
	
	/**
	 * Questo metodo rimuove una carta dalle mani del giocatore.
	 * @param index - indica la posizione della carta da rimuove.
	 * @return riferimento alla carta rimossa.
	 */
	public Carta removeCartaByIndex(int index) {
		return elencoCarte.remove(index);
	}
	
	public ArrayList<Carta> getCarte() {
		return elencoCarte;
	}
	
	/**
	 * Questo metodo restituisce il numero di carte in mano al giocatore.
	 * @return il numero di carte in mano al giocatore.
	 */
	public int numeroCarte() {
		return elencoCarte.size();
	}
	
	/**
	 * Questo metodo aggiunge una carta nelle mani de giocatore.
	 * @param carta - indica il riferimento della carta da aggiungere.
	 * @return true se l'inserimento è andato a buon fine, false altrimenti.
	 */
	public boolean addCarta(Carta carta) {
		return this.elencoCarte.add(carta);
	}
	
	/**
	 * Questo metodo aggiunge una carta nelle mani del giocatore in una determinata posizione.
	 * @param carta - indica il riferimento della carta da aggiungere.
	 * @param index - indica la posizione di inserimento.
	 * @return true se l'inserimento è andato a buon fine, false altrimenti.
	 */
	public boolean addCarta(Carta carta,int index) {
		if(index >=0 && index<=MAX_NUMERO_CARTE) {
			this.elencoCarte.add(index,carta);
			return true;
		}
		return false;
	}
	
	/**
	 * Questo metodo confronta due giocatori.
	 * Due giocatori sono uguali se hanno lo stesso nome.
	 * @param o - secondo oggetto (Giocatore) da confrontare.
	 * @return true se i due giocatori sono uguali, false altrimenti.
	 */
	@Override
	public boolean equals(Object o) {
		Giocatore giocatoreDaConfrontare = (Giocatore) o;
		if(this.nome.equals(giocatoreDaConfrontare.getNome()))
			return true;
		return false;
	}
	
	public Giocatore(String nome) {
		this.setNome(nome);
		this.elencoCarte = new ArrayList<Carta>();
		this.dispCambioCarte = 4;
	}
}
