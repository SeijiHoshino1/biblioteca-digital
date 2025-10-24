package com.example.bibliotecaDigital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tb_livro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "qtd_paginas")
    private int qtd_paginas;
}
