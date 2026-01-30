package dio.gamehub.api.service;

import dio.gamehub.api.models.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoService {
    List<Jogo> findAll();
    Optional<Jogo> findById(Long id);
    Jogo save(Jogo jogo);
    Jogo update(Long id, Jogo jogoDetails);
    boolean deleteById(Long id);
}
