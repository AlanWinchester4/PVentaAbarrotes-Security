package com.Abarrotes.PVenta.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.Abarrotes.PVenta.Beans.Producto;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/views/productos/listar")
public class ListarProductosPdf extends AbstractPdfView
{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		@SuppressWarnings("unchecked")
		List<Producto> listaProductos = (List<Producto>) model.get("productList");
		document.setMargins(-60,-60,15,15);
		document.setPageSize(PageSize.LETTER.rotate());
		document.open();
		PdfPTable tablatitulo = new PdfPTable(1);
		PdfPCell celda =null;
		
		Font ftitulo = FontFactory.getFont("Hervetica",16);
		Font fcol = FontFactory.getFont("Hervetica",13,Color.BLACK);
		Font fcel = FontFactory.getFont("Hervetica",8,Color.BLACK);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE LOS PRODUCTOS",ftitulo));		
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		
		tablatitulo.addCell(celda);
		tablatitulo.setSpacingAfter(30);
		
		PdfPTable COL = new PdfPTable(7);
		
		COL.setWidths(new float[] {1.5f, 3f, 1f, 1.2f, 1.2f, 1f,1.5f});
		
		celda = new PdfPCell(new Phrase("Clave",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nombre",fcol));
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_LEFT);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Precio",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Existencias",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Requeridos",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Vendidos",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Proveedor",fcol));	
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(7);
		celda.setBorderWidth(2);
		COL.addCell(celda);
		
		
		
		PdfPTable tabla = new PdfPTable(7);
		tabla.setWidths(new float[] {1.5f, 3f, 1f, 1.2f, 1.2f, 1f,1.5f});
		listaProductos.forEach(Producto ->
		{
			PdfPCell celda2 =null;
			celda2 = new PdfPCell(new Phrase(Producto.getCve_Prod()+"",fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);
			
			celda2 = new PdfPCell(new Phrase(Producto.getNom_Prod(),fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_LEFT);
			celda2.setPadding(4);
			tabla.addCell(celda2);
			
			celda2 = new PdfPCell(new Phrase(Producto.getPre_Prod()+"",fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);
			
			celda2 = new PdfPCell(new Phrase(Producto.getInv_exi_Prod()+"",fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);
			
			celda2 = new PdfPCell(new Phrase(Producto.getInv_stock_Prod()+"",fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);
			
			celda2 = new PdfPCell(new Phrase(Producto.getProd_tot_Ven()+"",fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);

			celda2 = new PdfPCell(new Phrase(Producto.getProveedor().getNom_Prov(),fcel));	
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(4);
			tabla.addCell(celda2);
		});
		
		document.add(tablatitulo);
		document.add(COL);
		document.add(tabla);
	}
	
}
