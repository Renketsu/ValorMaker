package br.com.ganguegangrena.valorMaker.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class PerfilJogador {

	// Nessa classe tem que ajustar o que realmente vai ser necessario
	// po exemplo ( armaFavorita,precisaoTiros )

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idUsuario;

	@NotNull
	@DecimalMin(value = "0.0")
	@DecimalMax(value = "10.0")
	private float kdRatio;

	@NotBlank
	private String classificacaoCompetitiva;

	@NotNull
	private boolean estiloJogoAggressivo;

	@NotNull
	private boolean estiloJogoTatico;

	@Size(max = 100)
	private String armaFavorita;

	@NotNull
	@DecimalMin(value = "0.0")
	@DecimalMax(value = "100.0")
	private float precisaoTiros;

	@ElementCollection
	private List<String> horariosDisponiveis;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

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

	public PerfilJogador(int id, int idUsuario, float kdRatio, String classificacaoCompetitiva,
			boolean estiloJogoAggressivo, boolean estiloJogoTatico, String armaFavorita, float precisaoTiros,
			List<String> horariosDisponiveis, String estatisticasDetalhadas) {
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
