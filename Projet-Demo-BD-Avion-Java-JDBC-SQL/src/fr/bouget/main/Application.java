/**
 * Projet D�mo JDBC-SQL
 */
package fr.bouget.main;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fr.bouget.connection.AccesBD;
import fr.bouget.metier.Requetes;
import fr.bouget.model.Avion;
import fr.bouget.model.Pilote;
import fr.bouget.model.Vol;

/**
 * @author Philippe
 *
 */
public class Application {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Avion avion = new Avion(115, "boeing", "modele", 1234, "bergerac");
		
		Pilote pilote = new Pilote(8, "nom", "site");
		Vol vol = new Vol("T124", avion, new Time(7,0,0), new Time(5,0,0), pilote, "paris", "bergerac");
		Requetes.ajouterVol(vol);
	}

}
