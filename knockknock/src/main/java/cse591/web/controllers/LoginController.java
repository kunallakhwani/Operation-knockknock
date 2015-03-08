package cse591.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cse591.web.utils.KnockSequence;


@Controller
public class LoginController {

	
	KnockSequence knockSequence = new KnockSequence();
	
	@RequestMapping(value="/")
	public String home(Model model) {
		System.out.println("Home");
		return "home";
	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = exception.getMessage();
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "User is not valid or has not yet been enabled";
		}

		return error;
	}
	
	@RequestMapping("/user/login")
	public String showLogin(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request, Model model) {
		
		
		if (error != null) {
			model.addAttribute("error",
					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		System.out.println("Login");
		if (error == null && logout == null && KnockSequence.secret != 1) {
			knockSequence.sequenceCheck("1");
		}
		return "login";
	}

	@RequestMapping("/secure/dologin")
	public String doLogin() {

		return "success";

	}
	
	@RequestMapping(value="/loginerror")
	public String showErrors(RedirectAttributes redirectAttributes,HttpServletRequest request){
		
		redirectAttributes.addFlashAttribute("error",
				getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied() {

		return "403";

	}
	@RequestMapping("/user/logout")
	public String showLogout(HttpServletRequest request, RedirectAttributes redirect, HttpSession session, HttpServletResponse response)
	{
		System.out.println("logout");

		KnockSequence.sequence="";
		KnockSequence.secret=0;
		KnockSequence.knock="";
		redirect.addFlashAttribute("msg", "You've been logged out successfully.");
		return "redirect:/user/login";
	}
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String success(Model model) {
		KnockSequence.flag++;
		System.out.println("Flag:" +KnockSequence.flag);
		
		if(KnockSequence.flag != 0) {
			KnockSequence.secret=0;
			KnockSequence.knock="";
		}
		return "success";
	}
}
