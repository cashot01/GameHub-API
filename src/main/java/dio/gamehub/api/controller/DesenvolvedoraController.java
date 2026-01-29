package dio.gamehub.api.controller;

import dio.gamehub.api.models.Desenvolvedora;
import dio.gamehub.api.service.DesenvolvedoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desenvolvedoras")
@Tag(name = "Desenvolvedoras", description = "Empresas desenvolvedoras de jogos")
public class DesenvolvedoraController {

    @Autowired
    private DesenvolvedoraService service;

    @GetMapping
    @Operation(summary = "Listar todas as desenvolvedoras")
    public ResponseEntity<List<Desenvolvedora>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar desenvolvedora por ID")
    public ResponseEntity<Desenvolvedora> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova desenvolvedora")
    public ResponseEntity<Desenvolvedora> create(@RequestBody Desenvolvedora dev) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dev));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar desenvolvedora")
    public ResponseEntity<Desenvolvedora> update(@PathVariable Long id, @RequestBody Desenvolvedora details) {
        try {
            return ResponseEntity.ok(service.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar desenvolvedora")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
