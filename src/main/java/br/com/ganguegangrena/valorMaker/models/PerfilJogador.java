package br.com.ganguegangrena.valorMaker.models;

import java.util.List;

public class PerfilJogador {

	private int id;
	private int idUsuario;
	private float kdRatio;
	private String classificacaoCompetitiva;
	private boolean estiloJogoAggressivo;
	private boolean estiloJogoTatico;
	private String armaFavorita;
	private float precisaoTiros;
	private List<String> horariosDisponiveis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public float getKdRatio() {
		return kdRatio;
	}

	public void setKdRatio(float kdRatio) {
		this.kdRatio = kdRatio;
	}

	public String getClassificacaoCompetitiva() {
		return classificacaoCompetitiva;
	}

	public void setClassificacaoCompetitiva(String classificacaoCompetitiva) {
		this.classificacaoCompetitiva = classificacaoCompetitiva;
	}

	public boolean isEstiloJogoAggressivo() {
		return estiloJogoAggressivo;
	}

	public void setEstiloJogoAggressivo(boolean estiloJogoAggressivo) {
		this.estiloJogoAggressivo = estiloJogoAggressivo;
	}

	public boolean isEstiloJogoTatico() {
		return estiloJogoTatico;
	}

	public void setEstiloJogoTatico(boolean estiloJogoTatico) {
		this.estiloJogoTatico = estiloJogoTatico;
	}

	public String getArmaFavorita() {
		return armaFavorita;
	}

	public void setArmaFavorita(String armaFavorita) {
		this.armaFavorita = armaFavorita;
	}

	public float getPrecisaoTiros() {
		return precisaoTiros;
	}

	public void setPrecisaoTiros(float precisaoTiros) {
		this.precisaoTiros = precisaoTiros;
	}

	public List<String> getHorariosDisponiveis() {
		return horariosDisponiveis;
	}

	public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
		this.horariosDisponiveis = horariosDisponiveis;
	}

	public String getEstatisticasDetalhadas() {
		return estatisticasDetalhadas;
	}

	public void setEstatisticasDetalhadas(String estatisticasDetalhadas) {
		this.estatisticasDetalhadas = estatisticasDetalhadas;
	}

	private String estatisticasDetalhadas;

	public PerfilJogador(int id, int idUsuario, float kdRatio, String classificacaoCompetitiva, boolean estiloJogoAggressivo,
			boolean estiloJogoTatico, String armaFavorita, float precisaoTiros, List<String> horariosDisponiveis,
			String estatisticasDetalhadas) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.kdRatio = kdRatio;
		this.classificacaoCompetitiva = classificacaoCompetitiva;
		this.estiloJogoAggressivo = estiloJogoAggressivo;
		this.estiloJogoTatico = estiloJogoTatico;
		this.armaFavorita = armaFavorita;
		this.precisaoTiros = precisaoTiros;
		this.horariosDisponiveis = horariosDisponiveis;
		this.estatisticasDetalhadas = estatisticasDetalhadas;
	}
	
	@Override
	public String toString() {
		return "PerfilJogador [id=" + id + ", idUsuario=" + idUsuario + ", kdRatio=" + kdRatio
				+ ", classificacaoCompetitiva=" + classificacaoCompetitiva + ", estiloJogoAggressivo="
				+ estiloJogoAggressivo + ", estiloJogoTatico=" + estiloJogoTatico + ", armaFavorita=" + armaFavorita
				+ ", precisaoTiros=" + precisaoTiros + ", horariosDisponiveis=" + horariosDisponiveis
				+ ", estatisticasDetalhadas=" + estatisticasDetalhadas + ", getId()=" + getId() + ", getIdUsuario()="
				+ getIdUsuario() + ", getKdRatio()=" + getKdRatio() + ", getClassificacaoCompetitiva()="
				+ getClassificacaoCompetitiva() + ", isEstiloJogoAggressivo()=" + isEstiloJogoAggressivo()
				+ ", isEstiloJogoTatico()=" + isEstiloJogoTatico() + ", getArmaFavorita()=" + getArmaFavorita()
				+ ", getPrecisaoTiros()=" + getPrecisaoTiros() + ", getHorariosDisponiveis()="
				+ getHorariosDisponiveis() + ", getEstatisticasDetalhadas()=" + getEstatisticasDetalhadas()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
