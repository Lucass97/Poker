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
		Mazzo mazzo = new Mazzo();
		mazzo.stampaMazzo();
		//mazzo.mischiaMazzo(100);
		System.out.println("Numero carte giocabili: " + mazzo.contaCarteGiocabili());
		System.out.println("Numero carte nel mazzo: " + mazzo.contaCarte());
		try {
			mazzo.setCarteGiocabili(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Numero carte giocabili: " + mazzo.contaCarteGiocabili());
		System.out.println("Numero carte nel mazzo: " + mazzo.contaCarte());
		
		try {
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		    mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		    mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
			mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		//mazzo.stampaMazzo();
		
		System.out.println("Numero carte giocabili: " + mazzo.contaCarteGiocabili());
		System.out.println("Numero carte nel mazzo: " + mazzo.contaCarte());
		
		/*Sessione partita = new Sessione();
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
		}*/
		
		
		//mazzo.stampaMazzo();
		//mazzo.stampaMazzo();
		//carta.stampaCarta();
		//System.out.println(!carta.getStato().equals(Stato.GIOCATORE));
	}

}
