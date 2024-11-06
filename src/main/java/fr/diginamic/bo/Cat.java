package fr.diginamic.bo;


import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "Cat")
public class Cat extends Animal{

    /** ID de la puce du chat
     */
    private String chipId;

    /** Constructeur pour un chat
     *
     * @param birth
     * @param couleur
     * @param chipId
     */
    public Cat(LocalDate birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    /**
     * Getter for chipId
     *
     * @return chipId
     */

    public String getChipId() {
        return chipId;
    }

    /**
     * Setter for chipId
     *
     * @return chipId
     */

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    /** Permet d'afficher les informations d'un chat
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipId='").append(chipId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
