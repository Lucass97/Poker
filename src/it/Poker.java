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
		//Mazzo mazzo = new Mazzo();
		//mazzo.stampaMazzo();
		//mazzo.mischiaMazzo(100);
		/*System.out.println(mazzo.contaCarteGiocabili());
		try {
			mazzo.setCarteGiocabili(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Carta carta = mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		Giocatore player = new Giocatore("Culo");
		player.addCarta(carta);
		player.addCarta(mazzo.pescaCartaCasuale(Stato.GIOCATORE));
		player.addCarta(mazzo.pescaCartaCasuale(Stato.GIOCATORE));*/
		
		Sessione partita = new Sessione();
		try {
			partita.aggiungiGiocatore("Silviu");
			partita.aggiungiGiocatore("Ienna");
			partita.aggiungiGiocatore("SUUS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			partita.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Carte di silviu negro ");
		for(int i=0; i<5; i++) {
			partita.getPlayer("Silviu").getCarte().get(i).stampaCarta();
		}
		System.out.println("Carte di ienna negro ");
		for(int i=0; i<5; i++) {
			partita.getPlayer("Ienna").getCarte().get(i).stampaCarta();
		}
		
		
		//mazzo.stampaMazzo();
		//mazzo.stampaMazzo();
		//carta.stampaCarta();
		//System.out.println(!carta.getStato().equals(Stato.GIOCATORE));
	}

}
