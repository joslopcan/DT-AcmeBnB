
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import security.UserAccount;
import security.UserAccountService;
import services.LessorService;
import domain.Lessor;
import forms.LessorRegisterForm;

@Controller
@RequestMapping("/lessor")
public class LessorController extends AbstractController {

	// Services
	@Autowired
	private LessorService		lessorService;
	@Autowired
	private UserAccountService	userAccountService;


	//en este controlador solo se controla la creaci�n de lessor

	public LessorController() {
		super();
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Lessor lessor;
		lessor = lessorService.create();
		result = createEditModelAndView(lessor);
		return result;
	}

	//TODO por defecto el checkbox tiene que ser falso, preguntar jm

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(LessorRegisterForm lessorRegisterForm, BindingResult binding) {
		ModelAndView result;
		Lessor lessor;
		lessor = lessorService.reconstruct(lessorRegisterForm, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(lessor);
		} else {
			try {
				UserAccount ua2 = userAccountService.save(lessor.getUserAccount());
				lessor.setUserAccount(ua2);
				lessorService.save(lessor);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(lessor, "lessor.commit.error");
			}

		}
		return result;
	}

	protected ModelAndView createEditModelAndView(Lessor lessor) {
		ModelAndView result;

		result = createEditModelAndView(lessor, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Lessor lessor, String message) {
		ModelAndView result;
		LessorRegisterForm lessorRegisterForm = lessorService.deconstruct(lessor);
		result = new ModelAndView("lessor/edit");
		result.addObject("lessorRegisterForm", lessorRegisterForm);
		result.addObject("message", message);
		return result;

	}
}