package poo;

public class Chanson {
	private int id;
	private String nom;
	private Style tab[];
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Style[] getTab() {
		return tab;
	}
	
	public void setTab(Style tab[]) {
		this.tab = tab;
	}
}
