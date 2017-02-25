
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AuditRepository;
import domain.Audit;

@Service
@Transactional
public class AuditService {

	@Autowired
	private AuditRepository	auditRepository;


	public AuditService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Audit create() {
		Audit result;

		result = new Audit();
		return result;
	}

	public Collection<Audit> findAll() {
		Collection<Audit> result;

		result = auditRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Audit findOne(int auditId) {
		Audit result;

		result = auditRepository.findOne(auditId);

		return result;
	}

	public Audit save(Audit audit) {
		Assert.notNull(audit);

		return auditRepository.save(audit);
	}

	public void delete(Audit audit) {
		Assert.notNull(audit);
		Assert.isTrue(audit.getId() != 0);

		auditRepository.delete(audit);
	}
}
