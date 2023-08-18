package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Rol;

public interface RolServicio 
{
public List<Rol> findAll();
	
	public Rol findById(Integer id);
	
	public void save(Rol rol);
	
	public void delete(Integer id);
	
	public List<Rol> findAllByNom(String nom);
}
