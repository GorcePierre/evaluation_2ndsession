package fr.mvc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mvc.model.Apprenant;

/**
 * @author Philippe
 * Mapping par Programmation
 */
public class Mapping {

	/**
	 * 
	 */
	public Mapping() {
		
	}
	
	
	/**
	 * M�thode pour instancier un objet Apprenant
	 * @param resultat
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Apprenant mapperApprenant(ResultSet resultat) throws SQLException, ClassNotFoundException
	{
		Apprenant apprenant = new Apprenant();
		//apprenant.setId(resultat.getString(""));
		// on r�cup�re l'identifiant de l'avion que l'on charge avec son identifiant
		//apprenant.setName(Requetes.getName(resultat.getInt("")));
		
		return apprenant;
	}
}
