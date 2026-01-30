package dio.gamehub.api.repository;

import dio.gamehub.api.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
