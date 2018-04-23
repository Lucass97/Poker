package it.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import it.poker.carta.Carta;
import it.poker.carta.Stato;

public class MazzoTest {

	private Mazzo mazzo1;
	private Mazzo mazzo2;
	private Mazzo mazzo3;
	private Mazzo mazzo4;
	private Mazzo mazzo5;
	private Mazzo mazzo6;
	
	@Before
	public void setUp() throws Exception {
		
		/* setup caso 1 */
		this.mazzo1 = new Mazzo();
		//this.mazzo1.setCarteGiocabili(2);
		
		/* setup caso 2 */
		this.mazzo2 = new Mazzo();
		this.mazzo2.setCarteGiocabili(5);
		
		/* setup caso 3 */
		this.mazzo3 = new Mazzo();
		this.mazzo3.setCarteGiocabili(6);
		
		/* setup caso 4 */
		this.mazzo4 = new Mazzo();
		this.mazzo4.setCarteGiocabili(3);
		
		/* setup caso 5 */
		this.mazzo5 = new Mazzo();
		
		/* setup caso 6 */
		this.mazzo6 = new Mazzo();
		
	}

	@Test
	public void testPescaCartaCasuale(){
		
		/* Test mazzo #1 */
		testPescaCartaCasuale(this.mazzo1, 25 , Stato.TAVOLO);
		testPescaCartaCasuale(this.mazzo1, 60 , Stato.GIOCATORE);
		
		/* Test mazzo #2 */
		testPescaCartaCasuale(this.mazzo2, 5, Stato.TAVOLO);
		testPescaCartaCasuale(this.mazzo2, 25, Stato.GIOCATORE);
		
		/* Test mazzo #3 */
		testPescaCartaCasuale(this.mazzo3, 5, Stato.TAVOLO);
		assertTrue(this.mazzo3.mischiaMazzo(500));
		testPescaCartaCasuale(this.mazzo3, 35, Stato.GIOCATORE);
		
	
	}
	/**
	 * Metodo di supporto che permette di effettuare test per la pesca di carte casuali
	 * @param mazzo - su cui effettuare il test
	 * @param numeroCarteDaEstrarre - numero tentativi di estrazione da effettuare
	 * @param statoEstrazione - stato che le carte pescate dovranno assumere
	 */
	private void testPescaCartaCasuale(Mazzo mazzo, int numeroCarteDaEstrarre, Stato statoEstrazione) {
		ArrayList<Carta> listaCarte = new ArrayList<Carta>(); // lista di carte di supporto dove andranno messi i risultati
		int numeroCarteNelMazzoIniziale = mazzo.contaCarte(); // è il numero di carte estraibili
		
		/* Estrazione */
		int numeroCarteEstratte = 0; // conta il numero di carte estratte
		int countException = 0; // conta il numero di estrazioni fallite
		for(int i=0; i<numeroCarteDaEstrarre; i++) {
			try {
				listaCarte.add(mazzo.pescaCartaCasuale(statoEstrazione));
				numeroCarteEstratte++;
			} catch (NoSuchElementException e) {
				countException++;
			}
		}
		
		/* Il numero di estrazioni fallite dovrà essere */
		if(numeroCarteDaEstrarre > numeroCarteNelMazzoIniziale)
			assertEquals(numeroCarteDaEstrarre - numeroCarteNelMazzoIniziale, countException);
		else
			assertEquals(0, countException);
		
		/* Dopo l'estrazione le carte nel mazzo dovranno essere */
		assertEquals(numeroCarteNelMazzoIniziale - numeroCarteEstratte , mazzo.contaCarte());
		
		/* Le carte estratte saranno tutte diverse tra loro, ovvero saranno uniche */
		for(int i=0; i<numeroCarteEstratte; i++) {
			for(int j=i+1; j<numeroCarteEstratte; j++) {
				assertNotEquals(listaCarte.get(i), listaCarte.get(j));
			}
		}
		
		/* Tutte le carte estratte dovranno avere stato pari a statoEstrazione */
		int numeroCarteConStatoEstrazione = 0;
		for(Carta carta : listaCarte) {
			if(carta.getStato().equals(statoEstrazione))
				numeroCarteConStatoEstrazione++;
		}
		assertEquals(numeroCarteEstratte, numeroCarteConStatoEstrazione);
	}

	@Test
	public void testMischiaMazzo() {
		assertTrue(this.mazzo4.mischiaMazzo(500));
	}
	
	@Test
	public void testCarteGiocabili() {
		/* Test mazzo #5 */
		assertEquals(52, this.mazzo5.contaCarteGiocabili());
		try {
			this.mazzo5.setCarteGiocabili(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(36, this.mazzo5.contaCarteGiocabili());
	}

	@Test
	public void testContaCarte() {
		assertEquals(52, this.mazzo6.contaCarte());
		assertEquals(52,this.mazzo6.contaCarte(Stato.MAZZO));
		assertEquals(0,this.mazzo6.contaCarte(Stato.GIOCATORE));
		for(int i=0; i<10; i++) {
			this.mazzo6.pescaCartaCasuale(Stato.TAVOLO);
		}
		assertEquals(10, this.mazzo6.contaCarte(Stato.TAVOLO));
		assertEquals(42, this.mazzo6.contaCarte(Stato.MAZZO));
	}

}
