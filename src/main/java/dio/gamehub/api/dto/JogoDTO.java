package dio.gamehub.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class JogoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private String genero;
    private LocalDate dataLancamento;
    private String classificacaoEtaria;
    private String desenvolvedora;
    private String plataformas;

    // Getters e Setters (gerados abaixo)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public String getClassificacaoEtaria() { return classificacaoEtaria; }
    public void setClassificacaoEtaria(String classificacaoEtaria) { this.classificacaoEtaria = classificacaoEtaria; }

    public String getDesenvolvedora() { return desenvolvedora; }
    public void setDesenvolvedora(String desenvolvedora) { this.desenvolvedora = desenvolvedora; }

    public String getPlataformas() { return plataformas; }
    public void setPlataformas(String plataformas) { this.plataformas = plataformas; }
}
