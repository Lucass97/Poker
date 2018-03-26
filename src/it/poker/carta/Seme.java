package it.poker.carta;

/**
 * Questa classe rappresenta i possibili valori che il seme di una carta può assumere
 * @author Luca Gregori
 * @version 1.0
 * @see Valore
 */
public enum Seme {
	CUORI(1),
	PICCHE(2),
	QUADRI(3),
	FIORI(4);
	
	private int valoreNumerico;
	
	public int getValoreNumerico() {
		return valoreNumerico;
	}
	
	public static Seme getSeme(int valoreNumerico) {
		if(valoreNumerico == 1)
			return CUORI;
		else if(valoreNumerico == 2)
			return PICCHE;
		else if(valoreNumerico == 3)
			return QUADRI;
		else
			return FIORI;
		
	}
	
	private Seme(int valoreNumerico) {
		this.valoreNumerico = valoreNumerico;
	}
}
