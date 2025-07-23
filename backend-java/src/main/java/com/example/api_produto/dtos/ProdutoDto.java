package com.example.api_produto.dtos;

import java.math.BigDecimal;

public class ProdutoDto {
    private Long id;
    private String descricao;
    private BigDecimal valor;

    public ProdutoDto() {

    }

    public ProdutoDto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.descricao = nome;
        this.valor = valor;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
