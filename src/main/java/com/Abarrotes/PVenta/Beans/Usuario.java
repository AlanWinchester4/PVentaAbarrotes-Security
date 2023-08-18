package com.Abarrotes.PVenta.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id_user;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_user" ,referencedColumnName="user_id",insertable=false, updatable=false)
	private Rol rol;
	
	public Rol getRol() 
	{
		return rol;
	}
	public void setRol(Rol rol) 
	{
		this.rol = rol;
	}
	
	@Column(name="nom_user")
	private String nom_user;
	@Column(name="pass_user")
	private String pass_user;
	@Column(name="enabled")
	private int enabled;
	
	
	public Usuario(int id_user, String nom_user, String pass_user, int enabled) 
	{
		this.id_user = id_user;
		this.nom_user = nom_user;
		this.pass_user = pass_user;
		this.enabled = enabled;
	}
	public Usuario()
	{
		
	}
	public int getId_user() 
	{
		return id_user;
	}
	public void setId_user(int id_user) 
	{
		this.id_user = id_user;
	}
	public String getNom_user() 
	{
		return nom_user;
	}
	public void setNom_user(String nom_user) 
	{
		this.nom_user = nom_user;
	}
	public String getPass_user() 
	{
		return pass_user;
	}
	public void setPass_user(String pass_user) 
	{
		this.pass_user = pass_user;
	}
	public int getEnabled() 
	{
		return enabled;
	}
	public void setEnabled(int enabled) 
	{
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "usuarios [id_user=" + id_user + ", nom_user=" + nom_user + ", pass_user=" + pass_user + ", enabled="
				+ enabled + "]";
	}
	
	
}
