package it;

import java.util.ArrayList;

import it.core.Giocatore;
import it.core.Mazzo;
import it.core.Sessione;
import it.core.carta.Carta;
import it.core.carta.Stato;

public class Poker {

	public static void main(String[] args) {
		Mazzo mazzo = new Mazzo();
		//mazzo.stampaMazzo();
		Carta carta = mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		mazzo.mischiaMazzo(100);
		mazzo.stampaMazzo();
		try {
			mazzo.setCarteGiocabili(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mazzo.stampaMazzo();
		//carta.stampaCarta();
		//System.out.println(!carta.getStato().equals(Stato.GIOCATORE));
	}

}
