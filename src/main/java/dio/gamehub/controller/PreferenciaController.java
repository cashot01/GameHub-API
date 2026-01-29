package dio.gamehub.controller;

import dio.gamehub.models.Preferencia;
import dio.gamehub.service.PreferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferencias")
@Tag(name = "Preferencias", description = "Operações CRUD para preferencias de gamers")
public class PreferenciaController {

    @Autowired
    private PreferenciaService preferenciaService;

    @GetMapping
    @Operation(summary = "Listar todas as preferencias")
    public ResponseEntity<List<Preferencia>> getAll() {
        return ResponseEntity.ok(preferenciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar preferencia por ID")
    public ResponseEntity<Preferencia> getById(@PathVariable Long id) {
        return preferenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova preferencia")
    public ResponseEntity<Preferencia> create(@RequestBody Preferencia preferencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(preferenciaService.save(preferencia));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar preferencia")
    public ResponseEntity<Preferencia> update(@PathVariable Long id, @RequestBody Preferencia details) {
        try {
            return ResponseEntity.ok(preferenciaService.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar preferencia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (preferenciaService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
