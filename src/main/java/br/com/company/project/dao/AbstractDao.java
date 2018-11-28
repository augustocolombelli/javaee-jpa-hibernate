package br.com.company.project.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.company.project.util.JPAUtil;

public abstract class AbstractDao<E> {

	public AbstractDao() {}

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
		EntityManager em = new JPAUtil().getEntityManager();
		Class<E> clazz = getEntityClass();
		CriteriaQuery<E> query = em.getCriteriaBuilder().createQuery(clazz);
		query.select(query.from(clazz));
		List<E> entities = em.createQuery(query).getResultList();
		em.close();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<E>) genericSuperClass.getActualTypeArguments()[0];
	}

}
