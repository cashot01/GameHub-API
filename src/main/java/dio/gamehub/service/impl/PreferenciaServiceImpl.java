package dio.gamehub.service.impl;

import dio.gamehub.models.Preferencia;
import dio.gamehub.repository.PreferenciaRepository;
import dio.gamehub.service.PreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenciaServiceImpl implements PreferenciaService {

    @Autowired
    private PreferenciaRepository repository;

    @Override
    public List<Preferencia> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Preferencia> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Preferencia save(Preferencia preferencia) {
        preferencia.setId(null);
        return repository.save(preferencia);
    }

    @Override
    public Preferencia update(Long id, Preferencia details) {
        Preferencia existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preferência não encontrada com ID: " + id));
        existing.setIconeUrl(details.getIconeUrl());
        existing.setDescricao(details.getDescricao());
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
