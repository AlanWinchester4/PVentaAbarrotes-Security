package com.Abarrotes.PVenta.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Prov")
	private int id_Prov;
	@Column(name="nom_Prov")
	private String nom_Prov;
	@Column(name="tel_Prov")
	private String tel_Prov;
	@Column(name="dir_Prov")
	private String dir_Prov;
	@Column(name="url_nom_Prov")
	private String url_nom_Prov;
	/**
	 * @param id
	 * @param nom_Prov
	 * @param tel_Prov
	 * @param dir_Prov
	 * @param url_nom_Prov
	 */
	public Proveedor(int id_Prov, String nom_Prov, String tel_Prov, String dir_Prov, String url_nom_Prov) 
	{
		this.id_Prov = id_Prov;
		this.nom_Prov = nom_Prov;
		this.tel_Prov = tel_Prov;
		this.dir_Prov = dir_Prov;
		this.url_nom_Prov = url_nom_Prov;
	}
	
	public Proveedor()
	{
		
	}
	
	public int getId_Prov() 
	{
		return id_Prov;
	}
	public void setId_Prov(int id_Prov) 
	{
		this.id_Prov = id_Prov;
	}
	public String getNom_Prov() 
	{
		return nom_Prov;
	}
	public void setNom_Prov(String nom_Prov) 
	{
		this.nom_Prov = nom_Prov;
	}
	public String getTel_Prov() 
	{
		return tel_Prov;
	}
	public void setTel_Prov(String tel_Prov) 
	{
		this.tel_Prov = tel_Prov;
	}
	public String getDir_Prov() 
	{
		return dir_Prov;
	}
	public void setDir_Prov(String dir_Prov) 
	{
		this.dir_Prov = dir_Prov;
	}
	public String getUrl_nom_Prov() 
	{
		return url_nom_Prov;
	}
	public void setUrl_nom_Prov(String url_nom_Prov) 
	{
		this.url_nom_Prov = url_nom_Prov;
	}
	@Override
	public String toString() 
	{
		return "Proveedores [id=" + id_Prov + ", nom_Prov=" + nom_Prov + ", tel_Prov=" + tel_Prov + ", dir_Prov=" + dir_Prov
				+ ", url_nom_Prov=" + url_nom_Prov + ", getId()=" + getId_Prov() + ", getNom_Prov()=" + getNom_Prov()
				+ ", getTel_Prov()=" + getTel_Prov() + ", getDir_Prov()=" + getDir_Prov() + ", getUrl_nom_Prov()="
				+ getUrl_nom_Prov() + ", toString()=" + super.toString() + "]";
	}
	
	
}
