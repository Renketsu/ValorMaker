package br.com.ganguegangrena.valorMaker.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ganguegangrena.valorMaker.models.Usuario;

public class UsuarioDAO {
	
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }


    public void criarUsuario(Usuario usuario) {
    	 usuarios.add(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
    	 for (Usuario u : usuarios) {
             if (u.getId() == usuario.getId()) {
                 u.setNomeDeUsuario(usuario.getNomeDeUsuario());
                 u.setSenhaHash(usuario.getSenhaHash());
                 u.setEmail(usuario.getEmail());
                 u.setFotoPerfilUrl(usuario.getFotoPerfilUrl());
                 u.setDataRegistro(usuario.getDataRegistro());
                 u.setLocalizacao(usuario.getLocalizacao());
                 break;
             }
         }
     }

    public void excluirUsuario(int id) {
    	usuarios.removeIf(u -> u.getId() == id);
    }

    public Usuario recuperarUsuarioPorId(int id) {
    	for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> recuperarTodosUsuarios() {
    	return new ArrayList<>(usuarios);
    }
}

