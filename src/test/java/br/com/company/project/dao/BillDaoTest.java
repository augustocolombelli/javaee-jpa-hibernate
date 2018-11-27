package br.com.company.project.dao;

import java.util.Date;

import br.com.company.project.model.Bill;
import br.com.company.project.model.Invoice;
import br.com.company.project.model.Parcel;
import br.com.company.project.model.ParcelPK;

public class BillDaoTest {

	private InvoiceDao invoiceDao;
	private BillDao billDao;
	
	public static void main(String[] args) {
		BillDaoTest billDaoTest = new BillDaoTest();
		billDaoTest.shouldInsertOneBill();
	}
	
	public BillDaoTest() {
		invoiceDao = new InvoiceDao();
		billDao = new BillDao();
	}
	
	public void shouldInsertOneBill() {
		
		Invoice invoice = invoiceDao.findById(36);
		
		Bill bill = new Bill();
		bill.setCreditor(invoice.getCreditor());
		bill.setInvoice(invoice);
		bill.setTotalValue(invoice.getValue());
		bill.setQuantityOfParcels(4);
		
		for(int i =1; i <= bill.getQuantityOfParcels(); i++) {
			Parcel parcel = new Parcel();
			parcel.setExpiration(new Date());
			parcel.setValue(bill.getTotalValue()/bill.getQuantityOfParcels());
			parcel.setParcelPK(new ParcelPK(bill, i));
			bill.addParcel(parcel);
		}
		billDao.insert(bill);
	}
	
}
