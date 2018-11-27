package br.com.company.project.dao;

import br.com.company.project.model.Product;

public class ProductDaoTest {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		dao.insert(new Product("Mouse"));
		dao.insert(new Product("Bike"));
		dao.insert(new Product("Computer"));
		dao.insert(new Product("Laptop"));
		dao.insert(new Product("Monitor"));
		
	}
	
}
