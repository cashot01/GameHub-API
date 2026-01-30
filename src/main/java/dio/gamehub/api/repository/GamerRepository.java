package dio.gamehub.api.repository;

import dio.gamehub.api.models.Gamer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {
    @EntityGraph(attributePaths = "bibliotecaJogos")
    Optional<Gamer> findWithBibliotecaJogosById(Long id);
}
