package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Flor")
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    private String nameFlor;
    private String countryFlor;
    public Flor(){}
    public Flor(String nameFlor, String countryFlor) {
        this.nameFlor = nameFlor;
        this.countryFlor = countryFlor;
    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public String getNameFlor() {
        return nameFlor;
    }

    public String getCountryFlor() {
        return countryFlor;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public void setNameFlor(String nameFlor) {
        this.nameFlor = nameFlor;
    }

    public void setCountryFlor(String countryFlor) {
        this.countryFlor = countryFlor;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "pk_FlorID=" + pk_FlorID +
                ", nameFlor='" + nameFlor + '\'' +
                ", countryFlor='" + countryFlor + '\'' +
                '}';
    }
}
