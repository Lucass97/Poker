
public class Carta {

	private Seme seme;
	private Valore valore;
	private Stato stato;
	
	public void stampaCarta() {
		System.out.println(seme.toString() + valore.toString() + stato.toString());
	}
	public Carta (Seme seme, Valore valore, Stato stato) {
		this.seme = seme;
		this.valore = valore;
		this.stato = stato;
	}
}
