package dio.gamehub.api.service;

import dio.gamehub.api.dto.JogoDTO;
import dio.gamehub.api.models.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoService {
    JogoDTO save(JogoDTO dto);
    JogoDTO findById(Long id);
    List<JogoDTO> findAll();
    JogoDTO update(Long id, JogoDTO dto);
    boolean deleteById(Long id);
}
