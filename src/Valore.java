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
	
	public static Valore getValore(int valoreNumerico) {
		switch(valoreNumerico) {
			case 1: return ASSO;
			case 2: return DUE;
			case 3: return TRE;
			case 4: return QUATTRO;
			case 5: return CINQUE;
			case 6: return SEI;
			case 7: return SETTE;
			case 8: return OTTO;
			case 9: return NOVE;
			case 10: return JACK;
			case 11: return QUEEN;
			case 12: return KING;
			default : return ASSO;
		}
		
	}
	
	private Valore(int valoreNumerico) {
		this.valoreNumerico = valoreNumerico;
	}
}
