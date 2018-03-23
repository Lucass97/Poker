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
	 * Questo metodo permette di pescare una carta casuale dal mazzo.
	 * Le carte pescate hanno stato uguale a "mazzo".
	 * @param stato - sarà il nuovo stato della carta appena pescata
	 * @return riferimento ad una carta casuale del mazzo
	 * @see Stato
	 */
	public Carta pescaCartaCasuale(Stato stato) {
		Random r = new Random();
		Carta carta;
		do {
			int index = r.nextInt(elencoCarte.size());
			carta = elencoCarte.get(index);
		} while(!carta.getStato().equals(Stato.MAZZO));
		
		carta.setStato(stato);
		System.out.print("ho pescato: ");
		carta.stampaCarta();
		return carta;
	}
	/**
	 * Questo metodo permette di mischiare un mazzo.
	 * @param fattore - indica il numero di passaggi effettuati per mischiare il mazzo.
	 * Range [10 - 1000]
	 * @return void
	 * @see {@link #pescaCartaCasuale(Stato) pescaCartaCasuale(Stato stato)}
	 */
	public void mischiaMazzo(int fattore) {
		if(fattore > 1000)
			fattore = 1000;
		else if(fattore <= 10)
			fattore = 10;
		for(int i=0; i<fattore; i++) {
			Carta carta1 = this.pescaCartaCasuale(Stato.MAZZO);
			Carta carta2 = this.pescaCartaCasuale(Stato.MAZZO);
			while(carta1.equals(carta2))
				carta2 = this.pescaCartaCasuale(Stato.MAZZO); 
			int index1 = elencoCarte.indexOf(carta1);
			int index2 = elencoCarte.indexOf(carta2);
			//Swap indici
			System.out.print("\tSwap tra \n\t");
			carta1.stampaCarta();
			System.out.print("\t");
			carta2.stampaCarta();
			elencoCarte.set(index1, carta2);
			elencoCarte.set(index2, carta1);
		}
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
