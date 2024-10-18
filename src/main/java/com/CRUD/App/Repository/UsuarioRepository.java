package com.CRUD.App.Repository;

import com.CRUD.App.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.password = ?2 AND u.apiKey = ?3")
    Usuario findByUsernameAndPasswordAndApiKey(String username, String password, String apiKey);
}
