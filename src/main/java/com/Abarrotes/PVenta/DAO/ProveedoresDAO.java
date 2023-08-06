package com.Abarrotes.PVenta.DAO;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Proveedores;

public interface ProveedoresDAO 
{
public abstract List<Proveedores> All();
	
	public abstract Proveedores findById(Integer id);
	
	public abstract void save(Proveedores proveedores);
	
	public abstract void delete(Proveedores proveedores);
}
