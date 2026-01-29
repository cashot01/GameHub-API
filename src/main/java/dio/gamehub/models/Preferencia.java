package dio.gamehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "preferencias")
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "icone_url")
    private String iconeUrl; // URL do ícone do gênero (ex: ação, RPG)

    @Column(name = "descricao", nullable = false)
    private String descricao; // Ex: "Ação", "RPG", "Esportes"

    // Chave estrangeira para Gamer
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore // Importante para evitar serialização infinita no JSON
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    public Preferencia(Long id, String iconeUrl, String descricao, Gamer gamer) {
        this.id = id;
        this.iconeUrl = iconeUrl;
        this.descricao = descricao;
        this.gamer = gamer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIconeUrl() {
        return iconeUrl;
    }

    public void setIconeUrl(String iconeUrl) {
        this.iconeUrl = iconeUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }
}
