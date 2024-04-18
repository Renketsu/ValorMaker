package br.com.ganguegangrena.valorMaker.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
public @Data class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JsonIgnore
    private Usuario usuario;
    
    

    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    
    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public void adicionarComentario(Comentario comentario) {
        comentario.setPublicacao(this); 
        comentarios.add(comentario);   
    }


}