package dio.gamehub.service;

import dio.gamehub.models.Preferencia;

import java.util.List;
import java.util.Optional;

public interface PreferenciaService {
    List<Preferencia> findAll();
    Optional<Preferencia> findById(Long id);
    Preferencia save(Preferencia preferencia);
    Preferencia update(Long id, Preferencia details);
    boolean deleteById(Long id);
}
