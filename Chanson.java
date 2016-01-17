package poo;

import java.sql.Time;
import java.util.ArrayList;

public class Chanson extends Profil implements Comparable<Profil>{
	private int id;
	public String titre;
	public String artiste;
	public String album;
	public Style style1;
	public Style style2;
	public Style style3;
	private String theme;
	private Time duree;
	private int rythme;
	private String paroles;
	private String instrument;

	public Chanson(int idc, String ti, String art, String alb, Style st1, Style st2, Style st3, String th, Time d, int ry, String pa, String i){
		id = idc;
		titre = ti;
		artiste = art;
		album = alb;
		style1 = st1;
		style2 = st2;
		style3 = st3;
		theme = th;
		duree = d;
		rythme = ry;
		paroles = pa ;
		instrument = i;
	}
	public float comparer_instrument(Chanson c){
		float resultat;
		if(this.instrument.equals(c.instrument))	resultat = 1;
		else resultat = 0;
		
		return resultat;
	}

	/**
	 * Comparaison des styles entre deux chansons/ deux profils : 
	 * Plusieurs cas : On différencie selon le nombre d'entrées nulles dans la BDD
	 * @param p
	 * @return
	 */
	public float comparer_styles(Profil p){
			float result = 0;
			if(style2==null && style3 == null){
				result = Math.max(Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), (style1.comparer(p.getSt3())));
			}
			else if(p.getSt2()==null && p.getSt3() == null) result = Math.max(Math.max(style1.comparer(p.getSt1()), style2.comparer(p.getSt1())), (style3.comparer(p.getSt1())));
			else if(style3==null){
				result = Math.max( Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), style1.comparer(p.getSt3()) ) * (float)0.5;
				result += Math.max( Math.max(style2.comparer(p.getSt1()), style2.comparer(p.getSt2())), style2.comparer(p.getSt3()) ) * (float)0.5;
			}
			else if(p.getSt3()==null){
				result = Math.max( Math.max(style1.comparer(p.getSt1()), style2.comparer(p.getSt1())), style3.comparer(p.getSt1()) ) * (float)0.5;
				result += Math.max( Math.max(style1.comparer(p.getSt2()), style2.comparer(p.getSt2())), style3.comparer(p.getSt2()) ) * (float)0.5;	
			}
			else {	
				result = Math.max( Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), style1.comparer(p.getSt3()) ) * (float)(1/3);
				result += Math.max( Math.max(style2.comparer(p.getSt1()), style2.comparer(p.getSt2())), style2.comparer(p.getSt3()) ) * (float)(1/3);	
				result += Math.max( Math.max(style3.comparer(p.getSt1()), style3.comparer(p.getSt2())), style3.comparer(p.getSt3()) ) * (float)(1/3);	}

			
			return result;
			
	}
	
	public float comparer_theme(Profil p) {
		float result ; 
		if(theme.equals(p.getTheme()))	result = (float) 1;
		else result = (float) 0;
		return result;
	}
	
	public float comparer_duree(Profil p){
		float result;
		if(this.duree == null || p.getDuree() == null)result = (float) 0;
		else result = (float) 0.1;
		return result;
 	}
	
	
	@Override
	public float comparer(Profil profil) {
		float coefficient_style = (float) 0.45;
		float coefficient_theme = (float) 0.30;
		float coefficient_duree = (float) 0.15;
		float coefficient_rythme = (float) 0.05;
		float coefficient_instrument = (float) 0.05;
		return(	coefficient_style * this.comparer_styles(profil)
				+ coefficient_theme * this.comparer_theme(profil)
				+ coefficient_duree * this.comparer_duree(profil));
	}
	
}
