package dio.gamehub.api.service;

import dio.gamehub.api.models.Cartao;

import java.util.List;
import java.util.Optional;

public interface CartaoService {
    List<Cartao> findAll();
    Optional<Cartao> findById(Long id);
    Cartao save(Cartao cartao);
    Cartao update(Long id, Cartao cartaoDetails);
    boolean deleteById(Long id);
}
