package br.com.company.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Creditor creditor;

	@OneToOne
	private Invoice invoice;
	private Double totalValue;

	@OneToMany(mappedBy = "parcelPK.bill", cascade = CascadeType.ALL)
	private Collection<Parcel> parcels;

	private Integer quantityOfParcels;
	
	public Bill() {
		parcels = new ArrayList<Parcel>();
	}

	public Integer getQuantityOfParcels() {
		return quantityOfParcels;
	}

	public void setQuantityOfParcels(Integer quantityOfParcels) {
		this.quantityOfParcels = quantityOfParcels;
	}

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

	public void addParcel(Parcel parcel) {
		this.parcels.add(parcel);
	}

}
