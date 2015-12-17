package poo;

/**
 * Classe qui sera implémentée par les programmeurs
 * @author oceane
 *
 */
public class Sous_style extends Style implements Comparable<Style>{
	private int num_fils;
	private Style pere;
	/**
	 * Constructeur de sous_style
	 * @param n le nom du style
	 * @param i le numéro du fils (et son rapport d proximité par rapport au Style père)
	 */
	public Sous_style(String n, int i, Style p){
		super(n);
		this.num_fils = i;
		this.pere = p;
	}
	
	public float comparer(Style s){
		return 0;
	}

	public float comparer(Sous_style s){
		return 0;
	}
	
}
