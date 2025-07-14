package com.example.api_produto.controllers;

import com.example.api_produto.dtos.ProdutoDto;
import com.example.api_produto.services.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody ProdutoDto produtoDto) {
        ProdutoDto produtoSalvo = produtoService.salvar(produtoDto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>>listarTodos() {
        List<ProdutoDto> produtos = produtoService.listarTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto>buscarPorId(@PathVariable Long id) {
        ProdutoDto produtoDto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produtoDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto>atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        ProdutoDto produtoAtualizado = produtoService.atualizar(id, produtoDto);
        return produtoAtualizado != null ? new ResponseEntity<>(produtoAtualizado, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
         produtoService.deletar(id);
         return ResponseEntity.noContent().build();
    }
}
