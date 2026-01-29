package dio.gamehub.api.controller;

import dio.gamehub.api.models.Plataforma;
import dio.gamehub.api.service.PlataformaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plataformas")
@Tag(name = "Plataformas", description = "Consoles e sistemas onde os jogos são executados")
public class PlataformaController {

    @Autowired
    private PlataformaService service;

    @GetMapping
    @Operation(summary = "Listar todas as plataformas")
    public ResponseEntity<List<Plataforma>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar plataforma por ID")
    public ResponseEntity<Plataforma> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova plataforma")
    public ResponseEntity<Plataforma> create(@RequestBody Plataforma plataforma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(plataforma));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar plataforma")
    public ResponseEntity<Plataforma> update(@PathVariable Long id, @RequestBody Plataforma details) {
        try {
            return ResponseEntity.ok(service.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar plataforma")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
