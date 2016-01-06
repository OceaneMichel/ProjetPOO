package poo;

import java.lang.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class Main {

	
	
	public static void main(String[] args) {
		
		ArrayList<Genre> liste_genres = init.recuperer_genres();
		liste_genres.get(5).afficher();
		
		ArrayList<Artiste> liste_artistes = init.recuperer_artistes();
	}

}
