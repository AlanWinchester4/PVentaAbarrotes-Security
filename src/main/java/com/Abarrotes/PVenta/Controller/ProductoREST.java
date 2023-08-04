package com.Abarrotes.PVenta.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.repository.ProductoRepository;

@Controller
public class ProductoREST 
{
	@Autowired(required=true)
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
	@PostMapping("/crear")
	public String guardar(@Validated @ModelAttribute Producto producto,BindingResult result,
			Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo","Formulario: Nuevo Producto");
			model.addAttribute("producto",producto);
			attribute.addFlashAttribute("warning","Existieron errores en el formulario");
			return "/views/productos/frmCrear";
		}
		if(!imagen.isEmpty())
		{
			Path directorioImagenes = Paths.get("src//main//resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try 
			{
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				producto.setUrl_nom_Img(imagen.getOriginalFilename());
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//productosServicio.gusardar(producto);
		attribute.addFlashAttribute("success", "producto guardado con exito!");
		return "redirect:/views/productos/";
		
	}

}
