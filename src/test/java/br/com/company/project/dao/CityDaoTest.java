package br.com.company.project.dao;

import br.com.company.project.model.City;
import br.com.company.project.model.Country;

public class CityDaoTest {

	private CountryDao countryDao;
	private CityDao cityDao;
	
	public CityDaoTest() {
		countryDao = new CountryDao();
		cityDao = new CityDao();
	}
	
	
	public static void main(String[] args) {
		CityDaoTest daoTest = new CityDaoTest();
		daoTest.shouldInsertOneCity();
		daoTest.shouldUpdateOneCity();
		daoTest.shouldDeleteOneCity();
	}
	
	public void shouldInsertOneCity() {
		Country country = countryDao.findById(1000);
		City city = new City();
		city.setCountry(country);
		city.setName("Any city");
		cityDao.insert(city);
	}
	
	public void shouldUpdateOneCity() {
		City cityToUpdate = cityDao.findById(15);
		cityToUpdate.setName("City updated");
		cityDao.update(cityToUpdate);
	}
	
	public void shouldDeleteOneCity() {
		Country country = countryDao.findById(1000);
		City city = new City();
		city.setCountry(country);
		city.setName("Any city");
		int id = cityDao.insert(city).getId();
		cityDao.delete(id);
	}
	
}
