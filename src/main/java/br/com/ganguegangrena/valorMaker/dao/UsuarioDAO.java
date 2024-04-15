package br.com.ganguegangrena.valorMaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ganguegangrena.valorMaker.models.Publicacao;
import br.com.ganguegangrena.valorMaker.models.Usuario;
import jakarta.persistence.PersistenceContext;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	@PersistenceContext

	Usuario findByNomeDeUsuario(String nomeDeUsuario);

	Usuario findByEmail(String email);

	List<Usuario> findByLocalizacao(String localizacao);

	// Método para recuperar os seguidores de um usuário

	List<Usuario> findBySeguidoresId(Long idUsuario);

	@Query("SELECT u FROM Usuario u JOIN u.usuariosSeguidos us WHERE us.id = :idUsuario")
	List<Usuario> findByUsuariosSeguidos(long idUsuario);

	@Query("SELECT u.seguidores FROM Usuario u WHERE u.id = :idUsuario")
	List<Usuario> recuperarSeguidores(Long idUsuario);
	
	@Query("SELECT u.usuariosSeguidos FROM Usuario u WHERE u.id = :idUsuario")
	List<Usuario> recuperarUsuariosSeguidos(Long idUsuario);
	
	//Metodo ppara recupperar publicacao
	@Query("SELECT u.publicacoes FROM Usuario u WHERE u.id = :idUsuario")
	List<Publicacao> recuperarPublicacoesDoUsuario(Long idUsuario);

}
