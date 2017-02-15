
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/legalAdvise")
public class ConditionsController extends AbstractController {

	@RequestMapping("/TermsAndConditions")
	public ModelAndView termsAndConditions() {
		ModelAndView result;

		result = new ModelAndView("legalAdvise/TermsAndConditions");

		return result;
	}

	@RequestMapping("/commercialRegister")
	public ModelAndView commercialRegistar() {
		ModelAndView result;

		result = new ModelAndView("legalAdvise/commercialRegister");

		return result;
	}
}
