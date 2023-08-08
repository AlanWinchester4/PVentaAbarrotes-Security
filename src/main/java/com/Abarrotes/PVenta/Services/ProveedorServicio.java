package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Proveedor;

public interface ProveedorServicio 
{
	public List<Proveedor> All();
	
	public Proveedor findById(Integer id);
	
	public void save(Proveedor proveedores);
	
	public void delete(Proveedor proveedores);
}
