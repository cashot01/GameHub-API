package dio.gamehub.api.service.impl;

import dio.gamehub.api.models.Cartao;
import dio.gamehub.api.service.CartaoService;
import dio.gamehub.api.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public List<Cartao> findAll() {
        return cartaoRepository.findAll();
    }

    @Override
    public Optional<Cartao> findById(Long id) {
        return cartaoRepository.findById(id);
    }

    @Override
    public Cartao save(Cartao cartao) {
        cartao.setId(null); // Garante que seja um novo registro
        return cartaoRepository.save(cartao);
    }

    @Override
    public Cartao update(Long id, Cartao cartaoDetails) {
        Cartao existingCartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado com ID: " + id));

        existingCartao.setNumero(cartaoDetails.getNumero());
        existingCartao.setLimite(cartaoDetails.getLimite());

        return cartaoRepository.save(existingCartao);
    }

    @Override
    public boolean deleteById(Long id) {
        if (cartaoRepository.existsById(id)) {
            cartaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
