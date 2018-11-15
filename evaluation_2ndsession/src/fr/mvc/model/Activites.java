package fr.mvc.model;

/**
 * Activites
 */
public class Activites {

    private int id;
    private String name;

    public Activites() {
    }

    public Activites(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return getName();
    }

}