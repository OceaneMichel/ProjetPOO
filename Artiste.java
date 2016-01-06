package poo;

public class Artiste {
	private int id;
	private String nom;
	private String prenom;

	public Artiste(){}
	
	public Artiste(int id_a, String n, String p){
		id=id_a;
		nom=n;
		prenom=p;
	}
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
