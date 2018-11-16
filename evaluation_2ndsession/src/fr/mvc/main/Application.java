/**
 * Projet D�mo JDBC-SQL
 */
package fr.mvc.main;

import java.sql.Date;
import java.sql.SQLException;
import fr.mvc.model.Activites;
import fr.mvc.metier.*;
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
	public static void main(String[]args) throws ClassNotFoundException, SQLException, InterruptedException {
	
		System.out.println("Bonjour Josselin voila notre restitution de l'évaluation 2");
		System.out.println();
		System.out.println("1er partie: afficher tous les apprenants");
		System.out.println();
		Thread.sleep(3000);
		Requetes.afficherApprenants(); 

		System.out.println();
		System.out.println("2nd partie: afficher tous les apprenants par region");
		System.out.println();
		Thread.sleep(3000);
		Requetes.afficherApprenantsParRegion();

		System.out.println();
		System.out.println("3eme partie: afficher tous les activités d'un apprenant");
		System.out.println();
		Thread.sleep(3000);
		//Requetes.afficherActivitesApprenants();

		System.out.println();
		System.out.println("4eme partie: afficher tous les apprenants pratiquant une activité");
		System.out.println();
		Thread.sleep(3000);

		System.out.println();
		System.out.println("5eme partie: créer un nouvel apprenant");
		System.out.println("on va ajouter toto simplon né le 01-10-2018 ayant une adresse email");
		System.out.println();
		Thread.sleep(3000);
		Requetes.afficherApprenants();
		Apprenant toto = new Apprenant("toto", "simplon", Date.valueOf("2018-10-01"), "toto.simplon@gmail.com", "photo.png", 1);
		Requetes.ajouterApprenant(toto);
		System.out.println();
		Requetes.afficherApprenants();

		System.out.println();
		System.out.println("6eme partie: ajouter deux activités carresser chat ecouter de la musique à toto");
		System.out.println();
		Requetes.getAllActivite(); 
		Requetes.ajouteDeuxActivites(toto);
		Thread.sleep(3000);
		Requetes.getAllActivite();
		System.out.println();
		Thread.sleep(3000);
		//Activites regarderWakfu = new Activites( "regarder Wakfu");
		//Requetes.ajouterActivite(regarderWakfu);
		// Activites regarderWakfu = new Activites(50, "regarder mine");
		// Requetes.modifierActivite(regarderWakfu);
		//Requetes.supprimerActivite(regarderWakfu);
		// Region Bretagne = new Region(4, "Bretagne");
		// Requetes.ajouterRegion(Bretagne);
		// Region Bretagne = new Region(2, "Alsace");
		// Requetes.modifierRegion(Bretagne);
		// Requetes.supprimerRegion(Bretagne);
		// Activites caresserLeChat  = new Activites(14, "Caresser le chat");
		//Requetes.ajouterActivite(caresserLeChat);
		// Activites ecouterMusique = new Activites(15, "Ecouter de la musique");
		//Requetes.ajouterActivite(ecouterMusique);
		// Requetes.supprimerActivite(caresserLeChat);
		// Requetes.supprimerActivite(ecouterMusique);
		// Apprenant supplementaire = new Apprenant(119, "MonNom","toto",Date.valueOf("1972-04-23"), "laurent@laposte.fr","photo", 1);
		// Requetes.ajouterApprenant(supplementaire);
		//Activites caresserLeChat  = new Activites(14, "Caresser le chat");
		//Requetes.ajouterActivite(caresserLeChat);
		//Activites ecouterMusique = new Activites(15, "Ecouter de la musique");
		//Requetes.ajouterActivite(ecouterMusique);
		// Requetes.supprimerActivite(caresserLeChat);
		// Requetes.supprimerActivite(ecouterMusique);
		//Apprenant supplementaire = new Apprenant(119, "MonNom","toto",Date.valueOf("1972-04-23"), "laurent@laposte.fr","photo", 1);
		//Requetes.ajouterApprenant(supplementaire);
		// Requetes.modifierApprenant(supplementaire);
		// Requetes.supprimerapprenant(supplementaire);

		System.out.println();
		System.out.println("7eme partie: afficher les activités que personne ne pratique");
		System.out.println();
		Thread.sleep(3000);
		Requetes.afficherActiviteNeverDone();

		System.out.println();
		System.out.println("8eme partie: changer le nom de toto");
		System.out.println();
		Thread.sleep(3000);
		toto = new Apprenant(500, "titus");
		Requetes.modifierApprenant(toto);
		Requetes.afficherApprenants();

		System.out.println();
		System.out.println("9eme partie: effacer l'apprenant toto");
		System.out.println();
		Thread.sleep(3000);
		Requetes.supprimerapprenant(toto);
		

		//Requetes.afficherApprenants();
		//Requetes.afficherActiviteNeverDone();
		//Requetes.ajouteDeuxActivites(caresserLeChat, ecouterMusique, supplementaire);
		//Requetes.afficherActiviteNeverDone();
		// Requetes.apprenantsParRegion();

		// Requetes.afficherApprenants();
		// Requetes.afficherActiviteNeverDone();
		// Requetes.ajouteDeuxActivites(caresserLeChat, ecouterMusique, supplementaire);
		// Requetes.afficherActiviteNeverDone();
		Requetes.afficherApprenants();
		Requetes.afficherApprenantsParRegion();
		Requetes.afficherActivitesParApprenant("JOBLON");
		Requetes.afficherApprenantsParActivite("Programmer en java");
	}
}
