package com.spring.dao;

import java.util.List;
import com.spring.bean.User;

public interface LoginDao
{
	public boolean isValidUser(String userid, String password);
	
	@SuppressWarnings("rawtypes")
	public List getMessages(String username);
	
	public User getByUsernameAndPassword(String username, String password);
	
	public String getUserFullName(String userid);
}
