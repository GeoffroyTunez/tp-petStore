package fr.diginamic.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "TYPE")
    private ProdType type;

    @Column(name = "PRICE")
    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    {
        petStores = new HashSet<>();
    }

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
     * Getter for code
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
     * Getter for label
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
     * Getter for type
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
     * Getter for price
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
     * Getter for petStores
     *
     * @return petStores
     */

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

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
