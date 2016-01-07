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
		blues.add_sstyle(new Sous_style<Genre>("acoustic_blues",blues));
		blues.add_sstyle(new Sous_style<Genre>("electric_blues", blues));
		blues.add_sstyle(new Sous_style<Genre>("country_blues", blues));
		
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
		enfant.add_sstyle(new Sous_style<Genre>("capoeira" ,enfant));
		enfant.add_sstyle(new Sous_style<Genre>("education",enfant));
		enfant.add_sstyle(new Sous_style<Genre>("comique",enfant));

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
		classique.add_sstyle(new Sous_style<Genre>("ballet",classique));
		classique.add_sstyle(new Sous_style<Genre>("concerto",classique));
		classique.add_sstyle(new Sous_style<Genre>("symphony",classique));
		classique.add_sstyle(new Sous_style<Genre>("renaissance",classique));
		classique.add_sstyle(new Sous_style<Genre>("orchestral",classique));
		classique.add_sstyle(new Sous_style<Genre>("opera",classique));
		
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
		country.add_sstyle(new Sous_style<Genre>("country_pop",country));
		country.add_sstyle(new Sous_style<Genre>("progressive_country",country));
		country.add_sstyle(new Sous_style<Genre>("traditional_country",country));

		
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
		electronic.add_sstyle(new Sous_style<Genre>("house",electronic));
		electronic.add_sstyle(new Sous_style<Genre>("techno",electronic));
		electronic.add_sstyle(new Sous_style<Genre>("trance",electronic));


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
		folk.add_sstyle(new Sous_style<Genre>("contemporary_folk",folk));
		folk.add_sstyle(new Sous_style<Genre>("traditional_folk",folk));

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
		disco.add_sstyle(new Sous_style<Genre>("funk",disco));

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
		jazz.add_sstyle(new Sous_style<Genre>("classic_jazz",jazz));
		jazz.add_sstyle(new Sous_style<Genre>("swing",jazz));
		jazz.add_sstyle(new Sous_style<Genre>("groove",jazz));

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
		pop_rock.add_sstyle(new Sous_style<Genre>("indie_rock",pop_rock));
		pop_rock.add_sstyle(new Sous_style<Genre>("heavy_metal",pop_rock));
		pop_rock.add_sstyle(new Sous_style<Genre>("rock_and_roll",pop_rock));
		pop_rock.add_sstyle(new Sous_style<Genre>("country_rock",pop_rock));
		pop_rock.add_sstyle(new Sous_style<Genre>("hard_rock",pop_rock));
		pop_rock.add_sstyle(new Sous_style<Genre>("dance",pop_rock));

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
		r_and_b.add_sstyle(new Sous_style<Genre>("contemporary_r_and_b",r_and_b));
		r_and_b.add_sstyle(new Sous_style<Genre>("soul",r_and_b));

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
		rap.add_sstyle(new Sous_style<Genre>("alternative_rap",rap));
		rap.add_sstyle(new Sous_style<Genre>("reggaeton",rap));
		rap.add_sstyle(new Sous_style<Genre>("hip_hop",rap));

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
		reggae.add_sstyle(new Sous_style<Genre>("dancehall",reggae));
		reggae.add_sstyle(new Sous_style<Genre>("ragga",reggae));
		reggae.add_sstyle(new Sous_style<Genre>("reggae_pop",reggae));
		reggae.add_sstyle(new Sous_style<Genre>("souns_system",reggae));
		reggae.add_sstyle(new Sous_style<Genre>("ska",reggae));
	
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
