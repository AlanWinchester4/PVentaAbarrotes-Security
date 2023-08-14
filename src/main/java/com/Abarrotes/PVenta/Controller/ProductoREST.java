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
	public String todos(Model modelo, String nom_Prod)
	{
		List<Producto> lista = null;
		lista = PRODSI.findAll();
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
	public String guardar(@Valid @ModelAttribute("producto") Producto producto,@RequestParam("file") MultipartFile imagen, BindingResult result, Model modelo, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			modelo.addAttribute("titulo","Formulario: Producto Nuevo");
			modelo.addAttribute("producto",producto);
			modelo.addAttribute("proveedoresList",PROVSI.All());
			attribute.addFlashAttribute("danger", "ERROR: AL LLENAR EL PRODUCTO!");
			return "/views/productos/frmCrear";
		}
		if(!imagen.isEmpty())
		{
			//Path directorioImagenes = Paths.get("src//main/resources//static/images/Productos");
			//String rutaabsoluta = directorioImagenes.toFile().getAbsolutePath();
			String rutaabsoluta = "C://imagenes//Productos//recursos";
			try 
			{
				byte[] byteImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaabsoluta +"//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, byteImg);
				producto.setUrl_nom_Img(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			attribute.addFlashAttribute("danger", "ERROR: EL ID DEL PRODUCTO NO EXISTE!");
			return "redirect:/views/productos/";
		}
		modelo.addAttribute("titulo","Formulario: Editar Producto");
		modelo.addAttribute("producto",PRODSI.findById(id));
		modelo.addAttribute("file",PRODSI.findById(id).getUrl_nom_Img());
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
	@GetMapping("/search/{nom_Prod}")
	public String buscarPorNombre(@PathVariable("nom_Prod") String nombre,Model modelo,RedirectAttributes attribute)
	{
		List<Producto> p =PRODSI.findAllByNom(nombre);
		if(p.size() !=0)
		{
			modelo.addAttribute("productList",PRODSI.findAllByNom(nombre));
			return "/views/productos/listar";
		}
			attribute.addFlashAttribute("warning", "EL PRODUCTO BUSCADO NO EXISTE!");
			return "redirect:/views/productos/";	
	}
	
	@GetMapping("/detalle/{id_Prod}")
	public String detalleProducto(@PathVariable("id_Prod") int id, Model modelo, RedirectAttributes attribute)
	{	
		if(PRODSI.findById(id)==null)
		{
			attribute.addFlashAttribute("danger", "ERROR: EL ID DEL PRODUCTO NO EXISTE!");
			return "redirect:/views/productos/";
		}
		Producto p = PRODSI.findById(id);
		modelo.addAttribute("titulo","Detalles del Producto "+p.getNom_Prod() );
		modelo.addAttribute("producto",p);
		modelo.addAttribute("file",p.getUrl_nom_Img());
		modelo.addAttribute("proveedoresList",PROVSI.All());
		return "/views/productos/detalleProducto";
	}
}
