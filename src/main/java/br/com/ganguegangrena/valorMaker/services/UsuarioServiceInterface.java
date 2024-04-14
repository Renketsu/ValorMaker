package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import br.com.ganguegangrena.valorMaker.models.Usuario;

public interface UsuarioServiceInterface {
    void criarUsuario(Usuario usuario);
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(int id);
    Usuario recuperarUsuarioPorId(int id);
    List<Usuario> recuperarTodosUsuarios();
}