package com.ac.sco.sportsservice.dao;

import java.util.List;

/**
 * 
 * @author Gteolis
 *
 */
public interface GenericDao {

	<T> List<T> findAll(Class<T> clazz);
	
	<T> void store(T type);

	<T> T getById(Class<T> clazz, Long id);
	
	<T> T update(T type);

	<T> void delete(T type);

	<T> List<T> execute(String queryIdentificator, Class<T> clazz, Object... parameters);
	
	<T> T executeForSingleResult(String queryIdentificator, Class<T> clazz, Object... parameters);
	
}
