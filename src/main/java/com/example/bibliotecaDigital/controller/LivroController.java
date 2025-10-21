package com.example.bibliotecaDigital.controller;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findById(uuid));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Livro> update(@PathVariable UUID uuid, @RequestBody Livro livro) {
        return ResponseEntity.ok(service.update(uuid, livro));
    }

    @DeleteMapping
    public void delete(@RequestBody Livro livro) {
        service.delete(livro);
    }
}
