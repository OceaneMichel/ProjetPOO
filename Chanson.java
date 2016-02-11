package poo;

import java.sql.Time;
import java.util.ArrayList;
/**
 * Classe de Chansons, repr&eacute;sent&eacute;s dans la BDD<br>
 * @author Oc&eacute;ane MICHEL/ L&eacute;o GARREAU
 *
 */
public class Chanson extends Profil implements Comparable<Profil>{
	public int id;
	public String titre;
	public String artiste;
	public String album;
	public int annee;
	private Style style1;
	private Style style2;
	private Style style3;
	private String theme;
	private Time duree;
	private int rythme;
	private String paroles;
	private String instrument;
/**
 * Constructeur de Chanson
 * @param idc			Identifiant unique de la chanson
 * @param Titre			Le titre de la Chanson
 * @param Artiste		Le nom/pr&eacute;nom/groupe de l'artiste
 * @param Album			L'album de la chanson
 * @param Annee			L'ann&eacute;e de sortie de la chanson
 * @param Style1		Le 1er Style de la chanson (!=null)
 * @param Style2		Le 1er Style de la chanson
 * @param Style3		Le 1er Style de la chanson
 * @param Theme			Le theme de la chanson
 * @param Duree			La dur&eacute;e de la chanson
 * @param Rythme		Le Rythme de la chanson
 * @param Paroles		Les Paroles de la chanson
 * @param Instrument	Le(s) instrument(s) pr&eacute;sent(s) dans la chanson	
 */
	public Chanson(int idc, String Titre, String Artiste, String Album, int Annee, Style Style1, Style Style2, Style Style3, String Theme, Time Duree, int Rythme, String Paroles, String Instrument){
		id = idc;
		titre = Titre;
		artiste = Artiste;
		album = Album;
		annee = Annee;
		style1 = Style1;
		style2 = Style2;
		style3 = Style3;
		theme = Theme;
		duree = Duree;
		rythme = Rythme;
		paroles = Paroles ;
		instrument = Instrument;
	}
	/**
	 * Getter : Ann&eacute;e<br>
	 * Renvoie l'ann&eacute;e de sortie de la chanson
	 */
	public int getAnnee(){return annee;}
	
	/**
	 * Getter : Titre<br>
	 * Renvoie le titre de la chanson
	 */
	public String getTitre(){return titre;}
	
	/**
	 * Getter : Artiste<br>
	 * Renvoie l'artiste de la chanson
	 */
	public String getArtiste(){return artiste;}
	
	/**
	 * Getter : Duree<br>
	 * Renvoie la dur&eacute;e de la chanson
	 */
	public Time getDuree(){return duree;}
	
	/**
	 * Getter : Style1<br>
	 * Renvoie le style n&deg;1 de la chanson
	 */
	public Style getSt1(){return style1;}
	
	/**
	 * Getter : Style2<br>
	 * Renvoie le style n&deg;2 de la chanson
	 */
	public Style getSt2(){return style2;}
	
	/**
	 * Getter : Style3<br>
	 * Renvoie le style n&deg;3 de la chanson
	 */
	public Style getSt3(){return style3;}
	
	/**
	 * Comparer les instruments de cette chanson, et d'une autre
	 * @param c	la chanson dont il faut comparer l'instrument
	 * @return	1 si les instruments sont les mêmes, 0 sinon
	 */
	public float comparer_instrument(Chanson c){
		float resultat;
		if(this.instrument.equals(c.instrument))	resultat = 1;
		else resultat = 0;
		
		return resultat;
	}

