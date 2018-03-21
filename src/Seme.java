/**
 * Questa classe rappresenta i possibili valori che il seme di una carta può assumere
 * 
 * @author Luca Gregori
 * @version 1.0
 * @see Valore
 * 
 */
public enum Seme {
	CUORI(1),
	PICCHE(2),
	QUADRI(3),
	FIORI(4);
	
	/* Variabili di istanza */
	private int valoreNumerico;
	
	/* Metodi */
	
	public int getValoreNumerico() {
		return valoreNumerico;
	}
	
	private Seme(int valoreNumerico) {
		this.valoreNumerico = valoreNumerico;
	}
}
