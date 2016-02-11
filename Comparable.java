package poo;

import java.util.ArrayList;

public interface Comparable<T> {
	/**
	 * Chaque classe implémentant l'interface Comparable devra 
	 * pouvoir rendre un pourcentage (float) de ressemblance
	 * @param element
	 * @return Le pourcentage de ressemblance : float entre 0 et 1
	 */
	public float comparer(T element);
}
