
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CreditCardRepository;
import domain.CreditCard;

@Service
@Transactional
public class CreditCardService {

	@Autowired
	private CreditCardRepository	creditCardRepository;


	public CreditCardService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public CreditCard create() {
		CreditCard result;

		result = new CreditCard();
		return result;
	}

	public Collection<CreditCard> findAll() {
		Collection<CreditCard> result;

		result = creditCardRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public CreditCard findOne(int creditCardId) {
		CreditCard result;

		result = creditCardRepository.findOne(creditCardId);

		return result;
	}

	public CreditCard save(CreditCard creditCard) {
		Assert.notNull(creditCard);

		return creditCardRepository.save(creditCard);
	}

	public void delete(CreditCard creditCard) {
		Assert.notNull(creditCard);
		Assert.isTrue(creditCard.getId() != 0);

		creditCardRepository.delete(creditCard);
	}
}
