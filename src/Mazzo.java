import java.util.ArrayList;

public class Mazzo {
	private ArrayList<Carta> elencoCarte;
	
	public void stampaMazzo() {
		for(int i=0; i<elencoCarte.size(); i++) {
			elencoCarte.get(i).stampaCarta();
		}
	}
	
	//costruttori
	public Mazzo() {
		elencoCarte = new ArrayList<Carta>();
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++) {
				Carta carta = new Carta(Seme.getSeme(i), Valore.ASSO, Stato.MAZZO);
				elencoCarte.add(carta);
			}
		}
	}
}
