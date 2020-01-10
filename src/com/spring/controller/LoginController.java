package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.LoginDao;
import com.spring.specs.SessionProvider;

@Controller
public class LoginController {

	Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	LoginDao dao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		log.info("Requesting login page");
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(HttpServletRequest request) {
		log.info("checking login");
		String userid = request.getParameter("uid");
		String password = request.getParameter("pswd");
		log.info(userid + " user-> " + password);
		ModelAndView model = new ModelAndView();
		try {
			boolean isValidUser = dao.isValidUser(userid, password);
			if (isValidUser) {
				log.info("User Login Successful");
				String userFullName = dao.getUserFullName(userid);
				model.addObject("userFullName", userFullName);
				model.setViewName("message");
				log.info("passing session");
				SessionProvider.setSession(request,userid);
			} else {
				log.error("invalid credentials");
				model.setViewName("login");
			}
		} catch (Exception e) {
			log.info("Exception arose while login.",e);
		}
		return model;
	}
}
