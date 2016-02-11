package poo;
import java.lang.*;
/**
 * Classe d'artistes, repr&eacute;sent&eacute;s dans la BDD<br>
 * @author Oc&eacute;ane MICHEL/ L&eacute;o GARREAU
 *
 */
public class Artiste implements Comparable {
	private int idAr;
	private String nomAr;
	private String type;
	
	/**
	 * Constructeur d'Artiste, sert principalement lors de la r&eacute;cup&eacute;ration des donn&eacute;es dans la BDD
	 * @param id	l'identifiant unique d'un artiste
	 * @param nom	nom/pr&eacute;nom/groupe de l'artiste
	 * @param t		Chanteur, Compositeur ou Chanteur-Compositeur 
	 */
	public Artiste(int id, String nom, String t){
		idAr = id;
		nomAr = nom;
		type = t;
	}

	/**
	 * Fonction de comparaison d'artistes-artistes en fonction de leur nom (ordre Alphab&eacute;tique)<br>
	 * Permet ensuite de trier les ArrayList d'Artiste<br>
	 * Utilise la fonction compareTo de String 
	 */
	@Override
	public float comparer(Object element) {
		element = (Artiste) element;
		return nomAr.compareTo(((Artiste)element).getNomA());
	}
	
	/**
	 * Getter : NomAr<br>
	 * Renvoie le NomAr de l'artiste
	 */
	public String getNomA(){return nomAr;}

	/**
	 * Getter : type<br>
	 * Renvoie le type de l'artiste
	 */
	public String getType(){return type;}
}
