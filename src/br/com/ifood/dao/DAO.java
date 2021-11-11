package br.com.ifood.dao;

import java.util.List;
import java.util.Optional;

import br.com.ifood.exception.DBException;

public interface DAO<T> {

	Optional<T> get(int id);
	
	List<T> getAll();
	
	Optional<T> save(T object) throws DBException;
 	
	void update(T object) throws DBException;
	
	void remove(T object) throws DBException;

}
