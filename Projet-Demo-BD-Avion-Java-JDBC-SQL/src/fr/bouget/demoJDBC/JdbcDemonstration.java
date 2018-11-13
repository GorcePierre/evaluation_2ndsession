package fr.bouget.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*		
1. Charger le pilote
2. Ouvrir une connexion � la base de donn�es
3. Pr�parer la requ�te SQL
4. Ex�cuter la requ�te
5. R�cup�rer les r�sultats (que l'on peut afficher ou pas)
	5.1 Afficher les r�sultats si (SELECT)
	5.2 Retourner une information si (INSERT, UPDATE ou DELETE)
6. Fermer la connexion � la base de donn�es.

Les �tapes 1, 2 et 3 ne se font qu'une seule fois car elles sont communes pour ex�cuter les �tapes 3, 4 et 5

tests sur la table : apprenants_promo3

  CREATE TABLE `apprenants_promo3` (
  `id_apprenant` int(2) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `prenom` varchar(40) NOT NULL,
  `nom` varchar(40) NOT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `apprenants_promo3` (`id_apprenant`, `prenom`, `nom`) VALUES
(1, 'G�raldine', 'Autrique'),
(2, 'Nicolas', 'Filine'),
(3, 'Pierre', 'Gorce'),
(4, 'Samuel', 'Joblon'),
(5, 'Phoneprasong', 'Khamvongsa'),
(6, 'Vincent', 'Lebegue'),
(7, 'Matthieu', 'Londeix'),
(8, 'Thomas', 'Longueville'),
(9, 'Christine', 'M�tivier'),
(10, 'Laurent', 'Picard'),
(11, 'David', 'Pouline'),
(12, 'Julien', 'Prod\'homme'),
(13, 'Samuel', 'Sabot'),
(14, 'Salvatore', 'Sancesario'),
(15, 'David', 'Sylvestre'),
(16, 'C�dric', 'Tressous');


*/	

public class JdbcDemonstration {


	/**
	 * @param args
	 */
	public static void main(String[] args)
{
		String url = "jdbc:mysql://localhost:3306/pratique";
		String user = "root";
		String password = "";
	
		try {
			// 1. Charger le pilote (pilote JDBC pour MySQL dans le package concern�)
				Class.forName("com.mysql.jdbc.Driver");
				
			// 2. Ouvrir une connexion � la base de donn�es (dans la classe DriverManager, il y a une m�thode getConnection()
				
				Connection connection = DriverManager.getConnection(url, user, password);
			
			//	3. Pr�parer la requ�te SQL
				
				String sql = "SELECT * FROM apprenants_promo3 ORDER BY nom";
			
			//	4. Ex�cuter la requ�te
				
				Statement instruction = null;					// d�claration
				instruction = connection.createStatement();		// initialisation
				
			// 5. R�cup�rer les r�sultats
				
				ResultSet resultat = null;
				resultat = instruction.executeQuery(sql);		// ex�cution et r�cup�ration du r�sultat
				
			// 5.1 on souhaite afficher les r�sultas de notre requ�te (utilisation d'une Boucle)
				
				// 5.1.1 Vous ne connaissez pas le nom des colonnes, juste le nombre (ici 3 colonnes)
				System.out.println("\n\n5.1.1 Vous ne connaissez pas le nom des colonnes, juste le nombre (ici 3 colonnes) : \n");
				while (resultat.next()) // tant qu'il y a des enregistrements
				{
					System.out.print(resultat.getString(1)+" ");
					System.out.print(resultat.getString(2)+ " ");
					System.out.println(resultat.getString(3));
				}
				
				// 5.1.2 Vous connaissez le nom des colonnes de la table
				System.out.println("\n\n5.1.2 Vous connaissez le nom des colonnes de la table : \n");
				resultat.beforeFirst(); // on se repositionne (on d�place le curseur des enregistrements avant le premier enregistrement)
				
				while (resultat.next()) // tant qu'il y a des enregistrements
				{
					System.out.print(resultat.getString("id_apprenant")+" ");
					System.out.print(resultat.getString("prenom")+ " ");
					System.out.println(resultat.getString("nom"));
				}
				
				// 6. Fermer la connexion � la base de donn�es.
			
				connection.close();	
				
		} catch (ClassNotFoundException cnfe) 
		{
			
			System.out.println("Pilote introuvable !");
			cnfe.printStackTrace();
		}
		catch(SQLException sqle)
		{
			System.out.println("Probl�me de connection !");
			sqle.printStackTrace();
		}

}

}
