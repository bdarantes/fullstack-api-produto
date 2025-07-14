package com.example.api_produto.dtos;

import java.math.BigDecimal;

public class ProdutoDto {
    private String descricao;
    private BigDecimal valor;

    public ProdutoDto() {

    }

    public ProdutoDto(String nome, BigDecimal valor) {
        this.descricao = nome;
        this.valor = valor;
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
