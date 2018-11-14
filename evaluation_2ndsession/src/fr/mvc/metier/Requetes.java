package fr.mvc.metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.mvc.connection.AccesBD;
import fr.mvc.model.Avion;
import fr.mvc.model.Categorie;
import fr.mvc.model.Pilote;
import fr.mvc.model.Vol;

public class Requetes {
	
	/**
	 * M�thode ajouter un nouveau pilote
	 * @param pilote
	 * @throws SQLException
	 */
	public static void ajouterPilote(Pilote pilote) throws SQLException
	{
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO `pilote` VALUES( ? , ? , ? )");
		prepareStatement.setInt(1,pilote.getId());
		prepareStatement.setString(2,pilote.getNom());
		prepareStatement.setString(3,pilote.getSite());
		prepareStatement.executeUpdate();
		
	}
	
	/**
	 * m�thode pour modifier un pilote
	 * @param pilote
	 * @throws SQLException
	 */
	public static void modifierPilote(Pilote pilote) throws SQLException
	{
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE pilote SET PI_NOM = ? , PI_SITE = ? WHERE PI_ID = ? ");
			prepareStatement.setString(1,pilote.getNom());
			prepareStatement.setString(2,pilote.getSite());
			prepareStatement.setInt(3,pilote.getId());
			prepareStatement.executeUpdate();
			System.out.println("Modification effectu�e pour le pilote : "+pilote);

		}
		catch(SQLException e){
			System.out.println("Erreur lors de la modification !");
		}
	}
	
	public static void supprimerPilote(Pilote pilote) throws SQLException
	{
		Statement statement = null;

		try {
			statement = AccesBD.getConnection().createStatement();
			String sql = "DELETE FROM pilote WHERE PI_ID="+pilote.getId();
			statement.executeUpdate(sql);
			System.out.println("Suppression du pilote "+ pilote+ " effectu�e");
		}
		catch(SQLException e){
			System.out.println("Erreur lors de la suppression du pilote !");
		}
	}
	
	/**
	 * M�thode pour retourner tous les pilotes dans un tableau
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Pilote> getAllPilotes() throws ClassNotFoundException, SQLException

	{
		ArrayList<Pilote>  pilotes = new ArrayList<Pilote>();
		String requete	= "SELECT * FROM pilote ORDER BY PI_ID";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next())
		{
			Pilote p = Mapping.mapperPilote(resultat);
			pilotes.add(p);
		}
		return pilotes;
	}
	
	// faites la m�me chose avec AVION
	public static void ajouterAvion(Avion avion){
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("INSERT INTO avion(AV_ID, AV_CONST, AV_MODELE, AV_CAPACITE, AV_SITE) VALUES(?,?,?,?,?)");
			prepStmt.setInt(1, avion.getId());
			prepStmt.setString(2, avion.getConstructeur());
			prepStmt.setString(3, avion.getModele());
			prepStmt.setInt(4, avion.getCapacite());
			prepStmt.setString(5, avion.getSite());
			prepStmt.executeUpdate();
			System.out.println("l'ajout de l'avion a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de l'ajout ");
		}
	
		
	}
	// faites la m�me chose avec Vol (attention, un peu compliqu� !!!)
	public static void ajouterVol(Vol vol){
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("INSERT INTO vol(VO_ID, VO_AVION, VO_PILOTE, VO_SITE_DEPART, VO_SITE_ARRIVEE, VO_HEURE_DEPART, VO_HEURE_ARRIVEE) VALUES(?,?,?,?,?,?,?)");
			prepStmt.setString(1, vol.getId());
			prepStmt.setInt(2, vol.getAvion().getId());
			prepStmt.setInt(3, vol.getPilote().getId());
			prepStmt.setString(4, vol.getSiteDepart());
			prepStmt.setString(5, vol.getSiteArrivee());
			prepStmt.setTime(6, vol.getHeureDepart());
			prepStmt.setTime(7, vol.getHeureArrivee());
			prepStmt.executeUpdate();
			System.out.println("l'ajout du vol a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de l'ajout " +e.getMessage());
		}
		
	}
	
	// faites la m�me chose que pour modifierPilote()
	public static void modifierAvion(Avion avion){
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("UPDATE avion SET AV_ID=?, AV_CONST=?, AV_MODELE=?, AV_CAPACITE=?, AV_SITE=?");
			prepStmt.setInt(1, avion.getId());
			prepStmt.setString(2, avion.getConstructeur());
			prepStmt.setString(3, avion.getModele());
			prepStmt.setInt(4, avion.getCapacite());
			prepStmt.setString(5, avion.getSite());
			prepStmt.executeUpdate();
			System.out.println("la modificationt de l'avion a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de l'ajout");
		}
			
	}

	public static ArrayList<Vol> getAllVols() throws ClassNotFoundException, SQLException
	{
		ArrayList<Vol> vols = new ArrayList<Vol>();
		String requete = "SELECT * FROM vol";
		ResultSet resultat = AccesBD.executerQuery(requete);
	
		while(resultat.next())
		{
			Vol vol = Mapping.mapperVol(resultat);
			vols.add(vol);
		}
		
		return vols;
	}
	
	/**
	 * M�thode qui retourne une liste d'objets de type Avion
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Avion> getAllAvions() throws ClassNotFoundException, SQLException

	{
		ArrayList<Avion>  avions = new ArrayList<Avion>();
		String requete	= "SELECT * FROM avion ORDER BY AV_ID";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next())
		{
			Avion avion = new Avion();
			avion.setId(resultat.getInt("AV_ID"));
			avion.setConstructeur(resultat.getString("AV_CONST"));
			avion.setModele(resultat.getString("AV_MODELE"));
			avion.setCapacite(resultat.getInt("AV_CAPACITE"));
			avion.setSite(resultat.getString("AV_SITE"));
			avions.add(avion);
			
		}
		return avions;
	}
	
	/**
	 * M�thode qui retourne un objet de type Avion en fonction de son identifiant
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Avion getAvionById(int id) throws ClassNotFoundException, SQLException

	{
		
		Avion avion = new Avion();
		
		PreparedStatement aPreparedStatement = AccesBD.getConnection().prepareStatement("SELECT * FROM avion WHERE AV_ID = ?");
		aPreparedStatement.setInt(1,id);
		ResultSet resultat = aPreparedStatement.executeQuery();
		resultat.next();
		avion.setId(resultat.getInt("AV_ID"));
		avion.setConstructeur(resultat.getString("AV_CONST"));
		avion.setModele(resultat.getString("AV_MODELE"));
		avion.setCapacite(resultat.getInt("AV_CAPACITE"));
		avion.setSite(resultat.getString("AV_SITE"));
		return avion;
			
		}
	
	/**
	 * M�thode idem que ci-dessus avec Mapping d�l�gu� � une m�thode qui retourne un objet de type Avion en fonction de son identifiant
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Avion getAvionByIdAvecMapping(int id) throws ClassNotFoundException, SQLException

	{
		PreparedStatement aPreparedStatement = AccesBD.getConnection().prepareStatement("SELECT * FROM avion WHERE AV_ID = ?");
		aPreparedStatement.setInt(1,id);
		ResultSet resultat = aPreparedStatement.executeQuery();
		resultat.next();
		
		return Mapping.mapperAvion(resultat);
	}
	
	
	
	/**
	 * M�thode qui retourne un objet de type Pilote en fonction de son identifiant
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Pilote getPiloteById(int id) throws ClassNotFoundException, SQLException

	{
		Pilote pilote = new Pilote();
		String requete	= "SELECT * FROM pilote WHERE PI_ID="+id;
		ResultSet resultat = AccesBD.executerQuery(requete);
		resultat.next();
		pilote.setId(resultat.getInt("PI_ID"));
		pilote.setNom(resultat.getString("PI_NOM"));
		pilote.setSite(resultat.getString("PI_SITE"));
		return pilote;
			
		}
	
	public static int getNombreDePilote() throws SQLException
	{
		 ResultSet resultat = AccesBD.getConnection().createStatement().executeQuery("SELECT count(*) FROM pilote");
		 resultat.next();
		 return resultat.getInt(1);
	}
	
	
	/**
	 * D�monstration d'une m�thode qui r�cup�re des r�sultats sans les stocker dans des objets.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void requetesBasiquesSansObjet() throws ClassNotFoundException, SQLException

	{
		String maRequete	= "SELECT * FROM avion ORDER BY AV_ID";
		ResultSet resultat = AccesBD.executerQuery(maRequete);
		System.out.println("Requete n�1 : Liste des avions dans la table Avion :\n");
		while(resultat.next())
		{
			System.out.println("Avion : "+resultat.getInt("AV_ID")+" "+
										  resultat.getString("AV_CONST")+" "+
										  resultat.getString("AV_MODELE")+" "+
										  resultat.getInt("AV_CAPACITE")+" "+
										  resultat.getString("AV_SITE"));
		}


		System.out.println("\n\nRequ�tes n�2 : (requ�te pr�par�es) Liste des avions ayant une capacit� sup�rieure � 300 passagers\n");
		PreparedStatement aPreparedStatement = AccesBD.getConnection().prepareStatement("SELECT * FROM avion where AV_CAPACITE > ?");

		aPreparedStatement.setInt(1,300);
		resultat = aPreparedStatement.executeQuery();
		while(resultat.next())
			{
				System.out.println("Avion : "+resultat.getInt("AV_ID")+" "+
											  resultat.getString("AV_CONST")+" "+
											  resultat.getString("AV_MODELE")+" "+
											  resultat.getInt("AV_CAPACITE")+" "+
											  resultat.getString("AV_SITE"));
			}

	}
	
	
	//================================= Votre partie : Categorie =======================================
	
	public static void ajouterCategorie(Categorie categorie) {
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("INSERT INTO categorie (name) VALUES(?)");
			prepStmt.setString(1, categorie.getName());
			prepStmt.executeUpdate();
			System.out.println("l'ajout de la categorie " +categorie.getName()+" a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de l'ajout");
		}
	}

	public static void ModifierCategorie(Categorie categorie) {
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("UPDATE categorie SET name=? WHERE id=?");
			prepStmt.setString(1, categorie.getName());
			prepStmt.setInt(2, categorie.getId());
			prepStmt.executeUpdate();
			System.out.println("la modification de la categorie " +categorie.getName()+" a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de la modification");
		}
	}


	public static void SupprimerCategorie(Categorie categorie) {
		PreparedStatement prepStmt;
		try {
			prepStmt = AccesBD.getConnection().prepareStatement("DELETE FROM categorie WHERE id=?");
			prepStmt.setInt(1, categorie.getId());
			prepStmt.executeUpdate();
			System.out.println("la suppression de la categorie " +categorie.getName()+" a bien été effectuée.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("echec de la suppression");
		}
	}
	
	public static List<Categorie> getAllCategories() throws ClassNotFoundException, SQLException

	{
		List<Categorie> categories = new ArrayList<Categorie>();
		String requete	= "SELECT * FROM categorie";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next())
		{
			Categorie c = Mapping.mapperCategorie(resultat);
			categories.add(c);
		}
		return categories;
	}
	
	public static Categorie getCategorieById(int i) throws ClassNotFoundException, SQLException {
		int id = 0;
		String name = "";
		
		String requete	= "SELECT * FROM categorie WHERE id="+i;
		ResultSet resultat = AccesBD.executerQuery(requete);
		if(resultat.next()) {
			id = resultat.getInt("id");
			name = resultat.getString("name");
		}
		return new Categorie(id, name);
	}
}
