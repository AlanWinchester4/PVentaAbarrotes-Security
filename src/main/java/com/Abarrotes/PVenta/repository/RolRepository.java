package com.Abarrotes.PVenta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Abarrotes.PVenta.Beans.Rol;
import com.Abarrotes.PVenta.Beans.Usuario;

public abstract interface RolRepository extends JpaRepository <Rol,Integer>
{
	@Query("SELECT r FROM Rol r WHERE r.nom_rol Like %?1%")
	public List<Rol> findAll(String nom_user);
}
