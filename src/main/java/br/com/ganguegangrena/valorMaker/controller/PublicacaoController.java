package br.com.ganguegangrena.valorMaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ganguegangrena.valorMaker.models.Publicacao;
import br.com.ganguegangrena.valorMaker.services.PublicacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    @Autowired
    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @PostMapping("{id}/publicacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Publicacao> criarPublicacaoPorId(@PathVariable Long id ,@Valid @RequestBody Publicacao publicacao) {
        Publicacao novaPublicacao = publicacaoService.criarPublicacao(publicacao);
        return new ResponseEntity<>(novaPublicacao, HttpStatus.CREATED);
    }

    @GetMapping("/publicacoes/{id}")
    public ResponseEntity<Publicacao> recuperarPublicacaoPorId(@PathVariable Long id) {
        Publicacao publicacao = publicacaoService.recuperarPublicacaoPorId(id);
        if (publicacao != null) {
            return new ResponseEntity<>(publicacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Publicacao>> recuperarTodasPublicacoes() {
        List<Publicacao> publicacoes = publicacaoService.recuperarTodasPublicacoes();
        return new ResponseEntity<>(publicacoes, HttpStatus.OK);
    }

    @PutMapping("/publicacoes/{id}")
    public ResponseEntity<Void> atualizarPublicacao(@PathVariable Long id, @RequestBody Publicacao publicacao) {
        publicacao.setId(id);
        publicacaoService.atualizarPublicacao(publicacao);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/publicacoes/{id}")
    public ResponseEntity<Void> excluirPublicacao(@PathVariable Long id) {
        publicacaoService.excluirPublicacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}