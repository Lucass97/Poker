package it.poker;
import java.util.ArrayList;
import java.util.Iterator;

import it.poker.carta.*;

public class Giocatore{
	
	private String nome;
	private ArrayList <Carta> elencoCarte;
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
	public void removeCartaByIndex(int index) {
		elencoCarte.remove(index);
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
	
	public void addCarta(Carta carta,int index) {
		this.elencoCarte.add(index,carta);
	}
	
	public Giocatore(String nome) {
		this.setNome(nome);
		this.elencoCarte = new ArrayList<Carta>();
		this.dispCambioCarte = 4;
	}
}
