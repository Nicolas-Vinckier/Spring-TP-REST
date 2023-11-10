package fr.diginamic.BestiolesRest.model;

import jakarta.persistence.*;

@Entity
public class Species {

    // ------------------------- Attributes -------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "latin_name")
    private String latinName;

    // ------------------------- Constructors -------------------------
    public Species() {
    }

    // ------------------------- Getters & Setters -------------------------

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Species{" + "id=" + id + ", common_name='" + commonName + '\'' + ", latin_name='" + latinName + '\''
                + '}';
    }
}
