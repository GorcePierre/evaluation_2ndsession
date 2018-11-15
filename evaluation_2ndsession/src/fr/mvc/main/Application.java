/**
 * Projet D�mo JDBC-SQL
 */
package fr.mvc.main;

import java.sql.SQLException;
import fr.mvc.metier.Requetes;
import fr.mvc.model.*;

/**
 * @author Pierre
 *
 */
public class Application {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		// Activites regarderWakfu = new Activites(50, "regarder Wakfu");
		// Requetes.ajouterActivite(regarderWakfu);
		// Activites regarderWakfu = new Activites(50, "regarder mine");
		// Requetes.modifierActivite(regarderWakfu);
		// Requetes.supprimerActivite(regarderWakfu);
		// Region Bretagne = new Region(4, "Bretagne");
		// Requetes.ajouterRegion(Bretagne);
		// Region Bretagne = new Region(2, "Alsace");
		// Requetes.modifierRegion(Bretagne);
		// Requetes.supprimerRegion(Bretagne);
		// Activites caresserLeChat  = new Activites(14, "Caresser le chat");
		// Requetes.ajouterActivite(caresserLeChat);
		// Activites ecouterMusique = new Activites(15, "Ecouter de la musique");
		// Requetes.ajouterActivite(ecouterMusique);
		// Requetes.supprimerActivite(caresserLeChat);
		// Requetes.supprimerActivite(ecouterMusique);
		// Apprenant supplementaire = new Apprenant(18, "MonNom");
		// Requetes.ajouterApprenant(supplementaire);
		// Requetes.modifierApprenant(supplementaire);
		// Requetes.supprimerapprenant(supplementaire);

		// System.out.println(Requetes.getAllRegion());
		// System.out.println(Requetes.getAllActivite());
		// System.out.println(Requetes.getAllApprenant());
		// System.out.println(Requetes.getAllApprenant());

		//Requetes.afficherApprenants();
		Requetes.afficherActiviteNeverdone();
		// Requetes.apprenantsParRegion();

	}

}
