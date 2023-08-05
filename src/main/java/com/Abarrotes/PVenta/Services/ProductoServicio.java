package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Producto;

public interface ProductoServicio 
{
	public List<Producto> All();
	
	public Producto findById(Integer id);
	
	public void save(Producto producto);
	
	public void delete(Producto producto);
	
}
