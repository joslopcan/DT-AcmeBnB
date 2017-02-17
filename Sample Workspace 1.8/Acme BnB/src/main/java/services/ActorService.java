
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	@Autowired
	private ActorRepository	actorRepository;


	public ActorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Actor create() {
		Actor result;

		result = new Actor();
		return result;
	}

	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = actorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Actor findOne(int actorId) {
		Actor result;

		result = actorRepository.findOne(actorId);

		return result;
	}

	public void save(Actor actor) {
		Assert.notNull(actor);

		actorRepository.save(actor);
	}

	public void delete(Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(actor.getId() != 0);

		actorRepository.delete(actor);
	}

	// Other business methods -------------------------------------------------
	public Actor findByPrincipal() {
		Actor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Actor findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Actor result;

		result = actorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

}
