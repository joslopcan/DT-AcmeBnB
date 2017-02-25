
package services;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.TenantRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Finder;
import domain.Tenant;
import forms.TenantRegisterForm;

@Service
@Transactional
public class TenantService {

	@Autowired
	private TenantRepository	tenantRepository;
	@Autowired
	private Validator			validator;
	@Autowired
	private FinderService		finderService;


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

	//TODO para validar mas de un objeto?
	public Tenant reconstruct(TenantRegisterForm tenantForm, BindingResult binding) {
		Tenant result = create();
		result.setName(tenantForm.getName());
		result.setSurname(tenantForm.getSurname());
		result.setPhone(tenantForm.getPhone());
		result.setEmail(tenantForm.getEmail());
		result.setPicture(tenantForm.getPicture());

		UserAccount userAccount = new UserAccount();
		Authority authority = new Authority();
		authority.setAuthority(authority.TENANT);
		userAccount.addAuthority(authority);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password = encoder.encodePassword(tenantForm.getPassword(), null);
		userAccount.setUsername(tenantForm.getUserName());
		userAccount.setPassword(password);
		result.setUserAccount(userAccount);

		Date d = new Date(2L);
		Finder finder = finderService.create();
		finder.setDestinationCity(tenantForm.getDestinationCity());
		finder.setMaximumPrice(tenantForm.getMaximumPrice());
		finder.setMinimumPrice(tenantForm.getMinimumPrice());
		finder.setKeyword(tenantForm.getKeyword());
		finder.setSearchMoment(d);
		result.setFinder(finder);

		validator.validate(result, binding);
		return result;
	}
	public TenantRegisterForm deconstruct(Tenant tenant) {
		TenantRegisterForm result = new TenantRegisterForm();
		result.setName(tenant.getName());
		result.setSurname(tenant.getSurname());
		result.setPhone(tenant.getPhone());
		result.setEmail(tenant.getEmail());
		result.setPicture(tenant.getPicture());
		return result;
	}
}
