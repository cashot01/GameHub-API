package dio.gamehub.api.models;

import jakarta.persistence.*;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "gamer_jogo",
            joinColumns = @JoinColumn(name = "gamer_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private Set<Jogo> bibliotecaJogos = new HashSet<>();

    public Gamer() {
    }

    public Gamer(Long id, String nome, Set<Jogo> bibliotecaJogos) {
        this.id = id;
        this.nome = nome;
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

    public Set<Jogo> getBibliotecaJogos() {
        return bibliotecaJogos;
    }

    public void setBibliotecaJogos(Set<Jogo> bibliotecaJogos) {
        this.bibliotecaJogos = bibliotecaJogos;
    }
}
