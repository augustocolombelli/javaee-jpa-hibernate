package br.com.company.project.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ParcelPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Bill bill;
	private Integer number;

	public ParcelPK() {}
	
	public ParcelPK(Bill bill, Integer number) {
		this.bill = bill;
		this.number = number;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
