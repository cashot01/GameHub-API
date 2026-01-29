package dio.gamehub.gamehub.repository;

import dio.gamehub.gamehub.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

}
