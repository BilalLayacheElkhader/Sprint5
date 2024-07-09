package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_SucursalID;
    private String nameBranch;
    private String countryBranch;
    public Branch(){}
    public Branch(String nameBranch, String countryBranch) {
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
    }

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nameBranch='" + nameBranch + '\'' +
                ", countryBranch='" + countryBranch + '\'' +
                '}';
    }
}
