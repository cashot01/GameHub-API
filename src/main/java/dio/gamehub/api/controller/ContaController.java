package dio.gamehub.api.controller;

import dio.gamehub.api.models.Conta;
import dio.gamehub.api.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
@Tag(name = "Contas", description = "Operações CRUD para contas de gamers")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    @Operation(summary = "Listar todas as contas")
    public ResponseEntity<List<Conta>> getAll() {
        return ResponseEntity.ok(contaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar conta por ID")
    public ResponseEntity<Conta> getById(@PathVariable Long id) {
        return contaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova conta")
    public ResponseEntity<Conta> create(@RequestBody Conta conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(conta));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar conta")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta details) {
        try {
            return ResponseEntity.ok(contaService.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar conta")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contaService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
