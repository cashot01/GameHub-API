package dio.gamehub.repository;

import dio.gamehub.models.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
