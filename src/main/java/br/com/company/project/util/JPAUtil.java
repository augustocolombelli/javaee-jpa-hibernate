package br.com.company.project.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("account_manager");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
