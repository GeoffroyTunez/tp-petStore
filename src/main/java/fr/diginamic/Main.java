package fr.diginamic;

import fr.diginamic.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // création des PetStore
        PetStore PetStore1 = new PetStore("Annimalerie de la gare","Jean");
        PetStore PetStore2 = new PetStore("Annimalerie des poisson","Marie");
        PetStore PetStore3 = new PetStore("Annimalerie","Hugo");

        // création / affectation de leur adresse
        PetStore1.ajouterAdresse(new Adresse("Carcassone","11000","rue de la gare","1"));
        PetStore2.ajouterAdresse(new Adresse("Parie","99000","rue du soleil","89"));
        PetStore3.ajouterAdresse(new Adresse("Nante","85300","avenue du bonheur","15"));

        // création des animaux
        Cat Chat1 = new Cat(LocalDate.now(),"Gris","0001");
        Fish poison1 = new Fish(LocalDate.now(),"Rouge", FishLivEnv.SEA_WATER);
        Fish poison2 = new Fish(LocalDate.now(),"bleu",FishLivEnv.FRESH_WATER);


        // affectation des animaux au PetStore
        PetStore1.ajouterAnimal(Chat1);
        PetStore1.ajouterAnimal(poison1);
        PetStore3.ajouterAnimal(poison2);

        // création des product
        Product mangerChat = new Product("654","PurinaMax",ProdType.FOOD,19.99D);
        Product mangerPoisson = new Product("784","Croquette écaille",ProdType.FOOD,5.99D);
        Product laissePoisson = new Product("111","laisse pour poisson rouge",ProdType.ACCESSORY,50.99D);


        // affectation des product au PetStore
        PetStore1.ajouterProduct(mangerChat);
        PetStore1.ajouterProduct(mangerPoisson);
        PetStore1.ajouterProduct(laissePoisson);

        PetStore2.ajouterProduct(mangerChat);
        PetStore2.ajouterProduct(mangerPoisson);
        PetStore2.ajouterProduct(laissePoisson);

        PetStore3.ajouterProduct(mangerChat);
        PetStore3.ajouterProduct(mangerPoisson);
        PetStore3.ajouterProduct(laissePoisson);


        // enregistrement des modification dans la BDD
        em.persist(PetStore1);
        em.persist(PetStore2);
        em.persist(PetStore3);

        System.out.println("Liste des animaux de l'animalerie 'PetStore1' : ");
        System.out.println(PetStore1.getAnimals().toString()); // affichage des animaux de l'animalerie "PetStore 1"




        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}