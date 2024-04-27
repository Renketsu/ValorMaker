package br.com.ganguegangrena.valorMaker.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ganguegangrena.valorMaker.models.Publicacao;

@Repository
public interface PublicacaoDAO extends JpaRepository<Publicacao, Long> {

	List<Publicacao> findByUsuarioId(Long usuarioId);

	List<Publicacao> findByTextoContainingIgnoreCase(String texto);

	List<Publicacao> findByDataCriacaoBetween(String inicio, String fim);

}