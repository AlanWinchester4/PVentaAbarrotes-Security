package com.Abarrotes.PVenta.Services;

import java.util.List;

import com.Abarrotes.PVenta.Beans.Usuario;

public interface UsuarioServicio 
{
	public List<Usuario> findAll();
	
	public Usuario findById(Integer id);
	
	public Usuario findByNom(String nom);
	
	public void save(Usuario usuario);
	
	public void delete(Integer id);
	
	public List<Usuario> findAllByNom(String nom);
}
