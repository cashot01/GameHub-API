package dio.gamehub.gamehub.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gamers")
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cartao_id", referencedColumnName = "id")
    private Cartao cartao;

    @OneToMany(mappedBy = "gamer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Preferencia> preferencias = new ArrayList<>();

    @OneToMany(mappedBy = "gamer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Noticia noticia;

    public Gamer(Long id, String nome, Conta conta, Cartao cartao, List<Preferencia> preferencias, Noticia noticia) {
        this.id = id;
        this.nome = nome;
        this.conta = conta;
        this.cartao = cartao;
        this.preferencias = preferencias;
        this.noticia = noticia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public List<Preferencia> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(List<Preferencia> preferencias) {
        this.preferencias = preferencias;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
}
