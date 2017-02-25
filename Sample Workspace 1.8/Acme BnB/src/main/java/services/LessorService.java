
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.LessorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;
import domain.Lessor;
import forms.LessorRegisterForm;

@Service
@Transactional
public class LessorService {

	@Autowired
	private LessorRepository	lessorRepository;
	@Autowired
	private UserAccountService	userAccountService;
	@Autowired
	private Validator			validator;


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

	public Lessor reconstruct(LessorRegisterForm lessorForm, BindingResult binding) {
		Lessor result = create();
		result.setName(lessorForm.getName());
		result.setSurname(lessorForm.getSurname());
		result.setPhone(lessorForm.getPhone());
		result.setEmail(lessorForm.getEmail());

		result.setPicture(lessorForm.getPicture());
		UserAccount userAccount = new UserAccount();
		Authority authority = new Authority();
		authority.setAuthority(authority.LESSOR);
		userAccount.addAuthority(authority);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password = encoder.encodePassword(lessorForm.getPassword(), null);
		userAccount.setUsername(lessorForm.getUserName());
		userAccount.setPassword(password);
		result.setUserAccount(userAccount);
		System.out.println(binding);
		validator.validate(result, binding);
		return result;
	}
	public LessorRegisterForm deconstruct(Lessor lessor) {
		LessorRegisterForm result = new LessorRegisterForm();
		result.setName(lessor.getName());
		result.setSurname(lessor.getSurname());
		result.setPhone(lessor.getPhone());
		result.setEmail(lessor.getEmail());
		result.setPicture(lessor.getPicture());
		return result;
	}

}
