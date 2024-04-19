package br.com.ganguegangrena.valorMaker.services;

import java.util.List;

import br.com.ganguegangrena.valorMaker.models.PerfilJogador;
import br.com.ganguegangrena.valorMaker.models.Publicacao;

public interface PerfilJogadorServiceInterface {
    void criarPerfilJogador(PerfilJogador perfilJogador);
    void atualizarPerfilJogador(PerfilJogador perfilJogador);
    void excluirPerfilJogador(int id);
    PerfilJogador recuperarPerfilJogadorPorId(int id);
    PerfilJogador recuperarPerfilPorIdUsuario(int idUsuario);
    List<PerfilJogador> recuperarTodosPerfisJogador();
    
    List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario);
}