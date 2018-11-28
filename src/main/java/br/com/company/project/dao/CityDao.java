package br.com.company.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.company.project.model.City;
import br.com.company.project.util.JPAUtil;

public class CityDao extends AbstractDao<City>{
	
	public List<City> findAllCities(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select c from City c";
		Query query = em.createQuery(jpql);
		List<City> cities = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return cities;
	}
	
	public List<City> findAllCitiesWithCountry(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select c from City c inner join c.country";
		Query query = em.createQuery(jpql);
		List<City> cities = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return cities;
	}
	
	public List<City> findAllCitiesWithAndWithoutCountry(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select c from City c left join c.country";
		Query query = em.createQuery(jpql);
		List<City> cities = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return cities;
	}
}
