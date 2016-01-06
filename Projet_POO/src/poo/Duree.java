package poo;

/**
 * Classe Durée - Comparable
 * Représente la durée d'une chanson
 * @author oceane
 *
 */
public class Duree implements Comparable<Duree>{

	private int min;
	private int sec;
	
	public Duree(int m, int s){
		if(m<0)	min = Math.abs(m);
		else	min = m;
		
		if(s>=60){	
			sec = s%60;
			min += s/60;
		}
		else 	sec = s;
	}
	
	public float comparer(Duree d){
		float resultat;
		int d_com = d.min - min;
		int d_cos = d.sec - sec;
		d_com = Math.abs(d_com);
		d_cos = Math.abs(d_cos);
		
		//On arrondie le nombre de minutes au supérieur si le nombre de sec > 30
		if(d_cos>30)	d_com++;
		
		if(d_com == 0)	resultat = 1;
		else if(d_com == 1) resultat = (float)0.6;
		else if(d_com == 2) resultat = (float)0.3;
		else resultat = 0;
		
		return resultat;
	}
		
	public void out(){
		System.out.print(min + "min" + " ");
		if(sec<10)	System.out.println("0" + sec + "sec");
		else System.out.println(sec + "sec");
	}
};
