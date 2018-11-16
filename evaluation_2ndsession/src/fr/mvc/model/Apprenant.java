package fr.mvc.model;

import java.sql.Date;
/**
 * Apprenant
 */
public class Apprenant {

    private int id;
    private String name;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String photo;
    private int id_region;

    @Override
    public String toString() {
        return 
            getName() + " " +
            getPrenom();
    }
    

    public int getId_region() {
        return this.id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
    public Apprenant() {
    }

    public Apprenant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Apprenant(int id, String prenom, String name, Date dateDeNaissance, String email, String photo, int region) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.photo = photo;
        this.id_region = region;
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
}