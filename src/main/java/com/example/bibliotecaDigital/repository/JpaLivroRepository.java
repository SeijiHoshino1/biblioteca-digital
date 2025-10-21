package com.example.bibliotecaDigital.repository;

import com.example.bibliotecaDigital.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaLivroRepository extends JpaRepository<Livro, UUID> {
}
