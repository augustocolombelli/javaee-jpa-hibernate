package br.com.company.project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class InvoiceItemPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.ALL)
	private Invoice invoice;
	private Integer number;
	
	public InvoiceItemPK() {}

	public InvoiceItemPK(Invoice invoice, Integer number) {
		this.invoice = invoice;
		this.number = number;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
