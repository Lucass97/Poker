
public class Carta {

	private Seme seme;
	private Valore valore;
	private Stato stato;
	
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	public Stato getStato() {
		return this.stato;
	}
	
	public void stampaCarta() {
		System.out.println(seme.toString() + " " + valore.toString() + " " + stato.toString());
	}
	
	public boolean equals(Carta carta) {
		if(this.seme != carta.seme)
			return false;
		if(this.valore != carta.valore)
			return false;
		return true;
	}
	public Carta (Seme seme, Valore valore, Stato stato) {
		this.seme = seme;
		this.valore = valore;
		this.stato = stato;
	}
}
