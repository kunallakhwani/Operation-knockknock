package cse591.web.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cse591.web.service.RegisterUserService;
import cse591.web.utils.KnockSequence;
import cse591.web.dao.*;
import cse591.web.dto.RegisterUser;

@Controller
public class RegisterController {

	@Autowired
	private RegisterUserService registerUserService;

	@Autowired
	private RegisterDao registerDao;

	KnockSequence knockSequence = new KnockSequence();
	
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String showPageInternal(Locale locale, Model model) {
		if(KnockSequence.secret != 1)
		knockSequence.sequenceCheck("0");
		return "register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String addUser(Locale locale, Model model, @Valid @ModelAttribute("User") RegisterUser user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(registerUserService.existsUser(user.getUsername())){
			redirectAttributes.addFlashAttribute("error", "User already exists.");
			return "redirect:/user/register";
		}
		else {
			registerUserService.addUser(user);
		System.out.println("User registered successfully.");
		}
		return "login";
	}

}
