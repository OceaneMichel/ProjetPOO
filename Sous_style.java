package poo;

/**
 * Classe qui sera implémentée par les programmeurs
 * @author oceane
 *
 */
public class Sous_style extends Genre implements Comparable<Genre>{
	private Genre pere;
	/**
	 * Constructeur de sous_style
	 * @param n le nom du style
	 * @param i le numéro du fils (et son rapport d proximité par rapport au Style père)
	 */
	public Sous_style(String n){
		super(n);
		//this.pere = p;
	}
	
	public float comparer(Genre s){
		return 0;
	}

	public float comparer(Sous_style s){
		return 0;
	}
	
}
