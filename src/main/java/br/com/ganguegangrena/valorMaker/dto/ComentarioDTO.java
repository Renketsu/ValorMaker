package br.com.ganguegangrena.valorMaker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDTO {

    private Long usuarioId;
    private String texto;


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}