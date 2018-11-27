package br.com.company.project.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;

import br.com.company.project.util.JPAUtil;

public abstract class AbstractDao<E> {

	public AbstractDao() {
	}

	public E insert(E entity) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
		return entity;
	}

	public void update(E entity) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		E entity = em.find(getEntityClass(), id);
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}

	public E findById(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		E entity = em.find(getEntityClass(), id);
		em.close();
		return entity;
	}

	public Collection<E> findAll() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<E>) genericSuperClass.getActualTypeArguments()[0];
	}

}
