
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.PropertyRepository;
import domain.Property;

@Service
@Transactional
public class PropertyService {

	@Autowired
	private PropertyRepository	propertyRepository;


	public PropertyService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Property create() {
		Property result;

		result = new Property();
		return result;
	}

	public Collection<Property> findAll() {
		Collection<Property> result;

		result = propertyRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Property findOne(int propertyId) {
		Property result;

		result = propertyRepository.findOne(propertyId);

		return result;
	}

	public Property save(Property property) {
		Assert.notNull(property);

		return propertyRepository.save(property);
	}

	public void delete(Property property) {
		Assert.notNull(property);
		Assert.isTrue(property.getId() != 0);

		propertyRepository.delete(property);
	}
}
