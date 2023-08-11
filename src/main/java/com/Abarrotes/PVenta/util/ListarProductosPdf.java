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
		Font fcol = FontFactory.getFont("Hervetica",14,Color.BLACK);
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE LOS PRODUCTOS",ftitulo));		
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(20);
		
		tablatitulo.addCell(celda);
		tablatitulo.setSpacingAfter(30);
		
		PdfPTable COL = new PdfPTable(7);
		COL.addCell(new PdfPCell(new Phrase("CLAVE",fcol)));
		COL.addCell(new PdfPCell(new Phrase("NOMBRE",fcol)));
		COL.addCell(new PdfPCell(new Phrase("PRECIO",fcol)));
		COL.addCell(new PdfPCell(new Phrase("EXISTENCIAS",fcol)));
		COL.addCell(new PdfPCell(new Phrase("REQUERIDAS",fcol)));
		COL.addCell(new PdfPCell(new Phrase("VENDIDAS",fcol)));
		COL.addCell(new PdfPCell(new Phrase("PROVEDOR",fcol)));
	
		
		
		PdfPTable tabla = new PdfPTable(7);
		listaProductos.forEach(Producto ->
		{
			tabla.addCell(Producto.getCve_Prod()+"");
			tabla.addCell(Producto.getNom_Prod());
			tabla.addCell(Producto.getPre_Prod()+"");
			tabla.addCell(Producto.getInv_exi_Prod()+"");
			tabla.addCell(Producto.getInv_stock_Prod()+"");
			tabla.addCell(Producto.getProd_tot_Ven()+"");
			tabla.addCell(Producto.getProveedor().getNom_Prov());
		});
		
		document.add(tablatitulo);
		document.add(COL);
		document.add(tabla);
	}
	
}
