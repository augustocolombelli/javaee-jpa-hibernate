package br.com.company.project.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parcel {

	@EmbeddedId
	private ParcelPK parcelPK;
	private Date expiration;
	private Double value;

	public ParcelPK getParcelPK() {
		return parcelPK;
	}

	public void setParcelPK(ParcelPK parcelPK) {
		this.parcelPK = parcelPK;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
