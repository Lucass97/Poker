package it;

import it.core.Mazzo;
import it.core.carta.Carta;
import it.core.carta.Stato;

public class Poker {

	public static void main(String[] args) {
		Mazzo mazzo = new Mazzo();
		//mazzo.stampaMazzo();
		Carta carta = mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		mazzo.mischiaMazzo(100);
		mazzo.stampaMazzo();
		//carta.stampaCarta();
		//System.out.println(!carta.getStato().equals(Stato.GIOCATORE));
	}

}
