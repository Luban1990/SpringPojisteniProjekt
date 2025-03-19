package pojistovna.data.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

    @Entity
    public class PojisteniEntity {

    // znázorňují sloupce v tabulce PojistěniEntity

    @Id  //  Označuje primární klíč (jedinečné ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //  ID bude automaticky generované databází

    @Column(nullable = false)
    private String typ;  //  Např. "Cestovní", "Životní", "Auto"

    @Column(nullable = false)
    private BigDecimal castka;  //  Výše pojištění (např. 50000 Kč)

    @Column(nullable = false)
    private LocalDate datumOd;  //  Počátek platnosti

    @Column(nullable = false)
    private LocalDate datumDo;  //  Konec platnosti

    @ManyToOne  //  Každé pojištění patří jednomu pojištěnci
    @JoinColumn(name = "pojistenec_id", nullable = false)
    private PojistenecEntity pojistenec;

    //Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTyp() { return typ; }
    public void setTyp(String typ) { this.typ = typ; }

    public BigDecimal getCastka() { return castka; }
    public void setCastka(BigDecimal castka) { this.castka = castka; }

    public LocalDate getDatumOd() { return datumOd; }
    public void setDatumOd(LocalDate datumOd) { this.datumOd = datumOd; }

    public LocalDate getDatumDo() { return datumDo; }
    public void setDatumDo(LocalDate datumDo) { this.datumDo = datumDo; }

    public PojistenecEntity getPojistenec() { return pojistenec; }
    public void setPojistenec(PojistenecEntity pojistenec) { this.pojistenec = pojistenec; }


}
