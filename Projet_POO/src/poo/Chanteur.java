package poo;

public class Chanteur extends Artiste {
	private Instrument[] tab;
	private int nb_instr;
	private int compt_instr;
	private int num;
	
	
	public Chanteur(int id, int id_art, int n, String nom, String prenom){
		super(id_art, nom, prenom);
		setNum(id);
		compt_instr=0;
		nb_instr = n;
		tab = new Instrument [n];
	}
	
	public Instrument[] getTab() {
		return tab;
	}

	public void setTab(Instrument instru) {
		if(compt_instr<nb_instr){
			tab[compt_instr] = instru;
			compt_instr++;
		} else System.out.println("Trop d'instruments.");
	}
	
	public void afficher_instruments(){
		for(Instrument e:  tab){
			System.out.println(e);
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int n) {
		num = n;
	}
}
