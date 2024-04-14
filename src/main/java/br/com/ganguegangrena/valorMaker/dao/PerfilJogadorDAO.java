package br.com.ganguegangrena.valorMaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ganguegangrena.valorMaker.models.PerfilJogador;

@Repository
public interface  PerfilJogadorDAO extends JpaRepository<PerfilJogador, Integer> {
    List<PerfilJogador> findByEstiloJogoAggressivo(boolean estiloJogoAggressivo);
    List<PerfilJogador> findByClassificacaoCompetitiva(String classificacaoCompetitiva);
    PerfilJogador findByIdUsuario(int idUsuario);
}

