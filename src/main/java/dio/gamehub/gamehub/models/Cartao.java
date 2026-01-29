package dio.gamehub.gamehub.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", length = 19) // Formato mascarado
    private String numero;

    @Column(precision = 8, scale = 2)
    private BigDecimal limite; // Limite de compra na loja virtual

    public Cartao(Long id, String numero, BigDecimal limite) {
        this.id = id;
        this.numero = numero;
        this.limite = limite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
