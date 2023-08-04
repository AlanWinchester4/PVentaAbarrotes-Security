package com.Abarrotes.PVenta.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.DAO.ProductoDAO;
import com.Abarrotes.PVenta.Services.ServicioProducto;
import com.Abarrotes.PVenta.repository.ProductoRepository;

@Service
public class ServiciosProductoImpl implements ServicioProducto
{
	private ProductoDAO productoDAO = null;
	@Autowired(required=true)
	private ProductoRepository RP;
	
	public ServiciosProductoImpl()
	{
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() 
	{
		return RP.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Producto findById(Integer id) 
	{
		return RP.getById(id);
	}

	@Override
	public void save(Producto producto) 
	{
		RP.save(producto);
	}

	@Override
	public void deleteById(Producto producto) 
	{
		RP.delete(producto);
		
	}

	@Override
	public ProductoDAO getProductoDAO() 
	{
		return productoDAO;
	}

	@Override
	public void setProductoDAO(ProductoDAO productoDAO) 
	{
		this.productoDAO = productoDAO;
		
	}

}
