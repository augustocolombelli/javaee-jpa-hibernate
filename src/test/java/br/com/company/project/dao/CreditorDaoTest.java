package br.com.company.project.dao;

import br.com.company.project.model.City;
import br.com.company.project.model.Creditor;

public class CreditorDaoTest {

	private CreditorDao creditoDao;
	private CityDao cityDao;

	public CreditorDaoTest() {
		creditoDao = new CreditorDao();
		cityDao = new CityDao();
	}

	public void souldInsertOneCreditor() {
		Creditor creditor = new Creditor();
		City city = cityDao.findById(1000);
		creditor.setCity(city);
		creditor.setDocumentNumber(123123);
		creditor.setName("Hector");
		creditoDao.insert(creditor);
	}

	public static void main(String[] args) {
		CreditorDaoTest dao = new CreditorDaoTest();
		dao.souldInsertOneCreditor();
	}
}
