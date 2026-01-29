package dio.gamehub.gamehub.service;

import dio.gamehub.gamehub.models.Gamer;

import java.util.List;
import java.util.Optional;

public interface GamerService {
    List<Gamer> findAll();
    Optional<Gamer> findById(Long id);
    Gamer save(Gamer gamer);
    Gamer update(Long id, Gamer gamerDetails);
    boolean deleteById(Long id);
    Gamer adicionarJogo(Long gamerId, Long jogoId);
    Gamer removerJogo(Long gamerId, Long jogoId);
}
