package fr.mvc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mvc.model.*;

/**
 * @author Pierre
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
	public static Apprenant mapperApprenant(ResultSet resultat) throws SQLException, ClassNotFoundException {
		Apprenant apprenant = new Apprenant();
		apprenant.setId(resultat.getInt("id_apprenant"));
		apprenant.setName(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		apprenant.setEmail(resultat.getString("email"));
		apprenant.setPhoto(resultat.getString("photo"));
		apprenant.setDateDeNaissance(resultat.getDate("dateNaissance"));
		apprenant.setId_region(resultat.getInt("id_region")); 

		return apprenant;
	}

	public static Activites mapperActivite(ResultSet resultat) throws SQLException, ClassNotFoundException {
		Activites activite = new Activites();
		activite.setId(resultat.getInt("id_activite"));
		activite.setName(resultat.getString("nom"));

		return activite;
	}

	public static Region mapperRegion(ResultSet resultat) throws SQLException, ClassNotFoundException {
		Region region = new Region();
		region.setId(resultat.getInt("id_region"));
		region.setName(resultat.getString("nom"));

		return region;
	}
}
