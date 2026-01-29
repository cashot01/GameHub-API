package dio.gamehub.service.impl;

import dio.gamehub.models.Noticia;
import dio.gamehub.repository.NoticiaRepository;
import dio.gamehub.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private NoticiaRepository repository;

    @Override
    public List<Noticia> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Noticia> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Noticia save(Noticia noticia) {
        noticia.setId(null);
        return repository.save(noticia);
    }

    @Override
    public Noticia update(Long id, Noticia details) {
        Noticia existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notícia não encontrada com ID: " + id));
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
