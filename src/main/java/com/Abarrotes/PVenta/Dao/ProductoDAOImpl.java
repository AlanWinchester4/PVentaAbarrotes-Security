package com.Abarrotes.PVenta.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Abarrotes.PVenta.Beans.Producto;

public class ProductoDAOImpl implements ProductoDAO
{

	@Override
	public List<Producto> findAll() throws DataAccessException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Producto producto) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
