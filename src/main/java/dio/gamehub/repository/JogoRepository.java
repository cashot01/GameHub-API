package dio.gamehub.repository;

import dio.gamehub.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByGenero(String genero);
    List<Jogo> findByDesenvolvedora_Id(Long devId);
}
