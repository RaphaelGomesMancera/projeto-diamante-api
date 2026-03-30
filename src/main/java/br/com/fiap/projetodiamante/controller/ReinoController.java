package br.com.fiap.projetodiamante.controller;

import br.com.fiap.projetodiamante.model.Reino;
import br.com.fiap.projetodiamante.service.ReinoService;
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
@RequestMapping("/reinos")
@CrossOrigin(origins = "*")
public class ReinoController {

    private final ReinoService reinoService;

    public ReinoController(ReinoService reinoService) {
        this.reinoService = reinoService;
    }

    @GetMapping
    public ResponseEntity<List<Reino>> listarTodos() {
        return ResponseEntity.ok(reinoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reino> buscarPorId(@PathVariable Long id) {
        return reinoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reino> cadastrar(@RequestBody @Valid Reino reino) {
        Reino reinoSalvo = reinoService.salvar(reino);
        return ResponseEntity.status(HttpStatus.CREATED).body(reinoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reino> atualizar(@PathVariable Long id, @RequestBody @Valid Reino reino) {
        return reinoService.atualizar(id, reino)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!reinoService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
