package br.com.ganguegangrena.valorMaker.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ganguegangrena.valorMaker.dto.PublicacaoDTO;
import br.com.ganguegangrena.valorMaker.models.Publicacao;
import br.com.ganguegangrena.valorMaker.models.Usuario;
import br.com.ganguegangrena.valorMaker.services.PublicacaoService;
import br.com.ganguegangrena.valorMaker.services.UsuarioService;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

	private final PublicacaoService publicacaoService;
	private final UsuarioService usuarioService;

	@Autowired
	public PublicacaoController(PublicacaoService publicacaoService, UsuarioService usuarioService) {
		this.publicacaoService = publicacaoService;
		this.usuarioService = usuarioService;
	}

	@PostMapping("/api/publicacoes")
	public ResponseEntity<Publicacao> criarPublicacao(@RequestBody PublicacaoDTO publicacaoDTO) {
		Usuario usuario = usuarioService.recuperarUsuarioPorId(publicacaoDTO.getIdUsuario());
		if (usuario == null) {
			return ResponseEntity.badRequest().body(null);
		}

		Publicacao publicacao = new Publicacao();
		publicacao.setTexto(publicacaoDTO.getTexto());
		publicacao.setImagem(publicacaoDTO.getImagem());
		publicacao.setVideoUrl(publicacaoDTO.getVideoUrl());
		publicacao.setLinkUrl(publicacaoDTO.getLinkUrl());
		publicacao.setUsuario(usuario);
		publicacao.setDataCriacao(LocalDateTime.now());

		Publicacao novaPublicacao = publicacaoService.criarPublicacao(publicacao);
		return new ResponseEntity<>(novaPublicacao, HttpStatus.CREATED);
	}



	@GetMapping("/api/publicacoes/{id}")
	public ResponseEntity<Publicacao> recuperarPublicacaoPorId(@PathVariable Long id) {
		Publicacao publicacao = publicacaoService.recuperarPublicacaoPorId(id);
		if (publicacao != null) {
			return new ResponseEntity<>(publicacao, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<Publicacao>> recuperarTodasPublicacoes() {
		List<Publicacao> publicacoes = publicacaoService.recuperarTodasPublicacoes();
		return new ResponseEntity<>(publicacoes, HttpStatus.OK);
	}

	@PutMapping("/api/publicacoes/{id}")
	public ResponseEntity<Void> atualizarPublicacao(@PathVariable Long id, @RequestBody Publicacao publicacao) {
		publicacao.setId(id);
		publicacaoService.atualizarPublicacao(publicacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/api/publicacoes/{id}")
	public ResponseEntity<Void> excluirPublicacao(@PathVariable Long id) {
		publicacaoService.excluirPublicacao(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}