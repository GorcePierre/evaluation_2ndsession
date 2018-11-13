package fr.bouget.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.bouget.model.Avion;
import fr.bouget.model.Categorie;
import fr.bouget.model.Pilote;
import fr.bouget.model.Vol;

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
	 * M�thode pour instancier un objet Avion
	 * @param resultat
	 * @return
	 * @throws SQLException
	 */
	public static Avion mapperAvion(ResultSet resultat) throws SQLException
	{
		
		Avion avion = new Avion();
		avion.setId(resultat.getInt("AV_ID"));
		avion.setConstructeur(resultat.getString("AV_CONST"));
		avion.setModele(resultat.getString("AV_MODELE"));
		avion.setCapacite(resultat.getInt("AV_CAPACITE"));
		avion.setSite(resultat.getString("AV_SITE"));
		
		return avion;
	
	}
	
	/**
	 * M�thode pour instancier un objet Pilote
	 * @param resultat
	 * @return
	 * @throws SQLException
	 */
	public static Pilote mapperPilote(ResultSet resultat) throws SQLException
	{
		Pilote pilote = new Pilote();
		pilote.setId(resultat.getInt("PI_ID"));
		pilote.setNom(resultat.getString("PI_NOM"));
		pilote.setSite(resultat.getString("PI_SITE"));
		
		return pilote;
		
	}
	
	/**
	 * M�thode pour instancier un objet Vol
	 * @param resultat
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Vol mapperVol(ResultSet resultat) throws SQLException, ClassNotFoundException
	{
		Vol vol = new Vol();
		vol.setId(resultat.getString("VO_ID"));
		// on r�cup�re l'identifiant de l'avion que l'on charge avec son identifiant
		vol.setAvion(Requetes.getAvionById(resultat.getInt("VO_AVION")));
		vol.setSiteDepart(resultat.getString("VO_SITE_DEPART"));
		vol.setHeureDepart(resultat.getTime("VO_HEURE_DEPART"));
		
		vol.setSiteArrivee(resultat.getString("VO_SITE_ARRIVEE"));
		vol.setHeureArrivee(resultat.getTime("VO_HEURE_ARRIVEE"));
		// on r�cup�re l'identifiant dupilote que l'on charge avec son identifiant		
		vol.setPilote(Requetes.getPiloteById(resultat.getInt("VO_PILOTE")));	
		
		return vol;
	}
	
	//=================== Ajouter votre m�thode de mapping pour Categorie ==========================//

	public static Categorie mapperCategorie(ResultSet resultat) throws SQLException, ClassNotFoundException
	{
		Categorie categorie = new Categorie(resultat.getInt("id"),resultat.getString("name")) ;
		
		return categorie;
	}
}
