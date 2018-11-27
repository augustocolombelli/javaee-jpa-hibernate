package br.com.company.project.model;

import java.util.Collection;

public class Invoice {

	private Integer id;
	private Double value;
	private City city;
	private Creditor creditor;
	private Collection<InvoiceItem> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Creditor getCreditor() {
		return creditor;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	public Collection<InvoiceItem> getItems() {
		return items;
	}

	public void addItem(InvoiceItem item) {
		this.items.add(item);
	}

}
