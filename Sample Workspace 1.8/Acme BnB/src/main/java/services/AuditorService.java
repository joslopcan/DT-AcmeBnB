
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AuditorRepository;
import domain.Auditor;

@Service
@Transactional
public class AuditorService {

	@Autowired
	private AuditorRepository	auditorRepository;


	public AuditorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Auditor create() {
		Auditor result;

		result = new Auditor();
		return result;
	}

	public Collection<Auditor> findAll() {
		Collection<Auditor> result;

		result = auditorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Auditor findOne(int auditorId) {
		Auditor result;

		result = auditorRepository.findOne(auditorId);

		return result;
	}

	public Auditor save(Auditor auditor) {
		Assert.notNull(auditor);

		return auditorRepository.save(auditor);
	}

	public void delete(Auditor auditor) {
		Assert.notNull(auditor);
		Assert.isTrue(auditor.getId() != 0);

		auditorRepository.delete(auditor);
	}

}
