package it;

import java.util.ArrayList;
import java.util.Iterator;

import it.poker.Giocatore;
import it.poker.Mazzo;
import it.poker.Sessione;
import it.poker.carta.Carta;
import it.poker.carta.Stato;

public class Poker {

	public static void main(String[] args) {
		Sessione partita = new Sessione();
		partita.aggiungiGiocatore("Mario");
		partita.aggiungiGiocatore("Ienna");
		try {
			partita.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		partita.stampaCarteGiocatore(4);
	}

}
