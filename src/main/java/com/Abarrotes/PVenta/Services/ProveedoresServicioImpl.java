package com.Abarrotes.PVenta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Proveedores;
import com.Abarrotes.PVenta.repository.ProveedoresRepository;
@Service
public class ProveedoresServicioImpl implements ProveedoresServicio
{

	@Autowired
	private ProveedoresRepository PR;
	
	@Override
	public List<Proveedores> All() 
	{
		return PR.findAll();
	}

	@Override
	public Proveedores findById(Integer id) 
	{
		return PR.findById(id).orElse(null);
	}

	@Override
	public void save(Proveedores proveedores) 
	{
		PR.save(proveedores);
	}

	@Override
	public void delete(Proveedores proveedores) 
	{	
		PR.delete(proveedores);
	}

}
