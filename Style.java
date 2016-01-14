package poo;

import java.util.ArrayList;

/**
 * Classe qui sera implémentée par les programmeurs
 * @author oceane
 *
 */
public class Style extends Genre implements Comparable<Genre>{
	public int idSS;
	public Genre pere;
	public String nom;
	public ArrayList<Style> fils;
	/**
	 * Constructeur de sous_style
	 * @param n le nom du style
	 * @param i le numéro du fils (et son rapport d proximité par rapport au Style père)
	 */
	
	public Style(String n, int id, Genre p){
		super(n, id);
		nom = n ;
		idSS = id;
		nom=n;
		this.pere = p;
		fils = new ArrayList<Style>();
	}
	public void add_sstyle(Style s){
		fils.add(s);
	}
	public int nb_fils(){
		return fils.size();
	}
	public String get_nomS(){
		return nom;
	}
	/*
	 * Fonction de comparaison : Sous-style avec un Genre
	 */
	public float comparer(Genre s){
		float resultat;
		//Cas 1 : Le père est un genre
		if (this.pere.est_genre()){
			//Cas 1-1 : Le père est le genre recherché
			if (pere == s) resultat = id; 
			//Cas 1-2 : Le père n'est pas le genre recherché 
			else resultat = id + pere.comparer(s);
		}
		//Cas 2 : Le père est un autre sous_style :
		else return (id + comparer(pere)); 
		
		return resultat;
	}

	public float comparer(Style s){
		float res = 0;
		//Parcours d'arbre : Cas d'arrêt
		if(this.a_pour_fils(s))	res = s.id;
		else if(s.a_pour_fils(this))	res = this.id;
		//S'ils ont le même père :
		else if(this.pere == s.pere)	res = this.id + s.id;
		//Cas les deux sont au niveau 3 : ils n'ont pas le même père
		else if((!this.pere.est_genre()) && !s.pere.est_genre())	res = this.id + s.id + this.pere.comparer(s.pere);
		else if((!this.pere.est_genre())&& s.pere.est_genre())	res = this.id + s.id + this.pere.comparer(s);
		else if((this.pere.est_genre())&&!s.pere.est_genre())	res = this.id + s.id + this.comparer(s.pere);
		//Cas les deux sont au niveau 2 : ils n'ont pas le même père
		else if((this.pere.est_genre())&&s.pere.est_genre())	res = this.id + s.id + this.pere.comparer(s.pere);
		return res;
	}
	
}
