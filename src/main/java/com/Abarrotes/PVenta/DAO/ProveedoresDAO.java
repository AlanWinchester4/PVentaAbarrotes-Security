package com.Abarrotes.PVenta.DAO;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Proveedor;

public interface ProveedoresDAO 
{
public abstract List<Proveedor> All();
	
	public abstract Proveedor findById(Integer id);
	
	public abstract void save(Proveedor proveedores);
	
	public abstract void delete(Proveedor proveedores);
}
