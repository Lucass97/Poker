/**
 * Questa classe rappresenta i possibili valori che il valore di una carta può assumere
 * 
 * @author Luca Gregori
 * @version 1.0
 * @see Valore
 * 
 */
public enum Valore {
	ASSO(1),
	DUE(2),
	TRE(3),
	QUATTRO(4),
	CINQUE(5),
	SEI(6),
	SETTE(7),
	OTTO(8),
	NOVE(9),
	JACK(10),
	QUEEN(11),
	KING(12);
	
	/* Variabili di istanza */
	private int valoreNumerico;
	
	/* Metodi */
	
	public int getValoreNumerico() {
		return valoreNumerico;
	}
	
	private Valore(int valoreNumerico) {
		this.valoreNumerico = valoreNumerico;
	}
}
