package com.spring.controller;

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
import com.spring.bean.User;
import com.spring.dao.UserDao;
import com.spring.specs.ResponseProvider;
import com.spring.specs.SessionProvider;

@Controller
@Transactional
public class UserController {

	@Autowired
	UserDao dao;
	
	Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView displayRegisterPage()
	{
		log.info("Requesting register page");
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		return model;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView save(User u) 
	{
		log.info("saving new user to database");
		dao.save(u);
		ModelAndView model = new ModelAndView();
		String attributeValue = "Succefully logged in, login to continue ";
		model.addObject("newUserMessage", attributeValue);
		model.setViewName("login");
		return model;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public void viewUserDetails(HttpServletResponse response) {
		log.info("retriving user details");
		String username = SessionProvider.getSessionAttribute();
		log.info("listing details of - " + username);
		List list = dao.getUserDetails(username);
		ResponseProvider.getByteOfList(list, response);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public void getUsers(HttpServletResponse response){
		List list = dao.getUsers();
		ResponseProvider.getByteOfList(list, response);
	}
	
	@RequestMapping(value="/updatepassword",method =RequestMethod.POST)
	public ModelAndView updatePassword(@RequestParam String newPassword) {
		log.info("changing password");
		String username = SessionProvider.getSessionAttribute();
		dao.updatePassword(newPassword,username);
		log.info("password changed succesfully");
		return new ModelAndView("redirect:/userdetails");
	}
	
	@RequestMapping(value="/updateuser",method =RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam("firstname") String newFirstName,@RequestParam("lastname") String newLastName, @RequestParam("phone") String newPhone) {
		log.info("updating user details");
		String username = SessionProvider.getSessionAttribute();
		dao.updateUser(newFirstName,newLastName,newPhone,username);
		log.info("password changed succesfully");
		return new ModelAndView("redirect:/userdetails");
	}

}
