package com.api.paralelus.repository;

import com.api.paralelus.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

   UserDetails findByLogin(String login);

   UserDetails findByEmail(String email);

   UserDetails findByNome(String nome);
}
