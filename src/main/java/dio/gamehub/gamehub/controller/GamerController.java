package dio.gamehub.gamehub.controller;

import dio.gamehub.gamehub.models.Gamer;
import dio.gamehub.gamehub.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gamers")
@Tag(name = "Gamers", description = "Operações CRUD e gerenciamento de biblioteca de jogos para Gamers")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    @GetMapping
    @Operation(summary = "Listar todos os gamers", description = "Retorna uma lista com todos os gamers cadastrados.")
    public ResponseEntity<List<Gamer>> getAllGamers() {
        List<Gamer> gamers = gamerService.findAll();
        return ResponseEntity.ok(gamers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gamer por ID", description = "Retorna os detalhes de um gamer específico com base no seu ID.")
    public ResponseEntity<Gamer> getGamerById(@PathVariable Long id) {
        Optional<Gamer> obj = gamerService.findById(id);
        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Criar um novo gamer", description = "Registra um novo gamer no sistema.")
    public ResponseEntity<Gamer> createGamer(@RequestBody Gamer gamer) {
        Gamer newGamer = gamerService.save(gamer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGamer);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um gamer existente", description = "Atualiza as informações de um gamer específico com base no seu ID.")
    public ResponseEntity<Gamer> updateGamer(@PathVariable Long id, @RequestBody Gamer gamerDetails) {
        try {
            Gamer updatedGamer = gamerService.update(id, gamerDetails);
            return ResponseEntity.ok(updatedGamer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um gamer", description = "Remove um gamer específico do sistema com base no seu ID.")
    public ResponseEntity<Void> deleteGamer(@PathVariable Long id) {
        boolean deleted = gamerService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- OPERAÇÕES ESPECÍFICAS PARA BIBLIOTECA DE JOGOS ---

    @PutMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Adicionar jogo à biblioteca do gamer", description = "Associa um jogo específico à biblioteca de um gamer.")
    public ResponseEntity<Gamer> adicionarJogoBiblioteca(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            Gamer updatedGamer = gamerService.adicionarJogo(gamerId, jogoId);
            return ResponseEntity.ok(updatedGamer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Remover jogo da biblioteca do gamer", description = "Desassocia um jogo específico da biblioteca de um gamer.")
    public ResponseEntity<Gamer> removerJogoBiblioteca(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            Gamer updatedGamer = gamerService.removerJogo(gamerId, jogoId);
            return ResponseEntity.ok(updatedGamer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

