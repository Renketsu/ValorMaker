package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ganguegangrena.valorMaker.dao.UsuarioDAO;
import br.com.ganguegangrena.valorMaker.models.Publicacao;
import br.com.ganguegangrena.valorMaker.models.Usuario;

@Service
public class UsuarioService implements UsuarioServiceInterface {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	private final UsuarioDAO usuarioDAO;

	private final PublicacaoService publicacaoService;

	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO, @Autowired(required = false) PublicacaoService publicacaoService) {
		this.usuarioDAO = usuarioDAO;
		this.publicacaoService = publicacaoService;
	}

	@Transactional
	public void criarUsuario(Usuario usuario) {
		try {
			logger.info("Criando usuário: {}", usuario);
			usuarioDAO.save(usuario);
			logger.info("Usuário criado com sucesso.");
		} catch (DataAccessException e) {
			logger.error("Erro ao criar usuário", e);
			throw new RuntimeException("Erro ao criar usuário", e);
		}
	}

	@Transactional
	public void atualizarUsuario(Usuario usuario) {
		try {
			logger.info("Atualizando usuário com ID {}: {}", usuario.getId(), usuario);
			usuarioDAO.save(usuario);
			logger.info("Usuário atualizado com sucesso.");
		} catch (DataAccessException e) {
			logger.error("Erro ao atualizar usuário", e);
			throw new RuntimeException("Erro ao atualizar usuário", e);
		}
	}

	@Transactional
	public void excluirUsuario(int id) {
		try {
			logger.info("Excluindo usuário com ID {}", id);
			usuarioDAO.deleteById(id);
			logger.info("Usuário excluído com sucesso.");
		} catch (DataAccessException e) {
			logger.error("Erro ao excluir usuário", e);
			throw new RuntimeException("Erro ao excluir usuário", e);
		}
	}

	@Transactional(readOnly = true)
	public Usuario recuperarUsuarioPorId(int id) {
		try {
			logger.info("Recuperando usuário com ID {}", id);
			return usuarioDAO.findById(id).orElse(null);
		} catch (DataAccessException e) {
			logger.error("Erro ao recuperar usuário por ID", e);
			throw new RuntimeException("Erro ao recuperar usuário por ID", e);
		}
	}

	@Transactional(readOnly = true)
	public List<Usuario> recuperarTodosUsuarios() {
		try {
			logger.info("Recuperando todos os usuários");
			return usuarioDAO.findAll();
		} catch (DataAccessException e) {
			logger.error("Erro ao recuperar todos os usuários", e);
			throw new RuntimeException("Erro ao recuperar todos os usuários", e);
		}
	}

	// Métodos para publicação

	public void seguirUsuario(Long idSeguidor, Long idSeguido) {
		// Implementação para seguir um usuário
	}

	public void deixarDeSeguirUsuario(Long idSeguidor, Long idSeguido) {
		// Implementação para deixar de seguir um usuário
	}

	public List<Usuario> recuperarSeguidores(Long idUsuario) {
		return usuarioDAO.recuperarSeguidores(idUsuario);
	}

	public List<Usuario> recuperarUsuariosSeguidos(Long idUsuario) {
		return usuarioDAO.recuperarUsuariosSeguidos(idUsuario);
	}

	public List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario) {
		return publicacaoService.recuperarPublicacoesDoUsuario(idUsuario);
	}

}