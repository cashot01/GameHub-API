package dio.gamehub.service;

import dio.gamehub.models.Conta;

import java.util.List;
import java.util.Optional;

public interface ContaService {
    List<Conta> findAll();
    Optional<Conta> findById(Long id);
    Conta save(Conta conta);
    Conta update(Long id, Conta contaDetails);
    boolean deleteById(Long id);
}
