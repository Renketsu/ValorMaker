package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ganguegangrena.valorMaker.dao.PerfilJogadorDAO;
import br.com.ganguegangrena.valorMaker.models.PerfilJogador;

@Service
public class PerfilJogadorService implements PerfilJogadorServiceInterface {

	 private static final Logger logger = LoggerFactory.getLogger(PerfilJogadorService.class);
	 // adicionando log bruto, refinar no futuro para ficar mais legivel
	
    private final PerfilJogadorDAO perfilJogadorDAO;

    @Autowired
    public PerfilJogadorService(PerfilJogadorDAO perfilJogadorDAO) {
        this.perfilJogadorDAO = perfilJogadorDAO;
    }

    @Override
    public void criarPerfilJogador(PerfilJogador perfilJogador) {
    	logger.info("Criando perfil de jogador: {}", perfilJogador);
        perfilJogadorDAO.save(perfilJogador);
        logger.info("Perfil de jogador criado com sucesso.");
    }

    @Override
    public void atualizarPerfilJogador(PerfilJogador perfilJogador) {
    	logger.info("Atualizando perfil de jogador com ID {}: {}", perfilJogador.getId(), perfilJogador);
        perfilJogadorDAO.save(perfilJogador);
        logger.info("Perfil de jogador atualizado com sucesso.");
    }

    @Override
    public void excluirPerfilJogador(int id) {
    	logger.info("Excluindo perfil de jogador com ID {}", id);
        perfilJogadorDAO.deleteById(id);
        logger.info("Perfil de jogador excluído com sucesso.");
    }

    @Override
    public PerfilJogador recuperarPerfilJogadorPorId(int id) {
    	logger.info("Recuperando perfil de jogador com ID {}", id);
        return perfilJogadorDAO.findById(id).orElse(null);
    }

    @Override
    public PerfilJogador recuperarPerfilPorIdUsuario(int idUsuario) {
    	logger.info("Recuperando perfil de jogador para o usuário com ID {}", idUsuario);
        return perfilJogadorDAO.findByIdUsuario(idUsuario);
    }

    @Override
    public List<PerfilJogador> recuperarTodosPerfisJogador() {
    	logger.info("Recuperando todos os perfis de jogador");
        return perfilJogadorDAO.findAll();
    }
}