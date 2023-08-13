package com.Abarrotes.PVenta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Abarrotes.PVenta.Beans.Producto;

public abstract interface ProductoRepository extends JpaRepository<Producto, Integer>
{
	@Query("SELECT p FROM Producto p WHERE p.nom_Prod Like %?1%")
	public List<Producto> findAll(String nom_Prod);
}
