package br.com.ganguegangrena.valorMaker.models;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;


@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Id id;
    

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "link_url")
    private String linkUrl;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    
    
	public Id getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Publicacao() {
		
	}
	
	public Publicacao(Long id, String texto, byte[] imagem, String videoUrl, String linkUrl, Usuario usuario,
			LocalDateTime dataCriacao) {
		super();
		
		this.texto = texto;
		this.imagem = imagem;
		this.videoUrl = videoUrl;
		this.linkUrl = linkUrl;
		this.usuario = usuario;
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Publicacao [id=" + id + ", texto=" + texto + ", imagem=" + Arrays.toString(imagem) + ", videoUrl="
				+ videoUrl + ", linkUrl=" + linkUrl + ", usuario=" + usuario + ", dataCriacao=" + dataCriacao + "]";
	}

	
    
    

}