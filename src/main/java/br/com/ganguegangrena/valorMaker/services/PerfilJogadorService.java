package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ganguegangrena.valorMaker.dao.PerfilJogadorDAO;
import br.com.ganguegangrena.valorMaker.models.PerfilJogador;
import br.com.ganguegangrena.valorMaker.models.Publicacao;

@Service
public class PerfilJogadorService implements PerfilJogadorServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(PerfilJogadorService.class);
    
    private final PerfilJogadorDAO perfilJogadorDAO;
    
    private final PublicacaoService publicacaoService;

    @Autowired
    public PerfilJogadorService(PerfilJogadorDAO perfilJogadorDAO, PublicacaoService publicacaoService) {
        this.perfilJogadorDAO = perfilJogadorDAO;
        this.publicacaoService = publicacaoService;
    }

    @Override
    @Transactional
    public void criarPerfilJogador(PerfilJogador perfilJogador) {
        try {
            logger.info("Criando perfil de jogador: {}", perfilJogador);
            perfilJogadorDAO.save(perfilJogador);
            logger.info("Perfil de jogador criado com sucesso.");
        } catch (DataAccessException e) {
            logger.error("Erro ao criar perfil de jogador", e);
            throw new RuntimeException("Erro ao criar perfil de jogador", e);
        }
    }

    @Override
    @Transactional
    public void atualizarPerfilJogador(PerfilJogador perfilJogador) {
        try {
            logger.info("Atualizando perfil de jogador com ID {}: {}", perfilJogador.getId(), perfilJogador);
            perfilJogadorDAO.save(perfilJogador);
            logger.info("Perfil de jogador atualizado com sucesso.");
        } catch (DataAccessException e) {
            logger.error("Erro ao atualizar perfil de jogador", e);
            throw new RuntimeException("Erro ao atualizar perfil de jogador", e);
        }
    }

    @Override
    @Transactional
    public void excluirPerfilJogador(int id) {
        try {
            logger.info("Excluindo perfil de jogador com ID {}", id);
            perfilJogadorDAO.deleteById(id);
            logger.info("Perfil de jogador excluído com sucesso.");
        } catch (DataAccessException e) {
            logger.error("Erro ao excluir perfil de jogador", e);
            throw new RuntimeException("Erro ao excluir perfil de jogador", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PerfilJogador recuperarPerfilJogadorPorId(int id) {
        try {
            logger.info("Recuperando perfil de jogador com ID {}", id);
            return perfilJogadorDAO.findById(id).orElse(null);
        } catch (DataAccessException e) {
            logger.error("Erro ao recuperar perfil de jogador por ID", e);
            throw new RuntimeException("Erro ao recuperar perfil de jogador por ID", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PerfilJogador recuperarPerfilPorIdUsuario(int idUsuario) {
        try {
            logger.info("Recuperando perfil de jogador para o usuário com ID {}", idUsuario);
            return perfilJogadorDAO.findByIdUsuario(idUsuario);
        } catch (DataAccessException e) {
            logger.error("Erro ao recuperar perfil de jogador por ID de usuário", e);
            throw new RuntimeException("Erro ao recuperar perfil de jogador por ID de usuário", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PerfilJogador> recuperarTodosPerfisJogador() {
        try {
            logger.info("Recuperando todos os perfis de jogador");
            return perfilJogadorDAO.findAll();
        } catch (DataAccessException e) {
            logger.error("Erro ao recuperar todos os perfis de jogador", e);
            throw new RuntimeException("Erro ao recuperar todos os perfis de jogador", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario) {
        try {
            return publicacaoService.recuperarPublicacoesDoUsuario(idUsuario);
        } catch (DataAccessException e) {
            logger.error("Erro ao recuperar publicações do usuário", e);
            throw new RuntimeException("Erro ao recuperar publicações do usuário", e);
        }
    }
    
}