package com.Abarrotes.PVenta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Abarrotes.PVenta.Beans.Usuario;

public abstract interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
	@Query("SELECT u FROM Usuario u WHERE u.nom_user Like %?1%")
	public List<Usuario> findAll(String nom_user);
	@Query("SELECT u FROM Usuario u WHERE u.nom_user Like %?1%")
	public Usuario findByNom(String nom_user);
}
