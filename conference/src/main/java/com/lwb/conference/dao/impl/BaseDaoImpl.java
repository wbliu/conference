package com.lwb.conference.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lwb.conference.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

	@PersistenceContext
	private EntityManager em ;
	
	
	public <T> T getById(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}
	
	public void save(Object entity) {
		 em.persist(entity);
	}


}
