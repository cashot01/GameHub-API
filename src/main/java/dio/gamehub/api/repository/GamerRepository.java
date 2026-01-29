package dio.gamehub.api.repository;

import dio.gamehub.api.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

}
