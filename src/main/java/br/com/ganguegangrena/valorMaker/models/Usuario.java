package br.com.ganguegangrena.valorMaker.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Usuario() {

	}

	public Usuario(int id, String nomeDeUsuario, String senhaHash, String email, String fotoPerfilUrl,
			Date dataRegistro, String localizacao) {
		super();
		this.id = id;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senhaHash = senhaHash;
		this.email = email;
		this.fotoPerfilUrl = fotoPerfilUrl;
		this.dataRegistro = dataRegistro;
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeDeUsuario=" + nomeDeUsuario + ", senhaHash=" + senhaHash + ", email="
				+ email + ", fotoPerfilUrl=" + fotoPerfilUrl + ", dataRegistro=" + dataRegistro + ", localizacao="
				+ localizacao + ", getId()=" + getId() + ", getNomeDeUsuario()=" + getNomeDeUsuario()
				+ ", getSenhaHash()=" + getSenhaHash() + ", getEmail()=" + getEmail() + ", getFotoPerfilUrl()="
				+ getFotoPerfilUrl() + ", getDataRegistro()=" + getDataRegistro() + ", getLocalizacao()="
				+ getLocalizacao() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
