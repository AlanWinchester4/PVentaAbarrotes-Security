package com.Abarrotes.PVenta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Usuario;
import com.Abarrotes.PVenta.repository.UsuarioRepository;
@Service
public class UsuarioServicioImpl implements UsuarioServicio
{
	@Autowired
	private UsuarioRepository UR;

	@Override
	public List<Usuario> findAll() 
	{
		return UR.findAll();
	}

	@Override
	public Usuario findById(Integer id) 
	{
		return UR.findById(id).orElse(null);
	}

	@Override
	public void save(Usuario usuario) 
	{
		UR.save(usuario);
	}

	@Override
	public void delete(Integer id) 
	{
		UR.deleteById(id);
	}

	@Override
	public List<Usuario> findAllByNom(String nom) 
	{
		return UR.findAll(nom);
	}

	@Override
	public Usuario findByNom(String nom) 
	{
		
		return UR.findByNom(nom);
	}

}
