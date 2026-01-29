package dio.gamehub.api.controller;

import dio.gamehub.api.models.Cartao;
import dio.gamehub.api.service.CartaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartoes")
@Tag(name = "Cartões", description = "Operações CRUD para gerenciamento de cartões de pagamento dos gamers")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    @Operation(summary = "Listar todos os cartões", description = "Retorna uma lista com todos os cartões cadastrados.")
    public ResponseEntity<List<Cartao>> getAllCartoes() {
        List<Cartao> cartoes = cartaoService.findAll();
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cartão por ID", description = "Retorna os detalhes de um cartão específico com base no seu ID.")
    public ResponseEntity<Cartao> getCartaoById(@PathVariable Long id) {
        Optional<Cartao> obj = cartaoService.findById(id);
        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Criar um novo cartão", description = "Registra um novo cartão no sistema.")
    public ResponseEntity<Cartao> createCartao(@RequestBody Cartao cartao) {
        Cartao newCartao = cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCartao);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um cartão existente", description = "Atualiza as informações de um cartão específico com base no seu ID.")
    public ResponseEntity<Cartao> updateCartao(@PathVariable Long id, @RequestBody Cartao cartaoDetails) {
        try {
            Cartao updatedCartao = cartaoService.update(id, cartaoDetails);
            return ResponseEntity.ok(updatedCartao);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cartão", description = "Remove um cartão específico do sistema com base no seu ID.")
    public ResponseEntity<Void> deleteCartao(@PathVariable Long id) {
        boolean deleted = cartaoService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
