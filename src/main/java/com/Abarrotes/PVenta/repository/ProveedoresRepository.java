package com.Abarrotes.PVenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Abarrotes.PVenta.Beans.Proveedores;

public abstract interface ProveedoresRepository extends JpaRepository<Proveedores, Integer>
{

}
