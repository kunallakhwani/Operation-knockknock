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

import cse591.web.service.MessageAddService;
import cse591.web.utils.KnockSequence;
import cse591.web.dao.MessageDao;
import cse591.web.dto.Messages;


@Controller
public class MessageAddController {

	@Autowired
	private MessageAddService messageAddService;

	@Autowired
	private MessageDao messageDao;
	
	KnockSequence knockSequence = new KnockSequence();

	@RequestMapping(value = "/message/add", method = RequestMethod.GET)
	public String showPageInternal(Locale locale, Model model) {
		if(KnockSequence.secret != 1)
		knockSequence.sequenceCheck("2");
		System.out.println("Message add");
		return "messageAdd";
	}

	@RequestMapping(value = "/message/add", method = RequestMethod.POST)
	public String addUser(Locale locale, Model model, @Valid @ModelAttribute("Message") Messages message, BindingResult result, RedirectAttributes redirectAttributes) {
		if(KnockSequence.secret==1)
		message.setSecret(1);
		else if(KnockSequence.secret==0)
			message.setSecret(0);
		
		messageAddService.addMsg(message);
		
		System.out.println("Message added successfully.");
		return "messageAdd";
	}
	
	@RequestMapping(value = "/message/list", method = RequestMethod.GET)
	public String showMessageList(Model model) {
		if(KnockSequence.secret != 1)
		knockSequence.sequenceCheck("3");
		System.out.println("Message List");
		model.addAttribute("messages", messageAddService.showMessages());
		return "messageList";
	}

	
	
}
