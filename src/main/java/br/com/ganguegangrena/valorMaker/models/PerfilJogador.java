package br.com.ganguegangrena.valorMaker.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public @Data class PerfilJogador {

	// Nessa classe tem que ajustar o que realmente vai ser necessario
	// po exemplo ( armaFavorita,precisaoTiros )
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter int id;
	
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
	@JsonIgnore
	private Usuario usuario;

	
}
