package dio.gamehub.api.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<Noticia> noticias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "gamer_jogo",
            joinColumns = @JoinColumn(name = "gamer_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private Set<Jogo> bibliotecaJogos = new HashSet<>(); // Usamos Set para evitar duplicatas

    public Gamer(Long id, String nome, Conta conta, Cartao cartao, List<Preferencia> preferencias, List<Noticia> noticias, Set<Jogo> bibliotecaJogos) {
        this.id = id;
        this.nome = nome;
        this.conta = conta;
        this.cartao = cartao;
        this.preferencias = preferencias;
        this.noticias = noticias;
        this.bibliotecaJogos = bibliotecaJogos;
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

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public Set<Jogo> getBibliotecaJogos() {
        return bibliotecaJogos;
    }

    public void setBibliotecaJogos(Set<Jogo> bibliotecaJogos) {
        this.bibliotecaJogos = bibliotecaJogos;
    }
}
