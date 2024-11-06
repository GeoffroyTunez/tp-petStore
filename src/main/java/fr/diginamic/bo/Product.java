package fr.diginamic.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    /** ID unique d'un produit
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /** Code d'identification du produit */
    @Column(name = "CODE")
    private String code;

    /** Nom du produit */
    @Column(name = "LABEL")
    private String label;

    /** Type du produit qui se rapporte à la table enum ProdType */
    @Column(name = "TYPE")
    private ProdType type;

    /** Prix du produit */
    @Column(name = "PRICE")
    private double price;

    /** Liste des magasins qui propose ce produit */
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    {
        petStores = new HashSet<>();
    }

    /** Constructeur du produit
     *
     * @param code
     * @param label
     * @param type
     * @param price
     */
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    /**
     * Getter for id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter for code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for code
     *
     * @return code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter for label
     *
     * @return label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter for type
     *
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter for type
     *
     * @return type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter for price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     *
     * @return price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for petStores
     *
     * @return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter for petStores
     *
     * @return petStores
     */
    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    /** Permet d'afficher les informations d'un produit
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petStores=").append(petStores);
        sb.append('}');
        return sb.toString();
    }
}
