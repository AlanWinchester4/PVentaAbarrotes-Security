package com.Abarrotes.PVenta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.repository.ProductoRepository;
@Service
public class ProductoServicioImpl implements ProductoServicio
{
	@Autowired
	private ProductoRepository PR;

	@Override
	public List<Producto> All() 
	{
		return (List<Producto>) PR.findAll();
	}

	@Override
	public Producto findById(Integer id) 
	{
		return PR.findById(id).orElse(null);
	}

	@Override
	public void save(Producto producto) 
	{
		PR.save(producto);
	}

	@Override
	public void delete(Producto producto) 
	{
		PR.delete(producto);
	}

}
