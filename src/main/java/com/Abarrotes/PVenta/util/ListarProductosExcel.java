package com.Abarrotes.PVenta.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.Abarrotes.PVenta.Beans.Producto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/views/productos/listar.xlsx")
public class ListarProductosExcel extends AbstractXlsxView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-productos.xlsx\"");
				Sheet hoja = workbook.createSheet("productList");
				
				Row filaTitulo = hoja.createRow(0);
				Cell celda = filaTitulo.createCell(0);
				celda.setCellValue("LISTADO GENERAL DE PRODUCTOS");
				
				Row filaData = hoja.createRow(2);
				String[] columnas = {"CLAVE","NOMBRE DEL PRODUCTO","PRECIO", "EXISTENCIAS", "REQUERIDAS", "VENDIDOS","PROVEEDORES"};
				
				for(int i=0; i<columnas.length; i++)
				{
					celda = filaData.createCell(i);
					celda.setCellValue(columnas[i]);
				}
				List<Producto> listaP = (List<Producto>) model.get("productList");
				int numFila =3;
				for(Producto p :listaP) 
				{
					filaData = hoja.createRow(numFila);
					
					filaData.createCell(0).setCellValue(p.getCve_Prod());
					filaData.createCell(1).setCellValue(p.getNom_Prod());
					filaData.createCell(2).setCellValue(p.getPre_Prod());
					filaData.createCell(3).setCellValue(p.getInv_exi_Prod());
					filaData.createCell(4).setCellValue(p.getInv_stock_Prod());
					filaData.createCell(5).setCellValue(p.getProd_tot_Ven());					
					filaData.createCell(6).setCellValue(p.getProveedor().getNom_Prov());
					numFila ++;

				}
	}

}
