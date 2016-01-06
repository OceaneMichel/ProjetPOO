package poo;

public class Main {

	public static void main(String[] args) {
		Chanteur chan = new Chanteur(1, 1, 3, "Lavoine", "Marc");
		Instrument guitare = new Instrument("guitare", 1);
		chan.setTab(guitare);
		chan.setTab(guitare);
		chan.setTab(guitare);
		chan.setTab(guitare);
		System.out.println(chan.getPrenom());
		System.out.println(chan.getNum());
		System.out.println(chan.getId());
		chan.afficher_instruments();
	}

}
