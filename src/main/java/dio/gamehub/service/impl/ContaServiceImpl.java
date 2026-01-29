package dio.gamehub.service.impl;

import dio.gamehub.models.Conta;
import dio.gamehub.repository.ContaRepository;
import dio.gamehub.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository repository;

    @Override
    public List<Conta> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Conta> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Conta save(Conta conta) {
        conta.setId(null);
        return repository.save(conta);
    }

    @Override
    public Conta update(Long id, Conta details) {
        Conta existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada com ID: " + id));
        existing.setSaldoMoedaVirtual(details.getSaldoMoedaVirtual());
        existing.setNivelAssinatura(details.getNivelAssinatura());
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
