package fr.diginamic.bo;

import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PetStore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @OneToOne(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Adresse adresse;

    @ManyToMany
    @JoinTable(
            name = "PetStore_Product",
            joinColumns = @JoinColumn(name = "PETSTORE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private Set<Product> products;


    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL) // Associe les animaux à ce PetStore
    private Set<Animal> animals;



    {
        products = new HashSet<>();
        animals = new HashSet<>();
    }

    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    /**
     * Getter for tid
     *
     * @return id
     */

    public Long getId() {
        return id;
    }

    /**
     * Getter for animals
     *
     * @return animals
     */

    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Getter for animals
     *
     * @return animals
     */

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Getter for products
     *
     * @return products
     */

    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Getter for products
     *
     * @return products
     */

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Getter for adresse
     *
     * @return adresse
     */

    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Getter for adresse
     *
     * @return adresse
     */

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter for managerName
     *
     * @return managerName
     */

    public String getManagerName() {
        return managerName;
    }

    /**
     * Getter for managerName
     *
     * @return managerName
     */

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter for name
     *
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Getter for name
     *
     * @return name
     */

    public void setName(String name) {
        this.name = name;
    }

    public void ajouterAdresse(Adresse adresse){
        if(adresse != null){
            this.adresse = adresse;
            adresse.setPetStore(this);
        }
    }

    /** Ajouter un animal a un petstore
     *
     * @param animal
     */
    public void ajouterAnimal(Animal animal){
        if(animal != null){
            this.getAnimals().add(animal);
            animal.setPetStore(this);
        }
    }

    /** Supprimer un animal d'un petstore
     *
     * @param animal
     */
    public void supprimerAnimal(Animal animal){
        if(animal != null){
            this.getAnimals().remove(animal);
        }
    }

    /** Ajouter un produit a un petstore
     *
     * @param product
     */
    public void ajouterProduct(Product product){
        if(product != null ){
            this.getProducts().add(product);
        }
    }

    /** Supprimer un produit d'un petstore
     *
     * @param product
     */
    public void supprimerProduct(Product product){
        if(product != null ){
            this.getProducts().remove(product);
        }
    }

    public void déplacerAnimal(Animal animal, PetStore petStore){
        if (animal != null && petStore != null){
            this.getAnimals().remove(animal);
            petStore.getAnimals().add(animal);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append(", products=").append(products);
        sb.append(", animals=").append(animals);
        sb.append('}');
        return sb.toString();
    }
}