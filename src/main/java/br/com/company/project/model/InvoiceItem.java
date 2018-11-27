package br.com.company.project.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceItem {

	@EmbeddedId
	private InvoiceItemPK invoiceItemPK;

	@ManyToOne
	private Product product;
	private Integer quantity;
	private Double value;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public InvoiceItemPK getInvoiceItemPK() {
		return invoiceItemPK;
	}

	public void setInvoiceItemPK(InvoiceItemPK invoiceItemPK) {
		this.invoiceItemPK = invoiceItemPK;
	}

}
