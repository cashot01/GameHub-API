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

    @Column(length = 2000)
    private String descricao;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    @Column
    private String genero;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "classificacao_etaria")
    private String classificacaoEtaria;

    @Column
    private String desenvolvedora; // ex: "FromSoftware"

    @Column
    private String plataformas; // ex: "PC, PlayStation 5, Xbox Series X"

    public Jogo() {
    }

    public Jogo(Long id, String titulo, String descricao, BigDecimal preco, String genero, LocalDate dataLancamento, String classificacaoEtaria, String desenvolvedora, String plataformas) {
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

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }
}
