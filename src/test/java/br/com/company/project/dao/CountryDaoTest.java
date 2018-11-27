package br.com.company.project.dao;

import br.com.company.project.model.Country;

public class CountryDaoTest {

	private CountryDao dao;

	public CountryDaoTest() {
		dao = new CountryDao();
	}

	public void shouldInsertOneCountry() {
		Country country = new Country();
		country.setName("Brazil");
		dao.insert(country);
	}
	
	public void shouldUpdateOneCountry() {
		CountryDao dao = new CountryDao();
		Country countryToUpdate = dao.findById(1);
		countryToUpdate.setName("Argentina");
		dao.update(countryToUpdate);
	}
	
	public void shouldRemoveOneCountry() {
		dao.delete(1);
	}
	
	public static void main(String[] args) {
		CountryDaoTest daoTest = new CountryDaoTest();
		daoTest.shouldInsertOneCountry();
		daoTest.shouldUpdateOneCountry();
		daoTest.shouldRemoveOneCountry();
	}

}
