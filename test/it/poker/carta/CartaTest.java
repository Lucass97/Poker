package it.poker.carta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartaTest {
	
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;

	@Before
	public void setUp() throws Exception {
		this.carta1 = new Carta(Seme.CUORI, Valore.ASSO, Stato.NON_USATA);
		this.carta2 = new Carta(Seme.QUADRI, Valore.KING, Stato.MAZZO);
		this.carta3 = new Carta(Seme.QUADRI, Valore.KING, Stato.MAZZO);
	}

	@Test
	public void testStato() {
		assertEquals(Stato.NON_USATA, this.carta1.getStato());
		this.carta1.setStato(Stato.GIOCATORE);
		assertEquals(Stato.GIOCATORE, this.carta1.getStato());
		this.carta1.setStato(Stato.MAZZO);
		assertEquals(Stato.MAZZO, this.carta1.getStato());
		this.carta1.setStato(Stato.TAVOLO);
		assertEquals(Stato.TAVOLO, this.carta1.getStato());
	}

	@Test
	public void testGetValore() {
		assertEquals(Valore.ASSO, this.carta1.getValore());
		assertEquals(Valore.KING, this.carta2.getValore());
	}


	@Test
	public void testToString() {
		assertEquals("CUORI ASSO NON_USATA", this.carta1.toString());
		assertEquals("QUADRI KING MAZZO", this.carta2.toString());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(this.carta2, this.carta3);
		assertTrue(this.carta2.equals(this.carta3));
		assertFalse(this.carta1.equals(this.carta3));
	}

	@Test
	public void testCarta() {
		
	}

}
