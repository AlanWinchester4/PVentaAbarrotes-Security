package com.Abarrotes.PVenta.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Abarrotes.PVenta.Services.ProductoServicioImpl;
import com.Abarrotes.PVenta.Services.ProveedoresServicioImpl;

@Controller
@RequestMapping("/views/productos")
public class ProductoREST 
{
	@Autowired
	private ProductoServicioImpl PRODSI;
	@Autowired
	private ProveedoresServicioImpl PROVSI;
	
	@GetMapping("/")
	public String todos(Model modelo)
	{
		modelo.addAttribute("productList",PRODSI.All());
		return "/views/productos/listar";
	}
	@GetMapping("/VCrear")
	public String vistaCrear(Model modelo)
	{
		modelo.addAttribute("titulo","Formulario: Producto Nuevo");
		modelo.addAttribute("seleccionar","Sin Proveedor");
		modelo.addAttribute("proveedoresList",PROVSI.All());
		return "/views/productos/frmCrear";
	}
	
	/*@PostMapping("/crear")
	public String guardar(@Validated @ModelAttribute Producto producto,BindingResult result,
			Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo","Formulario: Nuevo Producto");
			model.addAttribute("producto",producto);
			attribute.addFlashAttribute("warning","Existieron errores en el formulario");
			return "frmCrear";
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
		
	}*/

}
