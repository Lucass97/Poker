
public class Poker {

	public static void main(String[] args) {
		Mazzo mazzo = new Mazzo();
		//mazzo.stampaMazzo();
		Carta carta = mazzo.pescaCartaCasuale(Stato.GIOCATORE);
		carta.stampaCarta();
		System.out.println(Stato.GIOCATORE.equals(Stato.GIOCATORE));
	}

}
