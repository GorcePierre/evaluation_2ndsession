package fr.mvc.model;


public class Avion {
	
	private int id;
	private String constructeur;
	private String modele;
	private int capacite;
	private String site;
	
	public Avion(int id, String constructeur, String modele, int capacite,
			String site)
	{
		super();
		this.id = id;
		this.constructeur = constructeur;
		this.modele = modele;
		this.capacite = capacite;
		this.site = site;
	}

	public Avion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String toString() {
		return "Avion : id=" + id + " constructeur=" + constructeur
				+ " modele=" + modele + " capacite=" + capacite + " site="
				+ site;
	}
	
	
	
	
	
	
	

}
