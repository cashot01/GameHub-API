package dio.gamehub.service.impl;

import dio.gamehub.models.Desenvolvedora;
import dio.gamehub.repository.DesenvolvedoraRepository;
import dio.gamehub.service.DesenvolvedoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedoraServiceImpl implements DesenvolvedoraService {

    @Autowired
    private DesenvolvedoraRepository repository;

    @Override
    public List<Desenvolvedora> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Desenvolvedora> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Desenvolvedora save(Desenvolvedora dev) {
        dev.setId(null);
        return repository.save(dev);
    }

    @Override
    public Desenvolvedora update(Long id, Desenvolvedora details) {
        Desenvolvedora existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada com ID: " + id));
        existing.setNome(details.getNome());
        existing.setPaisOrigem(details.getPaisOrigem());
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
}
