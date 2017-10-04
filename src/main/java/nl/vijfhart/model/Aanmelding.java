package nl.vijfhart.model;

import java.time.LocalDate;

public class Aanmelding {
    private String voornaam;
    private String achternaam;
    private String email;
    private LocalDate geboortedatum;
    private String geboorteplaats;

    public Aanmelding() {
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getGeboorteplaats() {
        return geboorteplaats;
    }

    public void setGeboorteplaats(String geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }

    @Override
    public String toString() {
        return "Aanmelding{" +
                "voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", email='" + email + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", geboorteplaats='" + geboorteplaats + '\'' +
                '}';
    }
}