	/**
	 * Comparaison des styles entre deux chansons/deux profils : <br>
	 * Plusieurs cas : On diff&eacute;rencie selon le nombre d'entrées nulles dans la BDD
	 * @param 	p Le profil dont il faut comparer les styles
	 * @return	le pourcentage de proximit&eacute; des styles
	 */
	public float comparer_styles(Profil p){
		float result = 0;
		int n = 0;
		if(titre.equals(p.getTitre()))	return 1; // Permet d'éviter de trop longs calculs si les chansons sont les mêmes
		
			if(style2==null && style3 == null && p.getSt2() == null && p.getSt3() == null)	n = 1; 
			else if(style2 == null && style3 == null && p.getSt3()==null)					n = 2;
			else if(style3==null && p.getSt2()==null && p.getSt3()==null)					n = 3;
			else if(style3==null && p.getSt3()==null)										n = 4;
			else if(style2==null && style3==null)											n = 5;
			else if(p.getSt2()==null && p.getSt3()==null)									n = 6;
			else if(style3==null) 															n = 7;
			else if(p.getSt3()==null)														n = 8;
			else 																			n = 9;
			
			switch(n){
			case 1 :	result = (style1.comparer(p.getSt1()));	break;
			case 2 :	result = Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())); break;
			case 3 :	result = Math.max(style1.comparer(p.getSt1()), style2.comparer(p.getSt1())); break;
			case 4 :	result = Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())) * (float)0.5;
						result +=Math.max(style2.comparer(p.getSt1()), style2.comparer(p.getSt2())) * (float)0.5; break;
			case 5 :	result = Math.max(Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), style1.comparer(p.getSt3()));	break;
			case 6 :	result = Math.max(Math.max(style1.comparer(p.getSt1()), style2.comparer(p.getSt1())), style3.comparer(p.getSt1()));	break;
			case 7 :	result = Math.max( Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), style1.comparer(p.getSt3()) ) * (float)0.5;
						result += Math.max( Math.max(style2.comparer(p.getSt1()), style2.comparer(p.getSt2())), style2.comparer(p.getSt3()) ) * (float)0.5;	break;
			case 8 :	result = Math.max( Math.max(style1.comparer(p.getSt1()), style2.comparer(p.getSt1())), style3.comparer(p.getSt1()) ) * (float)0.5;
						result += Math.max( Math.max(style1.comparer(p.getSt2()), style2.comparer(p.getSt2())), style3.comparer(p.getSt2()) ) * (float)0.5;	break;
			case 9 :	result = Math.max( Math.max(style1.comparer(p.getSt1()), style1.comparer(p.getSt2())), style1.comparer(p.getSt3()) ) * (float)(1/3);
						result += Math.max( Math.max(style2.comparer(p.getSt1()), style2.comparer(p.getSt2())), style2.comparer(p.getSt3()) ) * (float)(1/3);	
						result += Math.max( Math.max(style3.comparer(p.getSt1()), style3.comparer(p.getSt2())), style3.comparer(p.getSt3()) ) * (float)(1/3); break;
			}
			return result;			
	}
	
	/**
	 * Comparaison des themes ente deux chansons/deux profils<br>
	 * @param p Le profil dont il faut comparer le theme
	 * @return	Le pourcentage de proximit&eacute; : 1 si les themes sont identiques, 0 sinon
	 */
	public float comparer_theme(Profil p) {
		if(titre.equals(p.getTitre()))return 1;
		float result = 0 ;
		try{
			if(theme.equals(p.getTheme()))	result = 1;
		}catch(Exception e){System.out.println("Un des thèmes est null");}
		return result;
	}
	
	/**
	 * Comparaison des dur&eacute;es de deux chansons/deux profils<br>
	 * Calcule la diff&eacute;rence d entre les dur&eacute;es, renvoie un float en fonction de d 
	 * @param p Le profil dont il faut comparer la dur&eacute;e
	 * @return	Le pourcentage de proximit&eacute; : 1 moins 0.005 par seconde de diff&eacuterence 
	 */
	public float comparer_duree(Profil p){
		Duree d = new Duree(this.duree);
		Duree d2 = new Duree(p.getDuree());
		d = d.difference(d2);
		float result=1;
		
		int secondesdifferences = d.getSecondes()+d.getMinutes()*60+d.getHeures()*3600;
			for(int i = 0; i<secondesdifferences; i++)	result-=0.005;
		System.out.println(d.getSecondes()+" "+d.getMinutes());
		if(result<=0) result = 0;
		return result;
 	}
	
	/**
	 * Comparaison des ann&eacute;es entre deux chansons/deux profils
	 * @param p Le profil dont il faut comparer l'ann&eacute;e
	 * @return Le pourcentage de proximit&eacute; : 1 moins 0.1 par ann&eacute;e de diff&eacute;rence, 0 au minimum.
	 */
	public float comparer_annee(Profil p){
		float result = Math.abs(this.annee-p.getAnnee());
		result = 1-result/10;
		if(result<=0)	result = 0;
		return result;
	}
	
	/**
	 * Red&eacute;finition de la m&eacute;thode toString() pour une Chanson<br>
	 * Renvoie "Titre - Artiste"
	 */
	public String toString(){
		return (titre+ " - " + artiste);
	}
	
	/**
	 * Comparaison g&eaute;n&eacute;rale de deux chansons/deux profils<br>
	 * La d&eacute;finition des coefficients se fait au d&eacute;sir des programmeurs et peuvent &ecirc;tre chang&eacute;s &agrave; tout moment.<br>
	 * Cette m&eacute;thode appelle ensuite toutes les autres m&eacute;thodes de comparaison d&eacutefinies avant pour les chansons/profils.
	 * @return Le pourcentage de proximit&eacute; total entre deux chansons/deux profils 
	 */
	@Override
	public float comparer(Profil profil) {
		if(this.equals(profil))return 1;
		float coefficient_style = (float) 0.55;
		float coefficient_theme = (float) 0.10;
		float coefficient_duree = (float) 0.20;
		float coefficient_annee = (float) 0.15;
		System.out.println("Styles : " + comparer_styles(profil));
		System.out.println("themes : " + comparer_theme(profil));
		System.out.println("duree : " + comparer_duree(profil));
		System.out.println("annee : " + comparer_annee(profil));
		return(	coefficient_style * this.comparer_styles(profil)
				+ coefficient_theme * this.comparer_theme(profil)
				+ coefficient_duree * this.comparer_duree(profil)
				+ coefficient_annee * this.comparer_annee(profil));
	}
	
}
