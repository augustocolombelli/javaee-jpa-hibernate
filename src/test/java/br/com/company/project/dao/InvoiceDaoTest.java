package br.com.company.project.dao;

import java.util.Iterator;

import br.com.company.project.model.Invoice;
import br.com.company.project.model.InvoiceItem;
import br.com.company.project.model.InvoiceItemPK;

public class InvoiceDaoTest {
	private CreditorDao creditorDao;
	private CityDao cityDao;
	private ProductDao productDao;
	private InvoiceDao invoiceDao;
	private InvoiceItemDao invoiceItemDao;

	public InvoiceDaoTest() {
		creditorDao = new CreditorDao();
		cityDao = new CityDao();
		productDao = new ProductDao();
		invoiceDao = new InvoiceDao();
		invoiceItemDao = new InvoiceItemDao();
	}
	

	public static void main(String[] args) {
//		new InvoiceDaoTest().shouldInsertOneInvoice();
//		new InvoiceDaoTest().shouldAddOneItem();
//		new InvoiceDaoTest().shouldRemoveOneItem();
		new InvoiceDaoTest().shouldRemoveOneInvoice();
	}
	
	public void shouldRemoveOneInvoice() {
		invoiceDao.delete(37);
	}
	
	public void shouldRemoveOneItem() {
		Invoice invoice = invoiceDao.findById(37);
		Iterator<InvoiceItem> it = invoice.getItems().iterator();
		while(it.hasNext()) {
			InvoiceItem invoiceItem = it.next();
			if(invoiceItem.getInvoiceItemPK().getNumber() == 2) {
				invoiceItemDao.delete(invoiceItem.getInvoiceItemPK());
			}
		}
	}

	public void shouldAddOneItem() {
		Invoice invoice = invoiceDao.findById(37);
		
		InvoiceItem item3 = new InvoiceItem();
		item3.setInvoiceItemPK(new InvoiceItemPK(invoice, 3));
		item3.setProduct(productDao.findById(21));
		item3.setQuantity(15);
		item3.setValue(20.10);
		
		invoiceItemDao.insert(item3);
	}

	public void shouldInsertOneInvoice() {
		Invoice invoice = new Invoice();
		invoice.setCity(cityDao.findById(1000));
		invoice.setCreditor(creditorDao.findById(18));
		invoice.setValue(1200d);

		InvoiceItem item1 = new InvoiceItem();
		item1.setInvoiceItemPK(new InvoiceItemPK(invoice, 1));
		item1.setProduct(productDao.findById(19));
		item1.setQuantity(10);
		item1.setValue(15.10);

		InvoiceItem item2 = new InvoiceItem();
		item2.setInvoiceItemPK(new InvoiceItemPK(invoice, 2));
		item2.setProduct(productDao.findById(20));
		item2.setQuantity(10);
		item2.setValue(15.10);

		invoice.addItem(item1);
		invoice.addItem(item2);

		invoiceDao.insert(invoice);
	}

}
