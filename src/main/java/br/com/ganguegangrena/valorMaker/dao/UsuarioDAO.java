package br.com.ganguegangrena.valorMaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ganguegangrena.valorMaker.models.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    Usuario findByNomeDeUsuario(String nomeDeUsuario);
    Usuario findByEmail(String email);
    List<Usuario> findByLocalizacao(String localizacao);
}
