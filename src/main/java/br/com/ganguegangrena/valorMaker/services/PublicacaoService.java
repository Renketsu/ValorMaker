package br.com.ganguegangrena.valorMaker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ganguegangrena.valorMaker.dao.PublicacaoDAO;
import br.com.ganguegangrena.valorMaker.models.Publicacao;

@Service
public class PublicacaoService {

    private final PublicacaoDAO publicacaoDAO;
    
    @Autowired
    public PublicacaoService(PublicacaoDAO publicacaoDAO) {
        this.publicacaoDAO = publicacaoDAO;
    }

    public Publicacao criarPublicacao(Publicacao publicacao) {
        publicacao.setDataCriacao(LocalDateTime.now());
        return publicacaoDAO.save(publicacao);
    }

    public Publicacao recuperarPublicacaoPorId(Long id) {
        return publicacaoDAO.findById(id).orElse(null);
    }

    public List<Publicacao> recuperarTodasPublicacoes() {
        return publicacaoDAO.findAll();
    }

    public void atualizarPublicacao(Publicacao publicacao) {
        if (publicacaoDAO.existsById(publicacao.getId())) {
            publicacaoDAO.save(publicacao);
        } else {
            throw new IllegalArgumentException("A publicação não existe.");
        }
    }

    public void excluirPublicacao(Long id) {
        publicacaoDAO.deleteById(id);
    }
    
    // Método para recuperar as publicações de um usuário
    
    public List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario) {
        return publicacaoDAO.findByUsuarioId(idUsuario);
    }
    
}