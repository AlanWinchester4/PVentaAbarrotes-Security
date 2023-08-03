package com.Abarrotes.PVenta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.repository.ProductoRepository;

@Controller
public class ProductoREST 
{
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/producto/All")
	public List<Producto>todos()
	{
		return productoRepository.findAll();
	}
	@PostMapping("/producto/crear")
	public Producto crear(@Param("id_Prod") int id)
	{
		return null;
		
	}
	
	@GetMapping("/")
	public String todos(Model modelo)
	{
		modelo.addAttribute("productList",productoRepository.findAll());
		for(Producto p :productoRepository.findAll())
		{
			System.out.println(p.toString());
		}
		return "Login";
	}
}
