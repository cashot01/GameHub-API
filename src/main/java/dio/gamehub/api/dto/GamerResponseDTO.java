package dio.gamehub.api.dto;

import java.util.Set;

public class GamerResponseDTO {
    private Long id;
    private String nome;
    private Set<JogoDTO> bibliotecaJogos;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Set<JogoDTO> getBibliotecaJogos() { return bibliotecaJogos; }
    public void setBibliotecaJogos(Set<JogoDTO> bibliotecaJogos) { this.bibliotecaJogos = bibliotecaJogos; }
}
