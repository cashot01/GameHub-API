package dio.gamehub.api.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 2000) // Texto longo para descrição
    private String descricao;

    @Column(precision = 10, scale = 2) // Preço com 2 casas decimais
    private BigDecimal preco;

    @Column(name = "genero")
    private String genero; // Ex: "Ação", "RPG", "Estratégia"

    @Column(name = "data_lancamento") // Nome da coluna com underline
    private LocalDate dataLancamento;

    @Column(name = "classificacao_etaria")
    private String classificacaoEtaria; // Ex: "L", "10+", "16+", "18+"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desenvolvedora_id") // Chave estrangeira
    private Desenvolvedora desenvolvedora;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jogo_plataforma",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "plataforma_id")
    )
    private List<Plataforma> plataformas = new ArrayList<>();

    public Jogo(Long id, String titulo, String descricao, BigDecimal preco, String genero, LocalDate dataLancamento, String classificacaoEtaria, Desenvolvedora desenvolvedora, List<Plataforma> plataformas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.classificacaoEtaria = classificacaoEtaria;
        this.desenvolvedora = desenvolvedora;
        this.plataformas = plataformas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
}
