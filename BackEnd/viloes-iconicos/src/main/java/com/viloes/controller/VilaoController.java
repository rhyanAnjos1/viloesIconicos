package com.viloes.controller;

import java.util.List;

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

import com.viloes.entities.Vilao;
import com.viloes.services.VilaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/viloes")
@CrossOrigin(origins = "*")
public class VilaoController {

    private final VilaoService service;

    VilaoController(VilaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vilao> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vilao> buscarPorId(@PathVariable Long id) {

        Vilao vilao = service.buscarPorId(id);

        if (vilao != null) {
            return ResponseEntity.ok(vilao);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Vilao cadastrar(@Valid @RequestBody Vilao vilao) {
        return service.salvar(vilao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vilao> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Vilao vilao) {

        Vilao vilaoAtualizado = service.atualizar(id, vilao);

        if (vilaoAtualizado != null) {
            return ResponseEntity.ok(vilaoAtualizado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        boolean deletado = service.deletar(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}