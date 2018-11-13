package fr.bouget.model;

import java.io.Serializable;
import java.sql.Time;


public class Vol implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Avion avion;
	private Time heureArrivee;
	private Time heureDepart;
	
	private Pilote pilote;
	private String siteArrivee;
	private String siteDepart;

	public Vol() {super();}
	
	

	public Vol(String id, Avion avion, Time heureArrivee, Time heureDepart, Pilote pilote, String siteArrivee,
			String siteDepart) {
		super();
		this.id = id;
		this.avion = avion;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.pilote = pilote;
		this.siteArrivee = siteArrivee;
		this.siteDepart = siteDepart;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the avion
	 */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * @param avion the avion to set
	 */
	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	/**
	 * @return the heureArrivee
	 */
	public Time getHeureArrivee() {
		return heureArrivee;
	}

	/**
	 * @param heureArrivee the heureArrivee to set
	 */
	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	/**
	 * @return the heureDepart
	 */
	public Time getHeureDepart() {
		return heureDepart;
	}

	/**
	 * @param heureDepart the heureDepart to set
	 */
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	/**
	 * @return the pilote
	 */
	public Pilote getPilote() {
		return pilote;
	}

	/**
	 * @param pilote the pilote to set
	 */
	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	/**
	 * @return the siteArrivee
	 */
	public String getSiteArrivee() {
		return siteArrivee;
	}

	/**
	 * @param siteArrivee the siteArrivee to set
	 */
	public void setSiteArrivee(String siteArrivee) {
		this.siteArrivee = siteArrivee;
	}

	/**
	 * @return the siteDepart
	 */
	public String getSiteDepart() {
		return siteDepart;
	}

	/**
	 * @param siteDepart the siteDepart to set
	 */
	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vol n° "+id+" Site départ : "+ siteDepart+" HD : "+ heureDepart+" Site arrivee : "+siteArrivee+" HA : "+ heureArrivee+"\n"+
				this.avion+"\n"+
				this.pilote+"\n";
	}

	
}