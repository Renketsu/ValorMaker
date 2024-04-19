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

import br.com.ganguegangrena.valorMaker.models.Usuario;
import br.com.ganguegangrena.valorMaker.services.UsuarioServiceInterface;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceInterface usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceInterface usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable int id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> recuperarUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> recuperarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.recuperarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}