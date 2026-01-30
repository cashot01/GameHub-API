package dio.gamehub.api.service.impl;

import dio.gamehub.api.dto.GamerCreateDTO;
import dio.gamehub.api.dto.GamerResponseDTO;
import dio.gamehub.api.dto.JogoDTO;
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
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class GamerServiceImpl implements GamerService {

    @Autowired
    private GamerRepository gamerRepository;

    @Autowired
    private JogoRepository jogoRepository;

    private GamerResponseDTO toDTO(Gamer gamer) {
        GamerResponseDTO dto = new GamerResponseDTO();
        dto.setId(gamer.getId());
        dto.setNome(gamer.getNome());

        Set<JogoDTO> jogoDTOs = gamer.getBibliotecaJogos().stream()
                .map(jogo -> {
                    JogoDTO jdto = new JogoDTO();
                    jdto.setId(jogo.getId());
                    jdto.setTitulo(jogo.getTitulo());
                    jdto.setDescricao(jogo.getDescricao());
                    jdto.setPreco(jogo.getPreco());
                    jdto.setGenero(jogo.getGenero());
                    jdto.setDataLancamento(jogo.getDataLancamento());
                    jdto.setClassificacaoEtaria(jogo.getClassificacaoEtaria());
                    jdto.setDesenvolvedora(jogo.getDesenvolvedora());
                    jdto.setPlataformas(jogo.getPlataformas());
                    return jdto;
                })
                .collect(Collectors.toSet());

        dto.setBibliotecaJogos(jogoDTOs);
        return dto;
    }

    @Override
    public GamerResponseDTO save(GamerCreateDTO dto) {
        Gamer gamer = new Gamer();
        gamer.setNome(dto.getNome());
        Gamer saved = gamerRepository.save(gamer);
        return toDTO(saved);
    }

    @Override
    public GamerResponseDTO findById(Long id) {
        Gamer gamer = gamerRepository.findWithBibliotecaJogosById(id)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + id));
        return toDTO(gamer);
    }

    @Override
    public List<GamerResponseDTO> findAll() {
        return gamerRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GamerResponseDTO updateNome(Long id, String nome) {
        Gamer gamer = gamerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + id));
        gamer.setNome(nome);
        Gamer updated = gamerRepository.save(gamer);
        return toDTO(updated);
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
    public GamerResponseDTO adicionarJogo(Long gamerId, Long jogoId) {
        Gamer gamer = gamerRepository.findById(gamerId)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + gamerId));
        Jogo jogo = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + jogoId));

        gamer.getBibliotecaJogos().add(jogo);
        Gamer updated = gamerRepository.save(gamer);
        return toDTO(updated);
    }

    @Override
    @Transactional
    public GamerResponseDTO removerJogo(Long gamerId, Long jogoId) {
        Gamer gamer = gamerRepository.findById(gamerId)
                .orElseThrow(() -> new RuntimeException("Gamer não encontrado com ID: " + gamerId));
        Jogo jogo = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + jogoId));

        gamer.getBibliotecaJogos().remove(jogo);
        Gamer updated = gamerRepository.save(gamer);
        return toDTO(updated);
    }
}
