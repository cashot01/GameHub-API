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
    private JogoRepository repository;

    @Override
    public List<Jogo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Jogo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Jogo save(Jogo jogo) {
        jogo.setId(null);
        return repository.save(jogo);
    }

    @Override
    public Jogo update(Long id, Jogo details) {
        Jogo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));
        existing.setTitulo(details.getTitulo());
        existing.setDescricao(details.getDescricao());
        existing.setPreco(details.getPreco());
        existing.setGenero(details.getGenero());
        existing.setDataLancamento(details.getDataLancamento());
        existing.setClassificacaoEtaria(details.getClassificacaoEtaria());
        existing.setDesenvolvedora(details.getDesenvolvedora());
        existing.setPlataformas(details.getPlataformas());
        return repository.save(existing);
    }

    @Override
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Jogo> findByGenero(String genero) {
        return repository.findByGenero(genero);
    }

    @Override
    public List<Jogo> findByDesenvolvedoraId(Long devId) {
        return repository.findByDesenvolvedora_Id(devId);
    }
}
