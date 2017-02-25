
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.TenantRepository;
import security.LoginService;
import security.UserAccount;
import domain.Tenant;

@Service
@Transactional
public class TenantService {

	@Autowired
	private TenantRepository	tenantRepository;


	public TenantService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Tenant create() {
		Tenant result;

		result = new Tenant();
		return result;
	}

	public Collection<Tenant> findAll() {
		Collection<Tenant> result;

		result = tenantRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Tenant findOne(int tenantId) {
		Tenant result;

		result = tenantRepository.findOne(tenantId);

		return result;
	}

	public Tenant save(Tenant tenant) {
		Assert.notNull(tenant);

		return tenantRepository.save(tenant);
	}

	public void delete(Tenant tenant) {
		Assert.notNull(tenant);
		Assert.isTrue(tenant.getId() != 0);

		tenantRepository.delete(tenant);
	}

	// Other business methods -------------------------------------------------
	public Tenant findByPrincipal() {
		Tenant result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Tenant findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Tenant result;

		result = tenantRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}
