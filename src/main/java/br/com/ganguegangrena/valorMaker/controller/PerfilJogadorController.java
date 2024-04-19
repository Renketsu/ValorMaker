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
import org.springframework.web.bind.annotation.RestController;

import br.com.ganguegangrena.valorMaker.models.PerfilJogador;
import br.com.ganguegangrena.valorMaker.services.PerfilJogadorService;

@RestController
@RequestMapping("/api/perfisjogador")
public class PerfilJogadorController {

    private final PerfilJogadorService perfilJogadorService;

    @Autowired
    public PerfilJogadorController(PerfilJogadorService perfilJogadorService) {
        this.perfilJogadorService = perfilJogadorService;
    }

    @PostMapping
    public ResponseEntity<PerfilJogador> criarPerfilJogador(@RequestBody PerfilJogador perfilJogador) {
        perfilJogadorService.criarPerfilJogador(perfilJogador);
        return new ResponseEntity<>(perfilJogador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilJogador> atualizarPerfilJogador(@PathVariable int id, @RequestBody PerfilJogador perfilJogador) {
        perfilJogador.setId(id);
        perfilJogadorService.atualizarPerfilJogador(perfilJogador);
        return ResponseEntity.ok(perfilJogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPerfilJogador(@PathVariable int id) {
        perfilJogadorService.excluirPerfilJogador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilJogador> recuperarPerfilJogadorPorId(@PathVariable int id) {
        PerfilJogador perfilJogador = perfilJogadorService.recuperarPerfilJogadorPorId(id);
        return ResponseEntity.ok(perfilJogador);
    }

    @GetMapping
    public ResponseEntity<List<PerfilJogador>> recuperarTodosPerfisJogador() {
        List<PerfilJogador> perfisJogador = perfilJogadorService.recuperarTodosPerfisJogador();
        return ResponseEntity.ok(perfisJogador);
    }

}