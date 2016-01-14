package poo;

import java.util.ArrayList;


public class Genre  implements Comparable<Genre> {
	private int dist_genres[]; // Détermine la distance entre les genres
	public Genre pere;
	public ArrayList<Style> fils;
	public String nom;
	protected int id;
	
	/**
	 * Constructeur de Genre
	 * @param n nom du Genre
	 */
	public Genre(String n){
		pere = null;
		nom = n;
		fils = new ArrayList<Style>();
	}
	
	/**
	 * Constructeur par recopie :
	 */
	public Genre(Genre g){
		pere = null;
		nom = g.nom;
		fils = new ArrayList<Style>();
		int i;
		for(i=0; i<g.nb_fils(); i++){
			fils.add(g.fils.get(i));
		}
	}
	/**
	 * Constructeur de Genre n°2
	 * @param n Nom du Genre
	 * @param i indice du Genre
	 */
	public Genre(String n, int i){
		pere = null;
		dist_genres = new int[100];
		nom = n;
		id = i;
		dist_genres[id] = 0;
		fils = new ArrayList<Style>();
	}
	
	/**
	 * Définit la distance entre deux Genres 
	 * @param s le Genre
	 * @param distance La distance entre les Genres
	 */
	public void set_distance(Genre s, int distance){
		this.dist_genres[s.id] = distance;
	}
	
	/**
	 * Ajoute un sous_style à l'ArrayListe du Genre contenant ses fils
	 * @param s le sous_style à ajouter
	 */
	public void add_sstyle(Style s){
		fils.add(s);
	}
	
	/**
	 * Le nombre de Fils du Genre
	 * @return Renvoie le nombre de fils du Genre (int)
	 */
	public int nb_fils(){
		return fils.size();
	}
	
	/**
	 * Affiche le Genre au format : 
	 * [Genre] a nbfils fils.
	 * Ses Sous_styles sont : ssstyle1 ssstyle2...
	 */
	public void afficher(){
		int i,j;
		System.out.println(nom);
		for(i=0; i<this.nb_fils(); i++){
			System.out.print("  " + fils.get(i).get_nomS());
			for(j=0; j<fils.get(i).nb_fils(); j++){
				System.out.print("\n     " + (fils.get(i)).fils.get(j).get_nomS());
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public boolean est_genre(){
		return (pere == null);
	}
	
	/**
	 * Fonction qui détermine si s est un fils direct du genre
	 * @param s
	 * @return
	 */
	public boolean a_pour_fils(Style s){
		boolean res = false;
		int i;
		for(i=0; i<this.nb_fils(); i++){
			if(fils.get(i) == s)	res = true;
		}
		return res;
		}
	/**
	 * Renvoie 0 si le Genre n'a pas le style comme petit-fils
	 * Renvoie l'id du père sinon
	 */
	public int a_pour_petit_fils(Style s){
		int res = 0;
		int i, j;
		for(i=0; i<this.nb_fils(); i++){
			for(j=0; j<fils.get(i).nb_fils(); j++){
				if(fils.get(i).fils.get(j) == s)	res = fils.get(i).idSS;
			}
		}
		return res;
		
	}
	
	public String get_nomG(){	return nom;}

	//--- COMPARAISON ---
	public float comparer(Genre s){
		return this.dist_genres[s.id];
	}
	
	
	public float comparer(Style s){
		float result;
		Genre g = new Genre(s.pere.pere);
		System.out.println(s.pere.nom);
		int test = this.a_pour_petit_fils(s);
			//Test si le sous_style est un fils du genre
		if( this.a_pour_fils(s))	result = (float) s.idSS;
		
			//Test si le sous_style est un petit-fils du genre
		else if(test!=0)	result = (float) s.idSS + test;
		
		else{// On récupère le Genre du Sous_style et on ajoute la distance au genre
			result = s.idSS;
			if(s.pere.pere != null)	result += g.a_pour_petit_fils(s);
			//result += comparer(g);
			
		}
		
		return result;
	}
}
