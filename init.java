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
				/* Affiche les données récupérées dans la BDD
				System.out.println(rs.getString("idG") + " " + rs.getString("nomG"));
				*/
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

		Genre blues = liste.get(0);
		Genre enfant = liste.get(1);
		Genre classique = liste.get(2);
		Genre country = liste.get(3);
		Genre electronic = liste.get(4);
		Genre folk = liste.get(5);
		Genre disco = liste.get(6);
		Genre jazz = liste.get(7);
		Genre pop_rock = liste.get(8);
		Genre r_and_b = liste.get(9);
		Genre rap = liste.get(10);
		Genre reggae = liste.get(11);
		/* On définit la distance entre les genres et la liste de ses sous-styles attribués : */
		
		// LISTE GENRES : ID 1 - BLUES 

		blues.set_distance(blues, 1);   
		blues.set_distance(enfant, 118); 
		blues.set_distance(classique, 1083);
		blues.set_distance(country, 504); 
		blues.set_distance(electronic, 836);
		blues.set_distance(folk, 124); 
		blues.set_distance(disco, 297); 
		blues.set_distance(jazz, 147); 
		blues.set_distance(pop_rock, 772); 
		blues.set_distance(r_and_b, 547); 
		blues.set_distance(rap, 759);
		blues.set_distance(reggae, 582);
		// LISTE SOUS-STYLES - BLUES
		blues.add_sstyle(new Sous_style("acoustic_blues",1,blues));
		blues.add_sstyle(new Sous_style("electric_blues",2, blues));
		blues.add_sstyle(new Sous_style("country_blues",3, blues));
		
		// LISTE GENRES : ID 2 - ENFANT 
		
		enfant.set_distance(blues, 175);
		enfant.set_distance(enfant, 1);
		enfant.set_distance(classique, 1292);
		enfant.set_distance(country, 444);
		enfant.set_distance(electronic, 648);
		enfant.set_distance(folk, 352);
		enfant.set_distance(disco, 215);
		enfant.set_distance(jazz, 806);
		enfant.set_distance(pop_rock, 770);
		enfant.set_distance(r_and_b, 231);
		enfant.set_distance(rap, 600);
		enfant.set_distance(reggae, 407);
		
		// LISTE SOUS-STYLES - ENFANT
		enfant.add_sstyle(new Sous_style("capoeira" ,1,enfant));
		enfant.add_sstyle(new Sous_style("education",2,enfant));
		enfant.add_sstyle(new Sous_style("comique",3,enfant));

		// LISTE GENRES : ID 3 - CLASSIQUE
		
		classique.set_distance(blues, 368); 
		classique.set_distance(enfant, 567); 
		classique.set_distance(classique, 1);   
		classique.set_distance(country, 806); 
		classique.set_distance(electronic, 847);
		classique.set_distance(folk, 223); 
		classique.set_distance(disco, 837); 
		classique.set_distance(jazz, 167); 
		classique.set_distance(pop_rock, 784); 
		classique.set_distance(r_and_b, 984); 
		classique.set_distance(rap,1212);
		classique.set_distance(reggae,1139);
		// LISTE SOUS-STYLES - BLUES
		classique.add_sstyle(new Sous_style("ballet",1,classique));
		classique.add_sstyle(new Sous_style("concerto",2,classique));
		classique.add_sstyle(new Sous_style("symphony",3,classique));
		classique.add_sstyle(new Sous_style("renaissance",4,classique));
		classique.add_sstyle(new Sous_style("orchestral",5,classique));
		classique.add_sstyle(new Sous_style("opera",6,classique));
		
		// LISTE GENRES : ID 4 - COUNTRY
		
		country.set_distance(blues, 759); 
		country.set_distance(enfant, 455); 
		country.set_distance(classique, 1315);
		country.set_distance(country, 1);   
		country.set_distance(electronic, 757);
		country.set_distance(folk, 437); 
		country.set_distance(disco, 442); 
		country.set_distance(jazz, 1129);
		country.set_distance(pop_rock, 91);  
		country.set_distance(r_and_b, 276); 
		country.set_distance(rap,877); 
		country.set_distance(reggae,1063);
		// LISTE SOUS-STYLES - COUNTRY
		country.add_sstyle(new Sous_style("country_pop",1,country));
		country.add_sstyle(new Sous_style("progressive_country",2,country));
		country.add_sstyle(new Sous_style("traditional_country",3,country));

		
		// LISTE GENRES : ID 5 - ELECTRONIC
		
		electronic.set_distance(blues, 1102);
		electronic.set_distance(enfant, 575); 
		electronic.set_distance(classique, 1326);
		electronic.set_distance(country, 812); 
		electronic.set_distance(electronic, 1);  
		electronic.set_distance(folk, 1035);
		electronic.set_distance(disco, 299); 
		electronic.set_distance(jazz, 1253);
		electronic.set_distance(pop_rock, 564); 
		electronic.set_distance(r_and_b, 578); 
		electronic.set_distance(rap,543); 
		electronic.set_distance(reggae,758); 
		// LISTE SOUS-STYLES - ELECTRONIC
		electronic.add_sstyle(new Sous_style("house",1,electronic));
		electronic.add_sstyle(new Sous_style("techno",2,electronic));
		electronic.add_sstyle(new Sous_style("trance",3,electronic));


		// LISTE GENRES : ID 6 - FOLK
		
		folk.set_distance(blues, 185); 
		folk.set_distance(enfant, 312); 
		folk.set_distance(classique, 1024);
		folk.set_distance(country, 346); 
		folk.set_distance(electronic, 862);
		folk.set_distance(folk, 1);   
		folk.set_distance(disco, 569); 
		folk.set_distance(jazz, 324); 
		folk.set_distance(pop_rock, 578); 
		folk.set_distance(r_and_b, 631); 
		folk.set_distance(rap,1018);
		folk.set_distance(reggae,1013);
		// LISTE SOUS-STYLES - FOLK
		folk.add_sstyle(new Sous_style("contemporary_folk",1,folk));
		folk.add_sstyle(new Sous_style("traditional_folk",2,folk));

		// LISTE GENRES : ID 7 - DISCO 

		disco.set_distance(blues, 438);   
		disco.set_distance(enfant, 93); 
		disco.set_distance(classique, 1330);
		disco.set_distance(country, 314); 
		disco.set_distance(electronic, 305);
		disco.set_distance(folk, 608); 
		disco.set_distance(disco, 1); 
		disco.set_distance(jazz, 980); 
		disco.set_distance(pop_rock, 570); 
		disco.set_distance(r_and_b, 102); 
		disco.set_distance(rap, 86);
		disco.set_distance(reggae, 269);
		// LISTE SOUS-STYLES - disco
		disco.add_sstyle(new Sous_style("funk",1,disco));

		// LISTE GENRES : ID 8 - JAZZ 

		jazz.set_distance(blues, 69);   
		jazz.set_distance(enfant, 313); 
		jazz.set_distance(classique, 439);
		jazz.set_distance(country, 686); 
		jazz.set_distance(electronic, 857);
		jazz.set_distance(folk, 110); 
		jazz.set_distance(disco, 498); 
		jazz.set_distance(jazz, 1); 
		jazz.set_distance(pop_rock, 805); 
		jazz.set_distance(r_and_b, 824); 
		jazz.set_distance(rap, 977);
		jazz.set_distance(reggae, 822);
		// LISTE SOUS-STYLES - JAZZ
		jazz.add_sstyle(new Sous_style("classic_jazz",1,jazz));
		jazz.add_sstyle(new Sous_style("swing",2,jazz));
		jazz.add_sstyle(new Sous_style("groove",3,jazz));

				// LISTE GENRES : ID 9 - POP-ROCK 

		pop_rock.set_distance(blues, 1052);   
		pop_rock.set_distance(enfant, 795); 
		pop_rock.set_distance(classique, 1319);
		pop_rock.set_distance(country, 116); 
		pop_rock.set_distance(electronic, 642);
		pop_rock.set_distance(folk, 725); 
		pop_rock.set_distance(disco, 677); 
		pop_rock.set_distance(jazz, 1243); 
		pop_rock.set_distance(pop_rock, 1); 
		pop_rock.set_distance(r_and_b, 480); 
		pop_rock.set_distance(rap, 1047);
		pop_rock.set_distance(reggae, 1230);
		// LISTE SOUS-STYLES - pop_rock
		pop_rock.add_sstyle(new Sous_style("indie_rock",1,pop_rock));
		pop_rock.add_sstyle(new Sous_style("heavy_metal",2,pop_rock));
		pop_rock.add_sstyle(new Sous_style("rock_and_roll",3,pop_rock));
		pop_rock.add_sstyle(new Sous_style("country_rock",4,pop_rock));
		pop_rock.add_sstyle(new Sous_style("hard_rock",5,pop_rock));
		pop_rock.add_sstyle(new Sous_style("dance",6,pop_rock));

		// LISTE GENRES : ID 10 - R&B 

		r_and_b.set_distance(blues, 792);   
		r_and_b.set_distance(enfant, 250); 
		r_and_b.set_distance(classique, 1332);
		r_and_b.set_distance(country, 227); 
		r_and_b.set_distance(electronic, 614);
		r_and_b.set_distance(folk, 725); 
		r_and_b.set_distance(disco, 238); 
		r_and_b.set_distance(jazz, 1143); 
		r_and_b.set_distance(pop_rock, 434); 
		r_and_b.set_distance(r_and_b, 1); 
		r_and_b.set_distance(rap, 296);
		r_and_b.set_distance(reggae, 579);
		// LISTE SOUS-STYLES - R&B
		r_and_b.add_sstyle(new Sous_style("contemporary_r_and_b",1,r_and_b));
		r_and_b.add_sstyle(new Sous_style("soul",2,r_and_b));

		// LISTE GENRES : ID 11 - RAP 

		rap.set_distance(blues, 670);   
		rap.set_distance(enfant, 238); 
		rap.set_distance(classique, 1336);
		rap.set_distance(country, 552); 
		rap.set_distance(electronic, 256);
		rap.set_distance(folk, 872); 
		rap.set_distance(disco, 88); 
		rap.set_distance(jazz, 1121); 
		rap.set_distance(pop_rock, 677); 
		rap.set_distance(r_and_b, 120); 
		rap.set_distance(rap, 1);
		rap.set_distance(reggae, 113);
		// LISTE SOUS-STYLES - RAP
		rap.add_sstyle(new Sous_style("alternative_rap",1,rap));
		rap.add_sstyle(new Sous_style("reggaeton",2,rap));
		rap.add_sstyle(new Sous_style("hip_hop",3,rap));

		// LISTE GENRES : ID 11 - REGGAE 

		reggae.set_distance(blues, 364);   
		reggae.set_distance(enfant, 67); 
		reggae.set_distance(classique, 1299);
		reggae.set_distance(country, 693); 
		reggae.set_distance(electronic, 252);
		reggae.set_distance(folk, 720); 
		reggae.set_distance(disco, 54); 
		reggae.set_distance(jazz, 920); 
		reggae.set_distance(pop_rock, 873); 
		reggae.set_distance(r_and_b, 160); 
		reggae.set_distance(rap, 30);
		reggae.set_distance(reggae, 1);
		// LISTE SOUS-STYLES - REGGAE
		reggae.add_sstyle(new Sous_style("dancehall",1,reggae));
		reggae.add_sstyle(new Sous_style("ragga",2, reggae));
		reggae.add_sstyle(new Sous_style("reggae_pop",3, reggae));
		reggae.add_sstyle(new Sous_style("souns_system",4, reggae));
		reggae.add_sstyle(new Sous_style("ska",5, reggae));
	
		liste.set(0, blues);
		liste.set(1, enfant);
		liste.set(2, classique);
		liste.set(3, country);
		liste.set(4, electronic);
		liste.set(5,folk);
		liste.set(6, disco);
		liste.set(7, jazz);
		liste.set(8, pop_rock);
		liste.set(9,r_and_b);
		liste.set(10, rap);
		liste.set(11, reggae);
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
				/*Affiche les données récupérées dans la BDD
				System.out.println(rs.getString("idAr") + " " + rs.getString("nomAr") + " " + rs.getString("type"));
				*/
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
