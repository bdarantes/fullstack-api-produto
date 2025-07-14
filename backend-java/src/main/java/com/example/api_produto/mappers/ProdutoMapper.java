package com.example.api_produto.mappers;

import com.example.api_produto.dtos.ProdutoDto;
import com.example.api_produto.entities.Produto;


public class ProdutoMapper {

    public ProdutoDto toDto(Produto produto) {
        if(produto ==null) {
            return null;
        }
        ProdutoDto dto = new ProdutoDto();
        dto.setDescricao(produto.getDescricao());
        dto.setValor(produto.getValor());
        return dto;

    }

    public Produto toEntity(ProdutoDto produtoDto) {
        if(produtoDto ==null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setDescricao(produtoDto.getDescricao());
        produto.setValor(produtoDto.getValor());
        return produto;
    }
}
