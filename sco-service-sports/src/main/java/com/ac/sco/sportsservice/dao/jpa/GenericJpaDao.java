package com.ac.sco.sportsservice.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ac.sco.sportsservice.dao.GenericDao;

/**
 * 
 * @author Gteolis
 *
 */
@Repository
public class GenericJpaDao implements GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return entityManager.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	@Override
	public <T> void store(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public <T> T getById(Class<T> clazz, Long id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public <T> T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public <T> void delete(T entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public <T> T executeForSingleResult(String queryIdentificator, Class<T> clazz, Object... parameters) {
		TypedQuery<T> typedQuery = entityManager.createNamedQuery(queryIdentificator, clazz);
		for (int parameterPosition = 0; parameterPosition < parameters.length; parameterPosition++) {
			typedQuery.setParameter(parameterPosition + 1, parameters[parameterPosition]);
		}
		return typedQuery.getSingleResult();
	}
	
	@Override
	public <T> List<T> execute(String queryIdentificator, Class<T> clazz, Object... parameters) {
		TypedQuery<T> typedQuery = entityManager.createNamedQuery(queryIdentificator, clazz);
		for (int parameterPosition = 0; parameterPosition < parameters.length; parameterPosition++) {
			typedQuery.setParameter(parameterPosition + 1, parameters[parameterPosition]);
		}
		return typedQuery.getResultList();
	}

}
