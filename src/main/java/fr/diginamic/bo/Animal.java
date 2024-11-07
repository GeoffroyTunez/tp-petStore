package fr.diginamic.bo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Animal")
public class Animal {

    /** ID unique de l'animal
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Date de naissance de l'animal
     */
    @Column(name = "BIRTH")
    private LocalDate birth;

    /** Couleur de l'animal
     */
    @Column(name = "COULEUR")
    private String couleur;

    /** ID unique du PetStore associé à l'animal
     */
    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")  // Clé étrangère vers PetStore
    private PetStore petStore;


    public Animal() {
    }

    /** Constructeur d'animal
     *
     * @param birth
     * @param couleur
     */
    public Animal(LocalDate birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    /**
     * Getter for id
     *
     * @return id
     */

    public Long getId() {
        return id;
    }

    /**
     * Getter for petStore
     *
     * @return petStore
     */

    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Setter for petStore
     *
     * @return petStore
     */

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    /**
     * Getter for couleur
     *
     * @return couleur
     */

    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter for couleur
     *
     * @return couleur
     */

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Getter for birth
     *
     * @return birth
     */

    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Setter for birth
     *
     * @return birth
     */

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    /** Permet d'afficher les informations d'un animal
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
