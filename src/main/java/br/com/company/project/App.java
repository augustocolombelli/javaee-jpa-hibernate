package br.com.company.project;

import br.com.company.project.dao.CountryDao;
import br.com.company.project.model.Country;

public class App {
	
	public static void main(String[] args) {
		CountryDao dao = new CountryDao();
		Country country = new Country();
		country.setName("Brazil");
//		dao.insert(country);
		
		Country countryToUpdate = dao.findById(1);
//		countryToUpdate.setName("Argentina");
//		dao.update(countryToUpdate);
		System.out.println("Here");
		
		dao.delete(1);
	}
	

	
	private static void updateCountry() {
	}
	
	private static void deleteCountry() {
		
	}
}
