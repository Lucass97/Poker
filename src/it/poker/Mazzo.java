package it.poker;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import it.poker.carta.Carta;
import it.poker.carta.Seme;
import it.poker.carta.Stato;
import it.poker.carta.Valore;

/**
 * Questa classe rappresenta un mazzo di carte di poker
 * @author Luca Gregori
 * @version 1.0
 * @see Carta
 * @see Stato
 */
public class Mazzo {
	
	private ArrayList<Carta> elencoCarte;
	private int carteGiocabili;
	private int carteNelMazzo;
	
	/**
	 * Questo metodo permette di stampare tutte le carte del mazzo
	 * @see Stato
	 */
	public void stampaMazzo() {
		for(Carta carta : elencoCarte)
			carta.stampaCarta();
	}
	
	/**
	 * Questo metodo permette di stampare le carte del mazzo con un determinato stato
	 * @param stato - indica il parametro di ricera all'interno del mazzo
	 * @see Stato
	 */
	public void stampaMazzo(Stato stato) {
		for(Carta carta : elencoCarte) {
			if(carta.getStato().equals(stato))
				carta.stampaCarta();
		}
	}
	
	/**
	 * Questo metodo permette di pescare una carta casuale dal mazzo.
	 * Sarà pescata una carta con stato pari a "MAZZO".
	 * @param stato - sarà il nuovo stato della carta appena pescata
	 * @return riferimento ad una carta casuale del mazzo
	 * @see Stato
	 */
	public Carta pescaCartaCasuale(Stato stato) throws NoSuchElementException{
		if(this.carteNelMazzo == 0)
			throw new NoSuchElementException("Non esistono carte nel mazzo! Impossibile pescare!");
		Random r = new Random();
		Carta carta = null;
		do {
			int index = r.nextInt(elencoCarte.size());
			carta = elencoCarte.get(index);
		} while(!carta.getStato().equals(Stato.MAZZO));
		
		System.out.print("ho pescato: ");
		carta.stampaCarta();
		carta.setStato(stato);
		if(!stato.equals(Stato.MAZZO))
			this.carteNelMazzo--;
		return carta;
	}
	
	/**
	 * Questo metodo permette di pescare una carta casuale dal mazzo.
	 * Sarà pescata una carta con stato pari a "MAZZO".
	 * La carta sarà aggiorna con un nuovo stato pari a "GIOCATORE"
	 * @return riferimento ad una carta casuale del mazzo
	 * @see Stato
	 */
	public Carta pescaCartaCasuale() throws Exception{
		return pescaCartaCasuale(Stato.GIOCATORE);
	}
	
	/**
	 * Questo metodo permette di mischiare un mazzo.
	 * @param fattore - indica il numero di passaggi effettuati per mischiare il mazzo.
	 * Range [10 - 1000]
	 * @return void
	 * @see {@link #pescaCartaCasuale(Stato) pescaCartaCasuale(Stato stato)}
	 */
	public boolean mischiaMazzo(int fattore){
		if(this.carteNelMazzo == 0)
			return false;
		try {
			if(fattore > 1000)
				fattore = 1000;
			else if(fattore <= 10)
				fattore = 10;
			for(int i=0; i<fattore; i++) {
				Carta carta1 = this.pescaCartaCasuale(Stato.MAZZO);
				Carta carta2 = this.pescaCartaCasuale(Stato.MAZZO);
				while(carta1.equals(carta2))
					carta2 = this.pescaCartaCasuale(Stato.MAZZO); 
				int index1 = elencoCarte.indexOf(carta1);
				int index2 = elencoCarte.indexOf(carta2);
				elencoCarte.set(index1, carta2);
				elencoCarte.set(index2, carta1);
			}
		}catch(Exception e) {
			return false;
		};
		return true;
	}
	
	/**
	 * Questo metodo permette di decidere quali carte potranno essere giocate.
	 * Le carte NON giocate avranno stato pari a "NON_USATA" il resto avrà stato pari a "MAZZO"
	 * @param numeroGiocatori - influenzerà il numero di carte giocabili.
	 */
	public void setCarteGiocabili(int numeroGiocatori) throws Exception{
		if(numeroGiocatori < 2 || numeroGiocatori > 10)
			throw new Exception();
		
		this.carteGiocabili = 52;
		int valorePiuBasso = 11 - numeroGiocatori;
		for(Carta carta : elencoCarte) {
			if(carta.getValore().getValoreNumerico() < valorePiuBasso) 
				if (!carta.getValore().equals(Valore.ASSO)){
					carta.setStato(Stato.NON_USATA);
					this.carteGiocabili--; // non conto quelle non usate
				}
				else
					carta.setStato(Stato.MAZZO);
		}
		this.carteNelMazzo = this.carteGiocabili;
	}
	
	/**
	 * Questo metodo conta le carte giocabili presenti nel mazzo
	 * @return il numero di carte che non hanno stato pari a "NON_USATA"
	 */
	public int contaCarteGiocabili(){
		/*int conta = 0;
		for(Carta carta : elencoCarte) {
			if(!carta.getStato().equals(Stato.NON_USATA))
				conta++;
			}
		return conta;*/
		return this.carteGiocabili;
	}
	
	/**
	 * Questo metodo conta le carte presenti nel mazzo
	 * @param stato - indica lo stato delle carte da contare
	 * @return il numero di carte che hanno stato pari a quello scelto come parametro
	 */
	public int contaCarte(Stato stato){
		int conta = 0;
		for(Carta carta : elencoCarte) {
			if(carta.getStato().equals(stato))
				conta++;
			}
		return conta;
	}
	
	/**
	 * Questo metodo conta le carte con stato pari a "MAZZO" presenti nel mazzo
	 * @return il numero di carte con stato pari a "MAZZO"
	 */
	public int contaCarte(){
		//return contaCarte(Stato.MAZZO);
		return this.carteNelMazzo;
	}
	
	/**
	 * Costruttore che crea un mazzo di 52 carte.
	 */
	public Mazzo() {
		this.elencoCarte = new ArrayList<Carta>();
		this.carteGiocabili = 52; // per default tutte le carte sono giocabili
		this.carteNelMazzo = 52; // per default tutte le carte hanno stato "mazzo"
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
				Carta carta = new Carta(Seme.getSeme(i), Valore.getValore(j), Stato.MAZZO);
				elencoCarte.add(carta);
			}
		}
	}
}
