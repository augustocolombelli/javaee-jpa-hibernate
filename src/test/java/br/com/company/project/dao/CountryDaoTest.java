package br.com.company.project.dao;

import br.com.company.project.dao.CountryDao;
import br.com.company.project.model.Country;

public class CountryDaoTest {

	private CountryDao dao;

	public CountryDaoTest() {
		dao = new CountryDao();
	}

	public void shouldInsertOneCountry() {
		Country country = new Country();
		country.setName("New country");
		dao.insert(country);
	}
	
	public void shouldUpdateOneCountry() {
		Country countryToInsert = new Country();
		countryToInsert.setName("Country to insert");
		int id = dao.insert(countryToInsert).getId();
		Country countryToUpdate = dao.findById(id);
		countryToUpdate.setName("Country updated");
		dao.update(countryToUpdate);
	}
	
	public void shouldRemoveOneCountry() {
		Country countryToInsert = new Country();
		countryToInsert.setName("Country to insert");
		int id = dao.insert(countryToInsert).getId();
		dao.delete(id);
	}
	
	public static void main(String[] args) {
		CountryDaoTest daoTest = new CountryDaoTest();
		daoTest.shouldInsertOneCountry();
		daoTest.shouldUpdateOneCountry();
		daoTest.shouldRemoveOneCountry();
	}

}
