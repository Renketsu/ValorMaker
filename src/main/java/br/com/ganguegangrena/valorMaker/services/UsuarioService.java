package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ganguegangrena.valorMaker.dao.UsuarioDAO;
import br.com.ganguegangrena.valorMaker.models.Usuario;

@Service
public class UsuarioService implements UsuarioServiceInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public void criarUsuario(Usuario usuario) {
    	logger.info("Criando usuário: {}", usuario);
        usuarioDAO.save(usuario);
        logger.info("Usuário criado com sucesso.");
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
    	logger.info("Atualizando usuário com ID {}: {}", usuario.getId(), usuario);
        usuarioDAO.save(usuario);
        logger.info("Usuário atualizado com sucesso.");
    }

    @Override
    public void excluirUsuario(int id) {
    	logger.info("Excluindo usuário com ID {}", id);
        usuarioDAO.deleteById(id);
        logger.info("Usuário excluído com sucesso.");
    }

    @Override
    public Usuario recuperarUsuarioPorId(int id) {
    	logger.info("Recuperando usuário com ID {}", id);
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> recuperarTodosUsuarios() {
    	logger.info("Recuperando todos os usuários");
        return usuarioDAO.findAll();
    }
}