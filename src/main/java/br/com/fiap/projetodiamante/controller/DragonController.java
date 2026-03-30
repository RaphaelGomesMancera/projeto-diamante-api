package br.com.fiap.projetodiamante.controller;

import br.com.fiap.projetodiamante.model.Dragon;
import br.com.fiap.projetodiamante.service.DragonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dragons")
@CrossOrigin(origins = "*")
public class DragonController {

    private final DragonService dragonService;

    public DragonController(DragonService dragonService) {
        this.dragonService = dragonService;
    }

    @GetMapping
    public ResponseEntity<List<Dragon>> listarTodos() {
        return ResponseEntity.ok(dragonService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dragon> buscarPorId(@PathVariable Long id) {
        return dragonService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dragon> cadastrar(@RequestBody @Valid Dragon dragon) {
        Dragon dragonSalvo = dragonService.salvar(dragon);
        return ResponseEntity.status(HttpStatus.CREATED).body(dragonSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dragon> atualizar(@PathVariable Long id, @RequestBody @Valid Dragon dragon) {
        return dragonService.atualizar(id, dragon)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!dragonService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
