package pojistovna.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PojistenecEntity {

// Znazornují jednostlivé sloupce v tabulce

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String jmeno;
    @Column(nullable = false)
    public String prijmeni;
    @Column(nullable = false)
    public String ulice;
    @Column(nullable = false)
    public String mesto;
    @Column(nullable = false)
    public String psc;
    @Column(nullable = false)
    public String email;
    @Column(nullable = false)
    public String telefon;

   // Gettery a Settery

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;

    }
        // Napojení na tabulku pojistění
        @OneToMany(mappedBy = "pojistenec", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<PojisteniEntity> pojisteni = new ArrayList<>();
}
