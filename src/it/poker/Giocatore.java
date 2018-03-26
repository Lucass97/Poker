package it.poker;
import java.util.ArrayList;
import java.util.Iterator;

import it.poker.carta.*;

public class Giocatore{
	
	private String nome;
	private ArrayList <Carta> elencoCarte;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Carta getCarta(Carta cartaDaTrovare, Stato stato) {
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
	
	public ArrayList<Carta> getCarte() {
		return elencoCarte;
	}
	public int numeroCarte() {
		return elencoCarte.size();
	}
	
	public void addCarta(Carta carta) {
		this.elencoCarte.add(carta);
	}
	
	public Giocatore(String nome) {
		this.setNome(nome);
		this.elencoCarte = new ArrayList<Carta>();
	}
}
