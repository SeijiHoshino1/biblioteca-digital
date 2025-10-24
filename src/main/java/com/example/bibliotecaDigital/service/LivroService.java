package com.example.bibliotecaDigital.service;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.repository.JpaLivroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final JpaLivroRepository jpaLivroRepository;

    public List<Livro> findAll() {
        return jpaLivroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return jpaLivroRepository.findById(id);
    }

    @Transactional
    public Livro save(Livro livro) {
        return jpaLivroRepository.save(livro);
    }

    @Transactional
    public Livro update(Long id, Livro livro) {
        Livro livroUpdate = jpaLivroRepository.findById(id).orElseThrow();

        livroUpdate.setTitulo(livro.getTitulo());
        livroUpdate.setAutor(livro.getAutor());
        livroUpdate.setCategoria(livro.getCategoria());
        livroUpdate.setQtd_paginas(livro.getQtd_paginas());

        return jpaLivroRepository.save(livroUpdate);
    }

    @Transactional
    public void delete(Long id) {
        jpaLivroRepository.deleteById(id);
    }
}
