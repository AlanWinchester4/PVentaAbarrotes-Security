package com.Abarrotes.PVenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Abarrotes.PVenta.Beans.Producto;

public abstract interface ProductoRepository extends JpaRepository<Producto, Integer>
{

}
