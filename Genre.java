package poo;

import java.util.ArrayList;


public class Genre implements Comparable<Genre> {
	private int dist_genres[]; // Détermine la distance entre les genres
	public ArrayList<Sous_style> fils;
	protected String nom;
	private int id;
	
	public Genre(String n){
		nom = n;
		fils = new ArrayList<Sous_style>();
	}
	
	public Genre(String n, int i){
		dist_genres = new int[100];
		nom = n;
		id = i;
		dist_genres[id] = 0;
		fils = new ArrayList<Sous_style>();
	}
	
	public void set_distance(Genre s, int distance){
		this.dist_genres[s.id] = distance;
	}
	
	public void add_sstyle(Sous_style s){
		fils.add(s);
	}
	
	public int nb_fils(){
		return fils.size();
	}
	
	public void afficher(){
		int i;
		System.out.println("["+nom+"]" + " a " + nb_fils() + " fils.");
		System.out.print("Ses fils sont : ");
		for(i=0; i<fils.size(); i++){
			System.out.print("["+fils.get(i).nom+"|"+i+ "] ");
		}
		System.out.print("\n\n");
	}
	

	//--- COMPARAISON ---
	public float comparer(Genre s){
		int distance = this.dist_genres[s.id];
		float resultat;
		resultat = (float)(100-distance*20)/100;
		if(resultat<=0)	resultat = 0;
		
		return resultat;
	}
	
	public float comparer(Sous_style s){
		return 0;
	}
}
