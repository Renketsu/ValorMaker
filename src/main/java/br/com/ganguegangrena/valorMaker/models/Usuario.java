package br.com.ganguegangrena.valorMaker.models;

import java.util.Date;

public class Usuario {
	    private int id;
	    private String nomeDeUsuario;
	    private String senhaHash;
	    private String email;
	    private String fotoPerfilUrl;
	    private Date dataRegistro;
	    private String localizacao;
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
