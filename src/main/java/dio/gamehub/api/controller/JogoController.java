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
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/jogos")
@Tag(name = "Jogos", description = "Catálogo de jogos")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    @Operation(summary = "Listar todos os jogos")
    public ResponseEntity<List<Jogo>> getAll() {
        return ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jogo por ID")
    public ResponseEntity<Jogo> getById(@PathVariable Long id) {
        Optional<Jogo> jogo = service.findById(id);
        return jogo.map(ResponseEntity::ok).orElse(notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo jogo")
    public ResponseEntity<Jogo> create(@RequestBody Jogo jogo) {
        return status(HttpStatus.CREATED).body(service.save(jogo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar jogo")
    public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo details) {
        try {
            return ok(service.update(id, details));
        } catch (RuntimeException e) {
            return notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar jogo")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return noContent().build();
        }
        return notFound().build();
    }
}
