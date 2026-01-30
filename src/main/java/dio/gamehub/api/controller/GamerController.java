package dio.gamehub.api.controller;

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

    @GetMapping
    @Operation(summary = "Listar todos os gamers")
    public ResponseEntity<List<Gamer>> getAll() {
        return ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gamer por ID")
    public ResponseEntity<Gamer> getById(@PathVariable Long id) {
        Optional<Gamer> gamer = service.findById(id);
        return gamer.map(ResponseEntity::ok).orElse(notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo gamer")
    public ResponseEntity<Gamer> create(@RequestBody Gamer gamer) {
        return status(HttpStatus.CREATED).body(service.save(gamer));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar gamer")
    public ResponseEntity<Gamer> update(@PathVariable Long id, @RequestBody Gamer details) {
        try {
            return ok(service.update(id, details));
        } catch (RuntimeException e) {
            return notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar gamer")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return noContent().build();
        }
        return notFound().build();
    }

    @PutMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Adicionar jogo à biblioteca do gamer")
    public ResponseEntity<Gamer> adicionarJogo(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            return ok(service.adicionarJogo(gamerId, jogoId));
        } catch (RuntimeException e) {
            return notFound().build();
        }
    }

    @DeleteMapping("/{gamerId}/biblioteca/{jogoId}")
    @Operation(summary = "Remover jogo da biblioteca do gamer")
    public ResponseEntity<Gamer> removerJogo(@PathVariable Long gamerId, @PathVariable Long jogoId) {
        try {
            return ok(service.removerJogo(gamerId, jogoId));
        } catch (RuntimeException e) {
            return notFound().build();
        }
    }
}

