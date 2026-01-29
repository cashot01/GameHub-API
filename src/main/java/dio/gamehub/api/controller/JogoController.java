package dio.gamehub.api.controller;

import dio.gamehub.api.models.Jogo;
import dio.gamehub.api.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@Tag(name = "Jogos", description = "Catálogo de jogos disponíveis na plataforma")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    @Operation(summary = "Listar todos os jogos")
    public ResponseEntity<List<Jogo>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jogo por ID")
    public ResponseEntity<Jogo> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo jogo")
    public ResponseEntity<Jogo> create(@RequestBody Jogo jogo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(jogo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar jogo")
    public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo details) {
        try {
            return ResponseEntity.ok(service.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar jogo")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoints customizados (opcionais)
    @GetMapping("/genero/{genero}")
    @Operation(summary = "Buscar jogos por gênero")
    public ResponseEntity<List<Jogo>> getByGenero(@PathVariable String genero) {
        return ResponseEntity.ok(service.findByGenero(genero));
    }

    @GetMapping("/desenvolvedora/{devId}")
    @Operation(summary = "Buscar jogos por ID da desenvolvedora")
    public ResponseEntity<List<Jogo>> getByDesenvolvedora(@PathVariable Long devId) {
        return ResponseEntity.ok(service.findByDesenvolvedoraId(devId));
    }
}
