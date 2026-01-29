package dio.gamehub.api.service;

import dio.gamehub.api.models.Noticia;

import java.util.List;
import java.util.Optional;

public interface NoticiaService {
    List<Noticia> findAll();
    Optional<Noticia> findById(Long id);
    Noticia save(Noticia noticia);
    Noticia update(Long id, Noticia details);
    boolean deleteById(Long id);
}
