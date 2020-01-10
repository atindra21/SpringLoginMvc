package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.Message;
import com.spring.dao.MessageDao;
import com.spring.specs.ResponseProvider;
import com.spring.specs.SessionProvider;

@Controller
@Transactional
public class MessageController {

	@Autowired
	MessageDao dao;

	Logger log = Logger.getLogger(MessageController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Message m) throws IOException {
		log.info("saving messages");
		String username = SessionProvider.getSessionAttribute();
		m.setUsername(username);
		dao.save(m);
		return new ModelAndView("redirect:/message");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam String id){
		log.info("deleting message in controller");
		dao.delete(Integer.parseInt(id));
		log.info("deletion done");
		return new ModelAndView("redirect:/message");
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public void viewmessage(HttpServletResponse response) throws IOException {
		String username = SessionProvider.getSessionAttribute();
		log.info("executing view messages- " + username);
		List list = dao.getMessages(username);
		ResponseProvider.getByteOfList(list, response);
	}
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView displayLogin() {
		log.info("Requesting settngs page");
		ModelAndView model = new ModelAndView();
		model.setViewName("settings");
		return model;
	}
}
