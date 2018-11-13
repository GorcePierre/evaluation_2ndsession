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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(Requetes.getCategorieById(3));
	}

}
