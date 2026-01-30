package dio.gamehub.api.controller;

import dio.gamehub.api.dto.GamerCreateDTO;
import dio.gamehub.api.dto.GamerResponseDTO;
import dio.gamehub.api.dto.GamerUpdateDTO;
import dio.gamehub.api.models.Gamer;
import dio.gamehub.api.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/gamers")
@Tag(name = "Gamers", description = "Gerenciamento de jogadores e suas bibliotecas de jogos")
public class GamerController {

    @Autowired
    private GamerService service;

    @PostMapping
    @Operation(summary = "Criar novo gamer")
    public ResponseEntity<GamerResponseDTO> create(@RequestBody GamerCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gamer por ID")
    public ResponseEntity<GamerResponseDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os gamers")
    public ResponseEntity<List<GamerResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar nome do gamer")
    public ResponseEntity<GamerResponseDTO> update(@PathVariable Long id, @RequestBody GamerUpdateDTO dto) {
        try {
            return ResponseEntity.ok(service.updateNome(id, dto.getNome()));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar gamer")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Adicionar jogo à biblioteca do gamer")
    public ResponseEntity<GamerResponseDTO> adicionarJogo(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            return ResponseEntity.ok(service.adicionarJogo(gamerId, jogoId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Remover jogo da biblioteca do gamer")
    public ResponseEntity<GamerResponseDTO> removerJogo(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            return ResponseEntity.ok(service.removerJogo(gamerId, jogoId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

