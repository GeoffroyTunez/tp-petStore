package fr.diginamic.bo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Table(name = "Fish")
public class Fish extends Animal{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FishLivEnv livingEnv;

    public Fish(LocalDate birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    /**
     * Getter for livingEnv
     *
     * @return livingEnv
     */

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Getter for livingEnv
     *
     * @return livingEnv
     */

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
