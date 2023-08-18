package com.Abarrotes.PVenta.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Rol 
{
	@Id @Column(name="id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rol;
	@Column(name="user_id")
	private int user_id;
	@Column(name="nom_rol")
	private String nom_rol;
	/**
	 * @param id_rol
	 * @param user_id
	 * @param nom_rol
	 */
	public Rol(int id_rol, int user_id, String nom_rol) 
	{
		this.id_rol = id_rol;
		this.user_id = user_id;
		this.nom_rol = nom_rol;
	}
	public Rol()
	{
		
	}
	public int getId_rol() 
	{
		return id_rol;
	}
	public void setId_rol(int id_rol) 
	{
		this.id_rol = id_rol;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}
	public String getNom_rol() {
		return nom_rol;
	}
	public void setNom_rol(String nom_rol) 
	{
		this.nom_rol = nom_rol;
	}
	@Override
	public String toString() {
		return "rol [id_rol=" + id_rol + ", user_id=" + user_id + ", nom_rol=" + nom_rol + "]";
	}
	
	
}
