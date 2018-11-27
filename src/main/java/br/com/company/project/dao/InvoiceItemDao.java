package br.com.company.project.dao;

import javax.persistence.EntityManager;

import br.com.company.project.model.InvoiceItem;
import br.com.company.project.model.InvoiceItemPK;
import br.com.company.project.util.JPAUtil;

public class InvoiceItemDao extends AbstractDao<InvoiceItem>{

	public void delete(InvoiceItemPK pk) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		InvoiceItem entity = em.find(InvoiceItem.class, pk);
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}
	
}
