package poo;

import java.util.ArrayList;

/**
 * Classe qui sera implémentée par les programmeurs
 * @author oceane
 *
 */
public class Style implements Comparable<Genre>{
	public int idSS;
	public Style pere;
	public String nom;
	public ArrayList<Style> fils;
	public int dist_genres[];
	
	public Style(String n, int id){
		nom = n;
		idSS = id;
		fils = new ArrayList<Style>();
		dist_genres = new int [100];
		this.pere = null;
	}
	/**
	 * Constructeur de sous_style
	 * @param n le nom du style
	 * @param i le numéro du fils (et son rapport d proximité par rapport au Style père)
	 */
	public Style(String n, int id, Style p){
		
		nom = n ;
		idSS = id;
		this.pere = p;
		fils = new ArrayList<Style>();
		dist_genres = new int[100];
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
	public boolean est_genre(){
		return (pere == null);
	}
	/**
	 * Fonction qui détermine si s est un fils direct du genre
	 * @param s
	 * @return
	 */
	public int a_pour_fils(Style s){
		int res =-1;
		int i;
		if(nb_fils() != 0 ){
		
			for(i=0; i<nb_fils(); i++){
				if(fils.get(i) == s)	res = this.idSS;
			}
		}
		return res;
		}
	/**
	 * Renvoie -1 si le Genre n'a pas le style comme petit-fils
	 * Renvoie l'id du père sinon
	 */
	public int a_pour_petit_fils(Style s){
		int res = -1;
		int i, j;
		//Ne marche que pour les genres : 
		if(est_genre()){
			for(i=0; i<nb_fils(); i++){
				
				if(fils.get(i).a_pour_fils(s)!=-1)	res = fils.get(i).a_pour_fils(s);
			}
			}
		return res;
		
	}
	public float comparerG(Style s){
		return this.dist_genres[s.idSS];
	}
	
	/*
	 * Fonction de comparaison : Sous-style avec un Genre
	 */
	public float comparer(Genre s){
		float resultat;
		//Cas 1 : Le père est un genre
		if (this.pere.est_genre()){
			//Cas 1-1 : Le père est le genre recherché
			if (pere == s) resultat = idSS; 
			//Cas 1-2 : Le père n'est pas le genre recherché 
			else resultat = idSS + ((Genre)pere).comparerG(s);
		}
		else if (this.pere.pere.est_genre() && this.pere.pere == s)	resultat = idSS + pere.idSS;
		//Cas 2 : Le père est un autre sous_style :
		else resultat = idSS + pere.comparer(s); 
		
		return resultat;
	}

	public float comparer(Style s){
		float res = 0;
		if(this == s )	res = 0;
		else if(a_pour_fils(s)!=-1)	res = s.idSS;
		else if(s.a_pour_fils(this)!=-1)	res = this.idSS;
		//S'ils ont le même père :
		else if(this.pere == s.pere)	res = this.idSS + s.idSS;
		//Cas les deux sont au niveau 3 : ils n'ont pas le même père
		else if((!this.pere.est_genre()) && !s.pere.est_genre())	res += this.idSS + s.idSS + this.pere.comparer(s.pere);
		else if((!this.pere.est_genre())&& s.pere.est_genre())	res += this.idSS + s.idSS + this.pere.comparer((Genre)s.pere);
		else if((this.pere.est_genre())&&!s.pere.est_genre())	res += this.idSS + s.idSS + this.pere.comparer(s.pere);
		//Cas les deux sont au niveau 2 : ils n'ont pas le même père
		else if((this.pere.est_genre())&&s.pere.est_genre()){
			res += this.idSS + s.idSS + ((Genre)pere).comparerG((Genre)s.pere);
		}
		return res;
	}
	
}
