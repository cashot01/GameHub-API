package dio.gamehub.api.service.impl;

import dio.gamehub.api.dto.JogoDTO;
import dio.gamehub.api.models.Jogo;
import dio.gamehub.api.repository.JogoRepository;
import dio.gamehub.api.service.JogoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    private JogoDTO toDTO(Jogo jogo) {
        JogoDTO dto = new JogoDTO();
        BeanUtils.copyProperties(jogo, dto);
        return dto;
    }

    private Jogo toEntity(JogoDTO dto) {
        Jogo jogo = new Jogo();
        BeanUtils.copyProperties(dto, jogo);
        return jogo;
    }

    @Override
    public JogoDTO save(JogoDTO dto) {
        Jogo jogo = toEntity(dto);
        jogo.setId(null);
        Jogo saved = jogoRepository.save(jogo);
        return toDTO(saved);
    }

    @Override
    public JogoDTO findById(Long id) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));
        return toDTO(jogo);
    }

    @Override
    public List<JogoDTO> findAll() {
        return jogoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JogoDTO update(Long id, JogoDTO dto) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));
        // Atualiza todos os campos
        jogo.setTitulo(dto.getTitulo());
        jogo.setDescricao(dto.getDescricao());
        jogo.setPreco(dto.getPreco());
        jogo.setGenero(dto.getGenero());
        jogo.setDataLancamento(dto.getDataLancamento());
        jogo.setClassificacaoEtaria(dto.getClassificacaoEtaria());
        jogo.setDesenvolvedora(dto.getDesenvolvedora());
        jogo.setPlataformas(dto.getPlataformas());
        Jogo updated = jogoRepository.save(jogo);
        return toDTO(updated);
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
