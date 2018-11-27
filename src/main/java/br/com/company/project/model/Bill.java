package br.com.company.project.model;

import java.util.Collection;

public class Bill {

	private Integer id;
	private Creditor creditor;
	private Invoice invoice;
	private Double totalValue;
	private Collection<Parcel> parcels;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Creditor getCreditor() {
		return creditor;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Collection<Parcel> getParcels() {
		return parcels;
	}

	public void setParcels(Collection<Parcel> parcels) {
		this.parcels = parcels;
	}

}
