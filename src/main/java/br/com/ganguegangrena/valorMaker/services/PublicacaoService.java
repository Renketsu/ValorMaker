package br.com.ganguegangrena.valorMaker.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ganguegangrena.valorMaker.dao.PublicacaoDAO;
import br.com.ganguegangrena.valorMaker.models.Publicacao;

@Service
public class PublicacaoService {

	private static final Logger logger = LoggerFactory.getLogger(PublicacaoService.class);
	private final PublicacaoDAO publicacaoDAO;

	@Autowired
	public PublicacaoService(PublicacaoDAO publicacaoDAO) {
		this.publicacaoDAO = publicacaoDAO;
	}

	@Transactional
	public Publicacao criarPublicacao(Publicacao publicacao) {
		try {
			logger.info("Criando publicação: {}", publicacao);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			publicacao.setDataCriacao(LocalDateTime.now().format(formatter));
			Publicacao novaPublicacao = publicacaoDAO.save(publicacao);
			logger.info("Publicação criada com sucesso: {}", novaPublicacao);
			return novaPublicacao;
		} catch (DataAccessException e) {
			logger.error("Erro ao criar publicação", e);
			throw new RuntimeException("Erro ao criar publicação", e);
		}
	}

	@Transactional(readOnly = true)
	public Publicacao recuperarPublicacaoPorId(Long id) {
		try {
			logger.info("Recuperando publicação com ID {}", id);
			Publicacao publicacao = publicacaoDAO.findById(id).orElse(null);
			if (publicacao == null) {
				logger.warn("Publicação com ID {} não encontrada", id);
			}
			return publicacao;
		} catch (DataAccessException e) {
			logger.error("Erro ao recuperar publicação por ID", e);
			throw new RuntimeException("Erro ao recuperar publicação por ID", e);
		}
	}

	@Transactional(readOnly = true)
	public List<Publicacao> recuperarTodasPublicacoes() {
		try {
			logger.info("Recuperando todas as publicações");
			List<Publicacao> publicacoes = publicacaoDAO.findAll();
			logger.info("Total de {} publicações recuperadas", publicacoes.size());
			return publicacoes;
		} catch (DataAccessException e) {
			logger.error("Erro ao recuperar todas as publicações", e);
			throw new RuntimeException("Erro ao recuperar todas as publicações", e);
		}
	}

	@Transactional
	public void atualizarPublicacao(Publicacao publicacao) {
		try {
			logger.info("Atualizando publicação com ID {}: {}", publicacao.getId(), publicacao);
			if (publicacaoDAO.existsById(publicacao.getId())) {
				publicacaoDAO.save(publicacao);
				logger.info("Publicação atualizada com sucesso");
			} else {
				logger.error("Falha ao atualizar: a publicação com ID {} não existe", publicacao.getId());
				throw new IllegalArgumentException("A publicação não existe.");
			}
		} catch (DataAccessException e) {
			logger.error("Erro ao atualizar publicação", e);
			throw new RuntimeException("Erro ao atualizar publicação", e);
		}
	}

	@Transactional
	public void excluirPublicacao(Long id) {
		try {
			logger.info("Excluindo publicação com ID {}", id);
			publicacaoDAO.deleteById(id);
			logger.info("Publicação excluída com sucesso");
		} catch (DataAccessException e) {
			logger.error("Erro ao excluir publicação", e);
			throw new RuntimeException("Erro ao excluir publicação", e);
		}
	}

	@Transactional(readOnly = true)
	public List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario) {
		try {
			logger.info("Recuperando publicações do usuário com ID {}", idUsuario);
			List<Publicacao> publicacoes = publicacaoDAO.findByUsuarioId(idUsuario);
			logger.info("Total de {} publicações recuperadas do usuário com ID {}", publicacoes.size(), idUsuario);
			return publicacoes;
		} catch (DataAccessException e) {
			logger.error("Erro ao recuperar publicações do usuário", e);
			throw new RuntimeException("Erro ao recuperar publicações do usuário", e);
		}
	}

}