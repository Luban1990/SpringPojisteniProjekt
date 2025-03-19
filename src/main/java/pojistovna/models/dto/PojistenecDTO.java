package pojistovna.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// DTO SLOUŽÍ JAKO PŘEPRAVKA , OCHRANA DAT

public class PojistenecDTO {

    private Long id;

    @NotBlank(message = "Jméno nesmí být prázdné.") // Validační zrpáva, nesmí být prázdný
    private String jmeno;

    @NotBlank(message = "Příjmení nesmí být prázdné.") // Validační zrpáva, nesmí být prázdný
    private String prijmeni;

    @NotBlank(message = "Ulice nesmí být prázná.") // Validační zrpáva, nesmí být prázdný
    private String ulice;

    @NotBlank(message = "Město nesmí být prázdné.") // Validační zrpáva, nesmí být prázdný
    private String mesto;

    @NotBlank(message = "PSC nesmí být prázdné") // Validační zrpáva, nesmí být prázdný
    private String psc;

    @NotBlank(message = "Email nesmí být prázdný.") // Validační zrpáva, nesmí být prázdný
    @Email(message = "Neplatná e-mailová adresa.")
    private String email;

    @NotBlank(message = "Telefon nesmí být prázdný.") // Validační zrpáva, nesmí být prázdný
    @Size(min = 9, max = 15, message = "Telefonní číslo musí mít 9–15 znaků.")
    private String telefon;

    // Gettery Settery
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
