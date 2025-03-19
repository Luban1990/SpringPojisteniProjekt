package pojistovna.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
// DTO PŘEPRAVKA SLOUŽÍ K OCHRANĚ DAT
public class PojisteniDTO {


    private Long id;

    @NotBlank(message = "Typ pojištění musí být definován.") // Validační zrpáva, nesmí být prázdný
    private String typ;  // "Auto", "Cestovní", "Životní"...

    @NotNull(message = "Částka nesmí být prázdná.") // Validační zrpáva, nesmí být prázdný
    private BigDecimal castka;  // Např. 50000 K
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Formát data rok, měsíc, den
    @NotNull(message = "Datum od nesmí být prázdné.") // Validační zrpáva, nesmí být prázdný
    private LocalDate datumOd;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Formát data rok, měsíc, den
    @NotNull(message = "Datum do nesmí být prázdné.") // Validační zrpáva, nesmí být prázdný
    private LocalDate datumDo;

    @NotNull(message = "Pojištěnec nesmí být prázdný.") // Validační zrpáva, nesmí být prázdný
    private Long pojistenecId;  // Uchovává ID pojištěnce

    private String PojistenecJmeno;

    private String PojistenecPrijmeni;

    // Gettery a Settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public BigDecimal getCastka() {
        return castka;
    }

    public void setCastka(BigDecimal castka) {
        this.castka = castka;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public Long getPojistenecId() {
        return pojistenecId;
    }

    public void setPojistenecId(Long pojistenecId) {
        this.pojistenecId = pojistenecId;
    }

    public String getPojistenecJmeno() {
        return PojistenecJmeno;
    }

    public void setPojistenecJmeno(String pojistenecJmeno) {
        PojistenecJmeno = pojistenecJmeno;
    }

    public String getPojistenecPrijmeni() {
        return PojistenecPrijmeni;
    }

    public void setPojistenecPrijmeni(String pojistenecPrijmeni) {
        PojistenecPrijmeni = pojistenecPrijmeni;
    }
}
