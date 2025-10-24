package com.example.bibliotecaDigital.controller;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    @Autowired
    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        return ResponseEntity.ok(service.update(id, livro));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
