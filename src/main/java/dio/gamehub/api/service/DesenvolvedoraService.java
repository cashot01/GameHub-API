package dio.gamehub.api.service;

import dio.gamehub.api.models.Desenvolvedora;

import java.util.List;
import java.util.Optional;

public interface DesenvolvedoraService {
    List<Desenvolvedora> findAll();
    Optional<Desenvolvedora> findById(Long id);
    Desenvolvedora save(Desenvolvedora desenvolvedora);
    Desenvolvedora update(Long id, Desenvolvedora details);
    boolean deleteById(Long id);
}
