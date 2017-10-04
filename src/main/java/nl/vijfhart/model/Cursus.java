package nl.vijfhart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cursus {

    private int id;
    private String naam;
    private String omschrijving;
    private int duur;
    private int prijs;

    public Cursus() {
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "Cursus{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                ", duur=" + duur +
                ", prijs=" + prijs +
                '}';
    }
}
