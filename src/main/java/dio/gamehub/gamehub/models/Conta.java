package dio.gamehub.gamehub.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saldo_moeda_virtual", precision = 8, scale = 2)
    private BigDecimal saldoMoedaVirtual; // Ex: Créditos para comprar jogos extras

    @Column(name = "nivel_assinatura")
    private String nivelAssinatura; // Ex: "Grátis", "Premium", "VIP"

    public Conta(Long id, BigDecimal saldoMoedaVirtual, String nivelAssinatura) {
        this.id = id;
        this.saldoMoedaVirtual = saldoMoedaVirtual;
        this.nivelAssinatura = nivelAssinatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldoMoedaVirtual() {
        return saldoMoedaVirtual;
    }

    public void setSaldoMoedaVirtual(BigDecimal saldoMoedaVirtual) {
        this.saldoMoedaVirtual = saldoMoedaVirtual;
    }

    public String getNivelAssinatura() {
        return nivelAssinatura;
    }

    public void setNivelAssinatura(String nivelAssinatura) {
        this.nivelAssinatura = nivelAssinatura;
    }
}
