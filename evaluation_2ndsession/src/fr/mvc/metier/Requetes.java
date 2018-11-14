package fr.mvc.metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.mvc.connection.AccesBD;;

public class Requetes {

	/**
	 * M�thode ajouter un nouveau apprenant
	 * 
	 * @param apprenant
	 * @throws SQLException
	 */
	public static void ajouterApprenant(Apprenant apprenant) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection()
				.prepareStatement("INSERT INTO `apprenant` VALUES( ? , ? , ? )");
		prepareStatement.setInt(1, apprenant.getId());
		prepareStatement.setString(2, apprenant.getNom());
		prepareStatement.setString(3, apprenant.getSite());
		prepareStatement.executeUpdate();

	}

	/**
	 * m�thode pour modifier un apprenant
	 * 
	 * @param apprenant
	 * @throws SQLException
	 */
	public static void modifierApprenant(Apprenant apprenant) throws SQLException {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection()
					.prepareStatement("UPDATE apprenant SET PI_NOM = ? WHERE PI_ID = ? ");
			prepareStatement.setString(1, apprenant.getNom());
			prepareStatement.setInt(2, apprenant.getId());
			prepareStatement.executeUpdate();
			System.out.println("Modification effectu�e pour l' apprenant : " + apprenant);

		} catch (SQLException e) {
			System.out.println("Erreur lors de la modification !");
		}
	}

	public static void supprimerapprenant(Apprenant apprenant) throws SQLException {
		Statement statement = null;

		try {
			statement = AccesBD.getConnection().createStatement();
			String sql = "DELETE FROM apprenant WHERE PI_ID=" + apprenant.getId();
			statement.executeUpdate(sql);
			System.out.println("Suppression de " + apprenant + " effectu�e");
		} catch (SQLException e) {
			System.out.println("Erreur lors de la suppression du apprenant !");
		}
	}

	/**
	 * M�thode pour retourner tous les apprenants dans un tableau
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Apprenant> getAllApprenant() throws ClassNotFoundException, SQLException

	{
		ArrayList<Apprenant> apprenants = new ArrayList<apprenant>();
		String requete = "SELECT * FROM apprenant ORDER BY PI_ID";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while (resultat.next()) {
			apprenant p = Mapping.mapperApprenant(resultat);
			apprenants.add(p);
		}
		return apprenants;
	}

}
