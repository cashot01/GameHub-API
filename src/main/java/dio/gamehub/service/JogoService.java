package dio.gamehub.service;

import dio.gamehub.models.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoService {
    List<Jogo> findAll();
    Optional<Jogo> findById(Long id);
    Jogo save(Jogo jogo);
    Jogo update(Long id, Jogo details);
    boolean deleteById(Long id);
    List<Jogo> findByGenero(String genero);
    List<Jogo> findByDesenvolvedoraId(Long devId);
}
