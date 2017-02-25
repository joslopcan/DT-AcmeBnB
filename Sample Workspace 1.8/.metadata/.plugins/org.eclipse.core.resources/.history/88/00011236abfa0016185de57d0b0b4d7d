
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.LessorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Lessor;

@Service
@Transactional
public class LessorService {

	@Autowired
	private LessorRepository	lessorRepository;


	public LessorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Lessor create() {
		Lessor result;

		result = new Lessor();
		return result;
	}

	public Collection<Lessor> findAll() {
		Collection<Lessor> result;

		result = lessorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Lessor findOne(int lessorId) {
		Lessor result;

		result = lessorRepository.findOne(lessorId);

		return result;
	}

	public Lessor save(Lessor lessor) {
		Assert.notNull(lessor);

		return lessorRepository.save(lessor);
	}

	public void delete(Lessor lessor) {
		Assert.notNull(lessor);
		Assert.isTrue(lessor.getId() != 0);

		lessorRepository.delete(lessor);
	}

	public Lessor findByPrincipal() {
		Lessor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Lessor findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Lessor result;

		result = lessorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}
