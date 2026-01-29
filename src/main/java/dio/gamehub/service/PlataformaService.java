package dio.gamehub.service;

import dio.gamehub.models.Plataforma;

import java.util.List;
import java.util.Optional;

public interface PlataformaService {
    List<Plataforma> findAll();
    Optional<Plataforma> findById(Long id);
    Plataforma save(Plataforma plataforma);
    Plataforma update(Long id, Plataforma details);
    boolean deleteById(Long id);
}
