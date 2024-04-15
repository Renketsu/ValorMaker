package br.com.ganguegangrena.valorMaker.models;

import java.util.Date;
import java.util.List;

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

@Entity
public class Usuario {
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
	private PerfilJogador perfilJogador;

	@ManyToMany(mappedBy = "usuariosSeguidos")
	private List<Usuario> seguidores;

	// Relacionamento para representar os usuários seguidos pelo usuário
	@ManyToMany
	@JoinTable(name = "usuarios_seguidos", joinColumns = @JoinColumn(name = "seguidor_id"), inverseJoinColumns = @JoinColumn(name = "seguido_id"))
	private List<Usuario> usuariosSeguidos;

	@OneToMany(mappedBy = "usuario")
	private List<Publicacao> publicacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFotoPerfilUrl() {
		return fotoPerfilUrl;
	}

	public void setFotoPerfilUrl(String fotoPerfilUrl) {
		this.fotoPerfilUrl = fotoPerfilUrl;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public PerfilJogador getPerfilJogador() {
		return perfilJogador;
	}

	public void setPerfilJogador(PerfilJogador perfilJogador) {
		this.perfilJogador = perfilJogador;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public List<Usuario> getUsuariosSeguidos() {
		return usuariosSeguidos;
	}

	public void setUsuariosSeguidos(List<Usuario> usuariosSeguidos) {
		this.usuariosSeguidos = usuariosSeguidos;
	}

	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

	public Usuario(int id, @NotBlank @Size(max = 100) String nomeDeUsuario, @NotBlank @Size(min = 6) String senhaHash,
			@NotBlank @Email String email, String fotoPerfilUrl, @NotNull Date dataRegistro,
			@NotBlank String localizacao, PerfilJogador perfilJogador, List<Usuario> seguidores,
			List<Usuario> usuariosSeguidos, List<Publicacao> publicacoes) {
		super();
		this.id = id;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senhaHash = senhaHash;
		this.email = email;
		this.fotoPerfilUrl = fotoPerfilUrl;
		this.dataRegistro = dataRegistro;
		this.localizacao = localizacao;
		this.perfilJogador = perfilJogador;
		this.seguidores = seguidores;
		this.usuariosSeguidos = usuariosSeguidos;
		this.publicacoes = publicacoes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeDeUsuario=" + nomeDeUsuario + ", senhaHash=" + senhaHash + ", email="
				+ email + ", fotoPerfilUrl=" + fotoPerfilUrl + ", dataRegistro=" + dataRegistro + ", localizacao="
				+ localizacao + ", perfilJogador=" + perfilJogador + ", seguidores=" + seguidores
				+ ", usuariosSeguidos=" + usuariosSeguidos + ", publicacoes=" + publicacoes + "]";
	}

}
