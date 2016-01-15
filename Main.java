package poo;

import java.lang.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class Main {

	
	
	public static void main(String[] args) {
		
		ArrayList<Genre> liste_genres = init.recuperer_arbre();
		int i;
		ArrayList<Chanson> liste_chansons = init.recuperer_chansons();
		for(i=0;i<11;i++)	liste_genres.get(i).afficher();
		
		Genre blues = liste_genres.get(0);
		Genre enfant = liste_genres.get(1);
		Genre classique = liste_genres.get(2);
		Genre country = liste_genres.get(3);
		Genre electronic = liste_genres.get(4);
		Genre folk = liste_genres.get(5);
		Genre disco = liste_genres.get(6);
		Genre jazz = liste_genres.get(7);
		Genre pop_rock = liste_genres.get(8);
		Genre r_and_b = liste_genres.get(9);
		Genre rap = liste_genres.get(10);
		Genre reggae = liste_genres.get(11);
		
		//System.out.println(blues.comparer(jazz.fils.get(1).fils.get(0)));
		Style s = jazz.fils.get(1).fils.get(0);
		System.out.println("Distance Genre - Genre : "+ pop_rock.comparerG(classique));// OK
		System.out.println("Distance Genre - Sous-Style à lui: "+ rap.comparer(rap.fils.get(1))); // OK
		System.out.println("Distance Genre - Sous-Sous-Style à lui: "+ rap.comparer(rap.fils.get(2).fils.get(1))); // OK
		System.out.println("Distance Genre - Sous-Style pas à lui: "+ jazz.comparer(blues.fils.get(0))); // OK
		System.out.println("Distance Genre - Sous-Sous-Style pas à lui: "+ jazz.comparer(blues.fils.get(0).fils.get(1))); // OK
		
		
		System.out.println("Distance Sous-Sous-Style frères: "+ jazz.fils.get(1).fils.get(0).comparer(jazz.fils.get(1).fils.get(1))); // OK
		System.out.println("Distance Sous-sous styles cousins : "+ electronic.fils.get(0).fils.get(0).comparer(electronic.fils.get(1).fils.get(0)));// OK
		System.out.println("Distance Sous-sous-styles éloignés : " + rap.fils.get(2).fils.get(1).comparer(pop_rock.fils.get(4).fils.get(0))); // OK
		System.out.println("Distance Sous-sous-style - son père : " + blues.fils.get(0).fils.get(1).comparer(blues.fils.get(0))); // OK
		System.out.println("Distance Sous-sous-style - son genre grand-pèere : " + blues.fils.get(0).fils.get(1).comparer(blues)); // OK
		System.out.println("Distance Sous-sous-style - un genre éloigné :" + blues.fils.get(0).fils.get(1).comparer(jazz)); // OK
		System.out.println("Distance Sous-sous-style - un sous-style cousin : " + folk.fils.get(0).fils.get(0).comparer(folk.fils.get(1))); // OK
		System.out.println("Distance Sous-sous-style - un sous-style éloigné : " + folk.fils.get(0).fils.get(0).comparer(rap.fils.get(1))); //OK
		
		System.out.println("Distance Sous-style - son fils : " + blues.fils.get(0).comparer(blues.fils.get(0).fils.get(0))); // OK
		System.out.println("Distance Sous-style - son pere : " + blues.fils.get(2).comparer(blues.fils.get(2).pere) ); // OK
		System.out.println("Distance Sous-style - sous-style frere : " + jazz.fils.get(0).comparer(jazz.fils.get(2))); // OK
		System.out.println("Distance Sous-style - sous-sous-style neveu: " + electronic.fils.get(0).comparer(electronic.fils.get(1).fils.get(0)) ); // OK
		System.out.println("Distance Sous-style - genre éloigné : " + jazz.fils.get(0).comparer(reggae)); // OK
		System.out.println("Distance Sous-style - sous-style éloigné " + jazz.fils.get(0).comparer(rap.fils.get(1)) ); //OK
		System.out.println("Distance Sous-style - sous-sous-style éloigné : " + jazz.fils.get(0).comparer(country.fils.get(1).fils.get(0)) ); //OK
		
		ArrayList<Artiste> liste_artistes = init.recuperer_artistes();
		
	}

}
