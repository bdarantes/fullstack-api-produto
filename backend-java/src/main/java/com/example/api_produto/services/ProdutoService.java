package com.example.api_produto.services;

import com.example.api_produto.dtos.ProdutoDto;
import com.example.api_produto.entities.Produto;
import com.example.api_produto.mappers.ProdutoMapper;
import com.example.api_produto.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoDto salvar (ProdutoDto produtoDto) {
        Produto produto = produtoMapper.toEntity(produtoDto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoMapper.toDto(produtoSalvo);
    }

    public List<ProdutoDto> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProdutoDto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .map(produtoMapper::toDto)
                .orElseThrow(()->new RuntimeException("Produto não encontrado"));

    }

    public ProdutoDto atualizar(Long id, ProdutoDto dto) {
        Produto produtoAtualizado = produtoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Produto não encontrado"));
        produtoAtualizado.setDescricao(dto.getDescricao());
        produtoAtualizado.setValor(dto.getValor());
        Produto atualizado = produtoRepository.save(produtoAtualizado);
        return produtoMapper.toDto(atualizado);

    }


    public void deletar(Long id) {
        if(!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
