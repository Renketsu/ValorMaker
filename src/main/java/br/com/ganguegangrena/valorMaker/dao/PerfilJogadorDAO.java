package br.com.ganguegangrena.valorMaker.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ganguegangrena.valorMaker.models.PerfilJogador;

public class PerfilJogadorDAO {

	//ainda náo configurado para o banco
	
	private List<PerfilJogador> perfisJogador;

	public PerfilJogadorDAO() {
		perfisJogador = new ArrayList<>();
	}

	public void criarPerfilJogador(PerfilJogador perfilJogador) {
		perfisJogador.add(perfilJogador);
	}

	public void atualizarPerfilJogador(PerfilJogador perfilJogador) {
		for (PerfilJogador pj : perfisJogador) {
			if (pj.getId() == perfilJogador.getId()) {
				pj.setKdRatio(perfilJogador.getKdRatio());
				pj.setClassificacaoCompetitiva(perfilJogador.getClassificacaoCompetitiva());
				pj.setEstiloJogoAggressivo(perfilJogador.isEstiloJogoAggressivo());
				pj.setEstiloJogoTatico(perfilJogador.isEstiloJogoTatico());
				pj.setArmaFavorita(perfilJogador.getArmaFavorita());
				pj.setPrecisaoTiros(perfilJogador.getPrecisaoTiros());
				pj.setHorariosDisponiveis(perfilJogador.getHorariosDisponiveis());
				pj.setEstatisticasDetalhadas(perfilJogador.getEstatisticasDetalhadas());
				break;
			}
		}
	}

	public void excluirPerfilJogador(int id) {
		perfisJogador.removeIf(pj -> pj.getId() == id);
		}

	public PerfilJogador recuperarPerfilJogadorPorId(int id) {
		 for (PerfilJogador pj : perfisJogador) {
	            if (pj.getId() == id) {
	                return pj;
	            }
	        }
	        return null;
	    }

	public PerfilJogador recuperarPerfilPorIdUsuario(int idUsuario) {
        for (PerfilJogador pj : perfisJogador) {
            if (pj.getIdUsuario() == idUsuario) {
                return pj;
            }
        }
        return null;
    }

}
