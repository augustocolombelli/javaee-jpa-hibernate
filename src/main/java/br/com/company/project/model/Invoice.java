package br.com.company.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private Integer id;
	private Double value;
	
	@ManyToOne
	private City city;
	
	@ManyToOne
	private Creditor creditor;
	
	@OneToMany(mappedBy="invoiceItemPK.invoice", cascade=CascadeType.ALL)
	private Collection<InvoiceItem> items;

	public Invoice() {
		items = new ArrayList<InvoiceItem>();
	}
	
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
