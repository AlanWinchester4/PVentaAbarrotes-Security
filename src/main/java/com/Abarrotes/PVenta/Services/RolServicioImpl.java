package com.Abarrotes.PVenta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Rol;
import com.Abarrotes.PVenta.repository.RolRepository;
@Service
public class RolServicioImpl implements RolServicio
{
	@Autowired
	private RolRepository RR;
	
	@Override
	public List<Rol> findAll() 
	{
		return RR.findAll();
	}

	@Override
	public Rol findById(Integer id) 
	{
		// TODO Auto-generated method stub
		return RR.findById(id).orElse(null);
	}

	@Override
	public void save(Rol rol) 
	{
		RR.save(rol);
	}

	@Override
	public void delete(Integer id) 
	{
		RR.deleteById(id);
	}

	@Override
	public List<Rol> findAllByNom(String nom) 
	{
		return RR.findAll(nom);
	}

}
