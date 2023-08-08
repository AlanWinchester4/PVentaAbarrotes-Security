package com.Abarrotes.PVenta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Proveedor;
import com.Abarrotes.PVenta.repository.ProveedorRepository;
@Service
public class ProveedorServicioImpl implements ProveedorServicio
{

	@Autowired
	private ProveedorRepository PR;
	
	@Override
	public List<Proveedor> All() 
	{
		return PR.findAll();
	}

	@Override
	public Proveedor findById(Integer id) 
	{
		return PR.findById(id).orElse(null);
	}

	@Override
	public void save(Proveedor proveedores) 
	{
		PR.save(proveedores);
	}

	@Override
	public void delete(Proveedor proveedores) 
	{	
		PR.delete(proveedores);
	}

}
