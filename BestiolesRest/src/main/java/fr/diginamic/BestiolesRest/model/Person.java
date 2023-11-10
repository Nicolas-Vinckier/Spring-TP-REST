package fr.diginamic.BestiolesRest.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Person {
    // ------------------------- Attributes -------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int age;

    private String firstname;

    private String lastname;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "person_animals", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "animals_id")) // Nom
    @Column(name = "id_person")
    private List<Animal> animals;

    // ------------------------- Constructors -------------------------
    public Person() {
    }

    // ------------------------- Getters & Setters -------------------------
    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(Integer id, String firstname, String lastname, int age) {
        this(firstname, lastname, age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
    }
}
