package fr.diginamic.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "Adresse")
public class Adresse {

    /** ID unique de l'adresse
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Numero de de l'adresse
     */
    @Column(name = "NUMBER")
    private String number;

    /** Rue de l'adresse
     */
    @Column(name = "STREET")
    private String street;

    /** Code postal de l'adresse
     */
    @Column(name = "ZIP_CODE")
    private String zipCode;

    /** Nom de la ville
     */
    @Column(name = "CITY")
    private String city;

    /** ID unique du PetStore associé
     */
    @OneToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore petStore;

    public Adresse() {
    }

    /** Constructeur pour l'adresse
     *
     * @param city
     * @param zipCode
     * @param street
     * @param number
     */
    public Adresse(String city, String zipCode, String street, String number) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
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
     * Getter for number
     *
     * @return number
     */

    public String getNumber() {
        return number;
    }

    /**
     * Getter for number
     *
     * @return number
     */

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter for street
     *
     * @return street
     */

    public String getStreet() {
        return street;
    }

    /**
     * Getter for street
     *
     * @return street
     */

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for zipCode
     *
     * @return zipCode
     */

    public String getZipCode() {
        return zipCode;
    }

    /**
     * Getter for zipCode
     *
     * @return zipCode
     */

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter for city
     *
     * @return city
     */

    public String getCity() {
        return city;
    }

    /**
     * Getter for city
     *
     * @return city
     */

    public void setCity(String city) {
        this.city = city;
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
     * Getter for petStore
     *
     * @return petStore
     */

    /** Permet de définir l'id d'un petStore
     *
     * @param petStore
     */
    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    /** Permet d'afficher les informations d'une adresse
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
