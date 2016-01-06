package poo;
import java.io.File;
import java.io.IOException;


public class Style implements Comparable<Style> {
	private int tab[];
	protected String nom;
	private int id;
	
	public Style(String n){
		nom = n;
	}
	
	public Style(String n, int i){
		nom = n;
		id = i;
		tab[id] = 0;
	}
	
	public void set_distance(int i, int distance){
		this.tab[i] = distance;
	}
	
	public float comparer(Style s){
		int distance = this.tab[s.id];
		float resultat;
		resultat = (float)(100-distance*20)/100;
		if(resultat<=0)	resultat = 0;
		
		return resultat;
	}
	
	public float comparer(Sous_style s){
		return 0;
	}
}
