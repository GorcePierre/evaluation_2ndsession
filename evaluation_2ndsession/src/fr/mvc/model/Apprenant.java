package fr.mvc.model;

import java.sql.Date;



/**
 * Apprenant
 */
public class Apprenant {

    private int id;
    private String name;
    private String prenom;
    private java.sql.Date dateDeNaissance;
    private String email;
    private String photo;
    private int region;
   
    public Apprenant() {
    }

    public Apprenant(int id, String name, String prenom, Date dateDeNaissance, String email, String photo, int region) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.photo = photo;
        this.region = region;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return this.dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRegion() {
        return this.region;
    }

    public void setRegion(int region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", dateDeNaissance='" + getDateDeNaissance() + "'" +
            ", email='" + getEmail() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", region='" + getRegion() + "'" +
            "}";
    }

}