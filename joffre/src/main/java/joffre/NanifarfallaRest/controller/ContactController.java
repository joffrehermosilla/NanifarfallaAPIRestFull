package joffre.NanifarfallaRest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joffre.NanifarfallaRest.constant.ViewConstant;
import joffre.NanifarfallaRest.model.ContactModel;
import joffre.NanifarfallaRest.model.Usuario;
import joffre.NanifarfallaRest.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	private static final Log LOGGER = LogFactory.getLog(UsurioController.class);

	@Autowired
	ContactService contactService;

	@GetMapping("/cancel")
	public String cancel() {

		return "redirect:/contacts/showcontacts";
	}

	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {

		ContactModel contactModel = new ContactModel();
		if (id != 0) {
			contactModel = contactService.getUsuarioModel(id);
		}

		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		model.addAttribute("result", 1);
		LOGGER.info("METHOD: addContact() --PARAMS: " + contactModel.toString());
		if (null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);

		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/contacts/showcontacts";

	}

	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}

	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}

}
