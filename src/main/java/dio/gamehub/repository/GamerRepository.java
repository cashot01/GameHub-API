package dio.gamehub.repository;

import dio.gamehub.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

}
