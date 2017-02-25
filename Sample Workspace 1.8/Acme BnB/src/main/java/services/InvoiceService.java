
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.InvoiceRepository;
import domain.Invoice;

@Service
@Transactional
public class InvoiceService {

	@Autowired
	private InvoiceRepository	invoiceRepository;


	public InvoiceService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Invoice create() {
		Invoice result;

		result = new Invoice();
		return result;
	}

	public Collection<Invoice> findAll() {
		Collection<Invoice> result;

		result = invoiceRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Invoice findOne(int invoiceId) {
		Invoice result;

		result = invoiceRepository.findOne(invoiceId);

		return result;
	}

	public Invoice save(Invoice invoice) {
		Assert.notNull(invoice);

		return invoiceRepository.save(invoice);
	}

	public void delete(Invoice invoice) {
		Assert.notNull(invoice);
		Assert.isTrue(invoice.getId() != 0);

		invoiceRepository.delete(invoice);
	}
}
