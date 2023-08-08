package com.Abarrotes.PVenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Abarrotes.PVenta.Beans.Proveedor;

public abstract interface ProveedorRepository extends JpaRepository<Proveedor, Integer>
{

}
