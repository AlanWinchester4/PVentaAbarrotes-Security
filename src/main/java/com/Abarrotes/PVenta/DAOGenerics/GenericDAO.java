package com.Abarrotes.PVenta.DAOGenerics;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,id extends Serializable>
{

	List <T> findAll();
	T findById(int id);
	void save (T objeto);
	void deleteById(T objeto);
}
