package poo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class init {
	/**
	 * Fonction qui permet de récupérer les genres de la BDD et de créer une ArrayList contenant les genres définis dans la BDD.
	 * @return La liste des genres
	 */
	public static ArrayList<Genre> recuperer_genres(){
		ArrayList<Genre> liste = new ArrayList<Genre>();
		//Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/Projet_Poo";
		String login = "root";
		String passwd = "projet";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			//Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			//Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();
			String sql = "SELECT * FROM Genre";
			//Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			//Etape 5 : (Parcours Resultset)
			while(rs.next()){
				System.out.println(rs.getString("idG") + " " + rs.getString("nomG"));
				liste.add(new Genre(rs.getString("nomG"), rs.getInt("idG"))); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try{
				// Etape 5 : libérer les ressources de la mémoire
				cn.close();
				st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		/* On définit la distance entre les genres et la liste de ses sous-styles attribués : */
		// id 1 : blues 
		liste.get(0).set_distance(liste.get(0), 0);
		liste.get(0).set_distance(liste.get(1), 0);
		liste.get(0).set_distance(liste.get(2), 0);
		liste.get(0).set_distance(liste.get(3), 0);
		liste.get(0).set_distance(liste.get(4), 0);
		liste.get(0).set_distance(liste.get(5), 0);
		liste.get(0).set_distance(liste.get(6), 0);
		liste.get(0).set_distance(liste.get(7), 0);
		liste.get(0).set_distance(liste.get(8), 0);
		liste.get(0).set_distance(liste.get(9), 0);
		liste.get(0).set_distance(liste.get(10), 0);
		liste.get(0).set_distance(liste.get(11), 0);
		liste.get(0).set_distance(liste.get(12), 0);
		liste.get(0).set_distance(liste.get(13), 0);
		return liste;
	}
	
	/**
	 * Fonction qui permet de récupérer les artistes de la BDD et de créer une ArrayList contenant les artistes définis dans la BDD.
	 * @return La liste des artistes
	 */
	public static ArrayList<Artiste> recuperer_artistes(){
		ArrayList<Artiste> liste = new ArrayList<Artiste>();
		//Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/Projet_Poo";
		String login = "root";
		String passwd = "projet";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			//Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			//Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();
			String sql = "SELECT * FROM Artiste";
			//Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			//Etape 5 : (Parcours Resultset)
			while(rs.next()){
				System.out.println(rs.getString("idAr") + " " + rs.getString("nomAr") + " " + rs.getString("type"));
				liste.add(new Artiste(rs.getInt("idAr"), rs.getString("nomAr"), rs.getString("type"))); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try{
				// Etape 5 : libérer les ressources de la mémoire
				cn.close();
				st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return liste;
	}
}
