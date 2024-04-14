package br.com.ganguegangrena.valorMaker.services;

import org.springframework.stereotype.Component;

import br.com.ganguegangrena.valorMaker.repositories.Testando;

@Component
public class Application implements Testando {

	public void run() {
		UsuarioManager usuarioManager = new UsuarioManager();
		usuarioManager.criarUsuarioExemplo();
		usuarioManager.mostrarUsuarios();
		usuarioManager.teste();
	}


}
