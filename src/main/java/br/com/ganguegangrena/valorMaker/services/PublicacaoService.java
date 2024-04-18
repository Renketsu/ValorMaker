package br.com.ganguegangrena.valorMaker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Publicacao criarPublicacao(Publicacao publicacao) {
		logger.info("Criando publicação: {}", publicacao);
		publicacao.setDataCriacao(LocalDateTime.now());
		Publicacao novaPublicacao = publicacaoDAO.save(publicacao);
		logger.info("Publicação criada com sucesso: {}", novaPublicacao);
		return novaPublicacao;
	}

	public Publicacao recuperarPublicacaoPorId(Long id) {
		logger.info("Recuperando publicação com ID {}", id);
		Publicacao publicacao = publicacaoDAO.findById(id).orElse(null);
		if (publicacao == null) {
			logger.warn("Publicação com ID {} não encontrada", id);
		}
		return publicacao;
	}

	public List<Publicacao> recuperarTodasPublicacoes() {
		logger.info("Recuperando todas as publicações");
		List<Publicacao> publicacoes = publicacaoDAO.findAll();
		logger.info("Total de {} publicações recuperadas", publicacoes.size());
		return publicacoes;
	}

	public void atualizarPublicacao(Publicacao publicacao) {
		logger.info("Atualizando publicação com ID {}: {}", publicacao.getId(), publicacao);
		if (publicacaoDAO.existsById(publicacao.getId())) {
			publicacaoDAO.save(publicacao);
			logger.info("Publicação atualizada com sucesso");
		} else {
			logger.error("Falha ao atualizar: a publicação com ID {} não existe", publicacao.getId());
			throw new IllegalArgumentException("A publicação não existe.");
		}
	}

	public void excluirPublicacao(Long id) {
		logger.info("Excluindo publicação com ID {}", id);
		publicacaoDAO.deleteById(id);
		logger.info("Publicação excluída com sucesso");
	}

	// Método para recuperar as publicações de um usuário

	public List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario) {
		logger.info("Recuperando publicações do usuário com ID {}", idUsuario);
		List<Publicacao> publicacoes = publicacaoDAO.findByUsuarioId(idUsuario);
		logger.info("Total de {} publicações recuperadas do usuário com ID {}", publicacoes.size(), idUsuario);
		return publicacoes;
	}

}