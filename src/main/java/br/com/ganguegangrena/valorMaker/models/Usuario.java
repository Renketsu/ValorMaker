package br.com.ganguegangrena.valorMaker.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
public @Data class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(max = 100)
	private String nomeDeUsuario;

	@NotBlank
	@Size(min = 6)
	private String senhaHash;

	@NotBlank
	@Email
	private String email;

	private String fotoPerfilUrl;

	@NotNull
	private Date dataRegistro;

	@NotBlank
	private String localizacao;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private PerfilJogador perfilJogador;

	@ManyToMany(mappedBy = "usuariosSeguidos")
	private List<Usuario> seguidores;

	// Relacionamento para representar os usuários seguidos pelo usuário
	@ManyToMany
	@JoinTable(name = "usuarios_seguidos", joinColumns = @JoinColumn(name = "seguidor_id"), inverseJoinColumns = @JoinColumn(name = "seguido_id"))
	private List<Usuario> usuariosSeguidos;

	@OneToMany(mappedBy = "usuario")
	private List<Publicacao> publicacoes;

	
}
