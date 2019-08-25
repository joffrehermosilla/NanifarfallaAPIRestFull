package joffre.NanifarfallaRest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import joffre.NanifarfallaRest.constant.ViewConstant;
import joffre.NanifarfallaRest.model.UserCredential;


@Controller
public class LoginController {

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		LOGGER.info("METHOD: redirectToLoging()");
		
		return "redirect/Login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOGGER.info("METHOD: showLoginForm() --PARAMS: error="+ error +" ,logout:" +logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCrendentials", new UserCredential());
		LOGGER.info("Returning to Login view");
		return ViewConstant.LOGIN;
	}

	@PostMapping("/logincheck")
	public String LoginCheck(@ModelAttribute(name = "userCrendentials") UserCredential usercredential) {
		LOGGER.info("METHOD: LoginCheck() --PARAMS: "+ usercredential.toString());
		if (usercredential.getUsername().equals("user") && usercredential.getPassword().equals("user")) {
			LOGGER.info("Returning to Contacts view");
			
			return "redirect:/contacts/showcontacts";

		}
		LOGGER.info("Redirect to login?error");
		return "redirect:/login?error";
	}

}
