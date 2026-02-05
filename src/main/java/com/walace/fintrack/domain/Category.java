package com.walace.fintrack.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity: esta classe vira uma tabela no banco (ex: CATEGORY)
@Entity
public class Category {

    // @Id: chave primária da tabela
    @Id
    // @GeneratedValue: banco gera o ID automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // CONSTRUTOR VAZIO (obrigatório pro JPA)
    public Category() {
    }

    // CONSTRUTOR ÚTIL (pra você criar categorias no código)
    public Category(String name) {
        this.name = name;
    }

    // GETTERS
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // SETTER (JPA precisa conseguir setar em alguns cenários)
    public void setName(String name) {
        this.name = name;
    }
}
