package com.Abarrotes.PVenta.Dao;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Producto;

public interface ProductoDAO 
{

	public List <Producto> findAll();
	public Producto findById(int id);
	public void save (Producto producto);
	public void deleteById(int id);
}
