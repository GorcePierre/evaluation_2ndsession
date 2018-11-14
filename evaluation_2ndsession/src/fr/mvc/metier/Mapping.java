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
	public static Apprenant mapperapprenant(ResultSet resultat) throws SQLException, ClassNotFoundException
	{
		Apprenant apprenant = new apprenant();
		apprenant.setId(resultat.getString("VO_ID"));
		// on r�cup�re l'identifiant de l'avion que l'on charge avec son identifiant
		apprenant.setAvion(Requetes.getAvionById(resultat.getInt("VO_AVION")));
		apprenant.setSiteDepart(resultat.getString("VO_SITE_DEPART"));
		apprenant.setHeureDepart(resultat.getTime("VO_HEURE_DEPART"));
		
		apprenant.setSiteArrivee(resultat.getString("VO_SITE_ARRIVEE"));
		apprenant.setHeureArrivee(resultat.getTime("VO_HEURE_ARRIVEE"));
		// on r�cup�re l'identifiant dupilote que l'on charge avec son identifiant		
		apprenant.setPilote(Requetes.getPiloteById(resultat.getInt("VO_PILOTE")));	
		
		return apprenant;
	}
}
