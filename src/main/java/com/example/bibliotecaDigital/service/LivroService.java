package com.example.bibliotecaDigital.service;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.repository.JpaLivroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final JpaLivroRepository jpaLivroRepository;

    public List<Livro> findAll() {
        return jpaLivroRepository.findAll();
    }

    public Optional<Livro> findById(UUID uuid) {
        return jpaLivroRepository.findById(uuid);
    }

    @Transactional
    public Livro save(Livro livro) {
        return jpaLivroRepository.save(livro);
    }

    @Transactional
    public Livro update(UUID uuid, Livro livro) {
        jpaLivroRepository.findById(uuid);

        livro.setTitulo(livro.getTitulo());
        livro.setAutor(livro.getAutor());
        livro.setCategoria(livro.getCategoria());
        livro.setQtd_paginas(livro.getQtd_paginas());

        jpaLivroRepository.save(livro);

        return livro;
    }

    @Transactional
    public void delete(Livro livro) {
        jpaLivroRepository.delete(livro);
    }
}
