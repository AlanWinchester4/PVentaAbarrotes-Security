package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.DAO.ProductoDAO;

public interface ServicioProducto 
{
	public abstract List <Producto> findAll();
	public abstract Producto findById(Integer id);
	public abstract void save (Producto producto);
	public abstract void deleteById(Producto producto);
	
	public ProductoDAO getProductoDAO();
	public void setProductoDAO(ProductoDAO productoDAO);
}
