package com.Abarrotes.PVenta.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Abarrotes.PVenta.Beans.Producto;
import com.Abarrotes.PVenta.Services.ProductoServicioImpl;
import com.Abarrotes.PVenta.Services.ProveedorServicioImpl;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/views/productos")
public class ProductoREST 
{
	@Autowired
	private ProductoServicioImpl PRODSI;
	@Autowired
	private ProveedorServicioImpl PROVSI;
	
	@GetMapping("/")
	public String todos(Model modelo)
	{
		List<Producto> lista = PRODSI.All();
		modelo.addAttribute("productList",lista);
		return "/views/productos/listar";
	}
	@GetMapping("/VCrear")
	public String vistaCrear(Model modelo)
	{
		modelo.addAttribute("titulo","Formulario: Producto Nuevo");
		modelo.addAttribute("producto",new Producto());
		modelo.addAttribute("proveedoresList",PROVSI.All());
		return "/views/productos/frmCrear";
	}
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model modelo, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			modelo.addAttribute("titulo","Formulario: Producto Nuevo");
			modelo.addAttribute("producto",producto);
			modelo.addAttribute("proveedoresList",PROVSI.All());
			attribute.addFlashAttribute("success", "EL PRODUCTO SE GUARDO CORRECTAMENTE!");
			return "/views/productos/frmCrear";
		}
		PRODSI.save(producto);
		attribute.addFlashAttribute("success", "EL PRODUCTO SE GUARDO CORRECTAMENTE!");
		return "redirect:/views/productos/";
	}
	
	@GetMapping("/edit/{id_Prod}")
	public String editar(@PathVariable("id_Prod") int id, Model modelo, RedirectAttributes attribute)
	{	
		if(PRODSI.findById(id)==null)
		{
			attribute.addFlashAttribute("error", "ERROR: EL ID DEL PRODUCTO NO EXISTE!");
			return "redirect:/views/productos/";
		}
		modelo.addAttribute("titulo","Formulario: Editar Producto");
		modelo.addAttribute("producto",PRODSI.findById(id));
		modelo.addAttribute("proveedoresList",PROVSI.All());
		return "/views/productos/frmCrear";
	}
	
	@GetMapping("/delete/{id_Prod}")
	public String eliminar(@PathVariable("id_Prod") int id,RedirectAttributes attribute)
	{	
		if(PRODSI.findById(id)==null)
		{
			attribute.addFlashAttribute("error", "ERROR: EL ID DEL PRODUCTO NO EXISTE!");
			return "redirect:/views/productos/";
		}
		PRODSI.delete(id);
		attribute.addFlashAttribute("warning", "REGISTRO ELIMINADO CON EXITO!");
		return "redirect:/views/productos/";
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
