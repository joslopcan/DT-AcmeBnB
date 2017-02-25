
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import security.UserAccount;
import security.UserAccountService;
import services.FinderService;
import services.TenantService;
import domain.Finder;
import domain.Tenant;
import forms.TenantRegisterForm;

@Controller
@RequestMapping("/tenant")
public class TenantController extends AbstractController {

	// Services
	@Autowired
	private TenantService		tenantService;
	@Autowired
	private UserAccountService	userAccountService;
	@Autowired
	private FinderService		finderService;


	//en este controlador solo se controla la creaci�n de tenant

	public TenantController() {
		super();
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Tenant tenant;
		tenant = tenantService.create();
		result = createEditModelAndView(tenant);
		return result;
	}

	//TODO por defecto el checkbox tiene que ser falso, preguntar jm

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(TenantRegisterForm tenantRegisterForm, BindingResult binding) {
		ModelAndView result;
		Tenant tenant;
		tenant = tenantService.reconstruct(tenantRegisterForm, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(tenant);
		} else {
			try {
				Finder finder = finderService.save(tenant.getFinder());
				tenant.setFinder(finder);
				UserAccount ua = userAccountService.save(tenant.getUserAccount());
				tenant.setUserAccount(ua);
				tenantService.save(tenant);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(tenant, "tenant.commit.error");
			}

		}
		return result;
	}

	protected ModelAndView createEditModelAndView(Tenant tenant) {
		ModelAndView result;

		result = createEditModelAndView(tenant, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Tenant tenant, String message) {
		ModelAndView result;
		TenantRegisterForm tenantRegisterForm = tenantService.deconstruct(tenant);
		result = new ModelAndView("tenant/edit");
		result.addObject("tenantRegisterForm", tenantRegisterForm);
		result.addObject("message", message);
		return result;

	}
}
