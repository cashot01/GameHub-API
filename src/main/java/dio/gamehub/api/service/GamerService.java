package dio.gamehub.api.service;

import dio.gamehub.api.dto.GamerCreateDTO;
import dio.gamehub.api.dto.GamerResponseDTO;
import dio.gamehub.api.models.Gamer;

import java.util.List;
import java.util.Optional;

public interface GamerService {
    GamerResponseDTO save(GamerCreateDTO dto);
    GamerResponseDTO findById(Long id);
    List<GamerResponseDTO> findAll();
    GamerResponseDTO updateNome(Long id, String nome);
    boolean deleteById(Long id);
    GamerResponseDTO adicionarJogo(Long gamerId, Long jogoId);
    GamerResponseDTO removerJogo(Long gamerId, Long jogoId);
}
