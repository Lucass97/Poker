import java.util.ArrayList;
import java.util.Random;

public class Mazzo {
	private ArrayList<Carta> elencoCarte;
	
	public void stampaMazzo() {
		for(int i=0; i<elencoCarte.size(); i++) {
			elencoCarte.get(i).stampaCarta();
		}
	}
	
	/**
	 * Questo metodo permette di mescare una carta casuale
	 * @param stato
	 * @return riferimento ad una carta casuale del mazzo
	 */
	public Carta pescaCartaCasuale(Stato stato) {
		Random r = new Random();
		int index = r.nextInt(elencoCarte.size());
		Carta carta;
		do {
			carta = elencoCarte.get(index);
		}while(!carta.getStato().equals(Stato.MAZZO));
		
		carta.setStato(stato);
		return carta;
	}
	
	//costruttori
	public Mazzo() {
		elencoCarte = new ArrayList<Carta>();
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				Carta carta = new Carta(Seme.getSeme(i), Valore.getValore(j), Stato.MAZZO);
				elencoCarte.add(carta);
			}
		}
	}
}
