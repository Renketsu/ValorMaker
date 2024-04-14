package br.com.ganguegangrena.valorMaker.services;

import java.util.Date;
import java.util.List;

import br.com.ganguegangrena.valorMaker.dao.UsuarioDAO;
import br.com.ganguegangrena.valorMaker.models.Usuario;

public class UsuarioManager {

	private UsuarioDAO usuarioDAO;

	public UsuarioManager() {
		usuarioDAO = new UsuarioDAO();
	}

	public void criarUsuarioExemplo() {
		Usuario usuario = new Usuario();
		usuario.setNomeDeUsuario("se Isso aqui funcionou é GOD");
		usuario.setSenhaHash("123456");
		usuario.setEmail("dessaVezSai@temQueSair.com");
		usuario.setFotoPerfilUrl("http://twitch.tv/seraQueDaCerto");
		usuario.setDataRegistro(new Date());
		usuario.setLocalizacao("Casa do Bruno");

		usuarioDAO.criarUsuario(usuario);
	}

	public void mostrarUsuarios() {
		List<Usuario> usuarios = usuarioDAO.recuperarTodosUsuarios();
		for (Usuario u : usuarios) {
			System.out.println(u.getNomeDeUsuario());
			System.out.println(u.getEmail());
		}
	}
	
	public void teste() {
		System.out.println("executou o metodo com sucesso!");
	}
}
