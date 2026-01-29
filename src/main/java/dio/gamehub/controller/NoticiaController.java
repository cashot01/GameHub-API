package dio.gamehub.controller;

import dio.gamehub.models.Noticia;
import dio.gamehub.service.NoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/noticias")
@Tag(name = "Notícias", description = "Novidades e promoções para gamers")
public class NoticiaController {

    @Autowired
    private NoticiaService service;

    @GetMapping
    @Operation(summary = "Listar todas as notícias")
    public ResponseEntity<List<Noticia>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notícia por ID")
    public ResponseEntity<Noticia> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova notícia")
    public ResponseEntity<Noticia> create(@RequestBody Noticia noticia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(noticia));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notícia")
    public ResponseEntity<Noticia> update(@PathVariable Long id, @RequestBody Noticia details) {
        try {
            return ResponseEntity.ok(service.update(id, details));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar notícia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
