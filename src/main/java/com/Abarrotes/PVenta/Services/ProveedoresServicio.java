package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Proveedores;

public interface ProveedoresServicio 
{
	public List<Proveedores> All();
	
	public Proveedores findById(Integer id);
	
	public void save(Proveedores proveedores);
	
	public void delete(Proveedores proveedores);
}
