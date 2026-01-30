package dio.gamehub.api.controller;

import dio.gamehub.api.dto.JogoDTO;
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

    @PostMapping
    @Operation(summary = "Criar novo jogo")
    public ResponseEntity<JogoDTO> create(@RequestBody JogoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jogo por ID")
    public ResponseEntity<JogoDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os jogos")
    public ResponseEntity<List<JogoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar jogo")
    public ResponseEntity<JogoDTO> update(@PathVariable Long id, @RequestBody JogoDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
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
}
