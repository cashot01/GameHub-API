package dio.gamehub.service.impl;

import dio.gamehub.models.Plataforma;
import dio.gamehub.repository.PlataformaRepository;
import dio.gamehub.service.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataformaServiceImpl implements PlataformaService {

    @Autowired
    private PlataformaRepository repository;

    @Override
    public List<Plataforma> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Plataforma> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Plataforma save(Plataforma plataforma) {
        plataforma.setId(null);
        return repository.save(plataforma);
    }

    @Override
    public Plataforma update(Long id, Plataforma details) {
        Plataforma existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plataforma não encontrada com ID: " + id));
        existing.setNome(details.getNome());
        existing.setFabricante(details.getFabricante());
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
