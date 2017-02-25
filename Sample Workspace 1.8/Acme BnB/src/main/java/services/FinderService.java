
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.FinderRepository;
import domain.Finder;

@Service
@Transactional
public class FinderService {

	@Autowired
	private FinderRepository	finderRepository;


	public FinderService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Finder create() {
		Finder result;

		result = new Finder();
		return result;
	}

	public Collection<Finder> findAll() {
		Collection<Finder> result;

		result = finderRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Finder findOne(int finderId) {
		Finder result;

		result = finderRepository.findOne(finderId);

		return result;
	}

	public Finder save(Finder finder) {
		Assert.notNull(finder);

		return finderRepository.save(finder);
	}

	public void delete(Finder finder) {
		Assert.notNull(finder);
		Assert.isTrue(finder.getId() != 0);

		finderRepository.delete(finder);
	}
}
