
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AttributeRepository;
import domain.Attribute;

@Service
@Transactional
public class AttributeService {

	@Autowired
	private AttributeRepository	attributeRepository;


	public AttributeService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Attribute create() {
		Attribute result;

		result = new Attribute();
		return result;
	}

	public Collection<Attribute> findAll() {
		Collection<Attribute> result;

		result = attributeRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Attribute findOne(int attributeId) {
		Attribute result;

		result = attributeRepository.findOne(attributeId);

		return result;
	}

	public Attribute save(Attribute attribute) {
		Assert.notNull(attribute);

		return attributeRepository.save(attribute);
	}

	public void delete(Attribute attribute) {
		Assert.notNull(attribute);
		Assert.isTrue(attribute.getId() != 0);

		attributeRepository.delete(attribute);
	}

}
