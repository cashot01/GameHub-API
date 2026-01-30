package dio.gamehub.api.service.impl;

import dio.gamehub.api.models.Jogo;
import dio.gamehub.api.repository.JogoRepository;
import dio.gamehub.api.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    @Override
    public Optional<Jogo> findById(Long id) {
        return jogoRepository.findById(id);
    }

    @Override
    public Jogo save(Jogo jogo) {
        jogo.setId(null);
        return jogoRepository.save(jogo);
    }

    @Override
    public Jogo update(Long id, Jogo jogoDetails) {
        Jogo existing = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));
        existing.setTitulo(jogoDetails.getTitulo());
        existing.setDescricao(jogoDetails.getDescricao());
        existing.setPreco(jogoDetails.getPreco());
        existing.setGenero(jogoDetails.getGenero());
        existing.setDataLancamento(jogoDetails.getDataLancamento());
        existing.setClassificacaoEtaria(jogoDetails.getClassificacaoEtaria());
        existing.setDesenvolvedora(jogoDetails.getDesenvolvedora());
        existing.setPlataformas(jogoDetails.getPlataformas());
        return jogoRepository.save(existing);
    }

    @Override
    public boolean deleteById(Long id) {
        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
