package it.poker.carta;

/**
 * Questa classe rappresenta i possibili valori che il valore di una carta può assumere
 * @author Luca Gregori
 * @version 1.0
 * @see Valore
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
	DIECI(10),
	JACK(11),
	QUEEN(12),
	KING(13);
	
	private int valoreNumerico;
	
	/**
	 * Questo metodo restituisce il corrispondente valore numerico del valore corrente
	 * @return valore numerico corrispondente al valore corrente
	 */
	public int getValoreNumerico() {
		return valoreNumerico;
	}
	
	/**
	 * Questo metodo dato un valore numerico restituirà il valore corrispondente
	 * @param valoreNumerico - range di valori possibili: [1-12]; qualsiasi valore diverso verrà considerato come 1
	 * @return valore corrispondete a "valoreNumerico"
	 */
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
			case 10: return DIECI;
			case 11: return JACK;
			case 12: return QUEEN;
			case 13: return KING;
			default : return ASSO;
		}
		
	}
	
	private Valore(int valoreNumerico) {
		this.valoreNumerico = valoreNumerico;
	}
}
