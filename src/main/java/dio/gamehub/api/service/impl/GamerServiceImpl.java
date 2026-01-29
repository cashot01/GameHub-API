package dio.gamehub.api.service.impl;

import dio.gamehub.api.models.Gamer;
import dio.gamehub.api.models.Jogo;
import dio.gamehub.api.repository.GamerRepository;
import dio.gamehub.api.repository.JogoRepository;
import dio.gamehub.api.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GamerServiceImpl implements GamerService {

    @Autowired
    private GamerRepository gamerRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public List<Gamer> findAll() {
        return gamerRepository.findAll();
    }

    @Override
    public Optional<Gamer> findById(Long id) {
        return gamerRepository.findById(id);
    }

    @Override
    public Gamer save(Gamer gamer) {
        // Garante que IDs gerados automaticamente não sejam sobrescritos
        gamer.setId(null);
        return gamerRepository.save(gamer);
    }

    @Override
    @Transactional
    public Gamer update(Long id, Gamer gamerDetails) {
        Gamer existingGamer = gamerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + id));

        // Atualiza campos básicos
        existingGamer.setNome(gamerDetails.getNome());
        existingGamer.setConta(gamerDetails.getConta());
        existingGamer.setCartao(gamerDetails.getCartao());
        existingGamer.setPreferencias(gamerDetails.getPreferencias());
        existingGamer.setNoticias(gamerDetails.getNoticias()); // Atenção: isso substitui a noticia inteira

        return gamerRepository.save(existingGamer);
    }

    @Override
    public boolean deleteById(Long id) {
        if (gamerRepository.existsById(id)) {
            gamerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Gamer adicionarJogo(Long gamerId, Long jogoId) {
        Gamer gamer = gamerRepository.findById(gamerId)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + gamerId));

        Jogo jogo = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + jogoId));

        gamer.getBibliotecaJogos().add(jogo);
        return gamerRepository.save(gamer);
    }

    @Override
    @Transactional
    public Gamer removerJogo(Long gamerId, Long jogoId) {
        Gamer gamer = gamerRepository.findById(gamerId)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + gamerId));

        Jogo jogo = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + jogoId));

        gamer.getBibliotecaJogos().remove(jogo);
        return gamerRepository.save(gamer);
    }
}
