package com.Abarrotes.PVenta.DAOGenerics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class GenericDAOJPAImpl <T, Id extends Serializable>implements GenericDAO<T, Id>
{

private Class<T> claseDePersistencia;
	
	EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory getEntityManagerFactory()
	{
		return entityManagerFactory;
	}
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findAll() 
	{
		TypedQuery<T> consulta = null;
		EntityManager manager = entityManagerFactory.createEntityManager();
		try
		{
			consulta = manager.createQuery("SELECT o FROM "+ claseDePersistencia.getSimpleName()+ " o",claseDePersistencia);	
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
		}
		return consulta.getResultList();
	}

	public T findById(int id) 
	{
		EntityManager manager = entityManagerFactory.createEntityManager();
		T objeto = null;
		try
		{
			objeto = (T) manager.find(claseDePersistencia, id);
			return objeto;
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}
		finally
		{
			manager.close();
		}
		return objeto;
	}

	@Override
	public void save(T objeto) 
	{
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try 
		{
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			manager.close();
		}
	}

	@Override
	public void deleteById(Object objeto) 
	{
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try
		{	
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
			
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			manager.close();
		}
	}

}
