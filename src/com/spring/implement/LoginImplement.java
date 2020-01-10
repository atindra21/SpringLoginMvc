package com.spring.implement;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.bean.User;
import com.spring.dao.LoginDao;

public class LoginImplement implements LoginDao
{
	HibernateTemplate hibernateTemplate;
	
	Logger log = Logger.getLogger(LoginImplement.class);
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean isValidUser(String userid, String password) 
	{
		boolean check ;
		
		if (getByUsernameAndPassword(userid, password) != null)
		{
			log.info("user details present in our database.");
			check = true;
		}
		else {
			log.info("user details not found in database.");
			check = false;
		}
		return check;
	}
	
	@SuppressWarnings({"rawtypes"})
	public List getMessages(String username) 
	{
		log.info("username -> "+username);
		List messages = getHibernateTemplate().find("from Message where username = ?",username);
		log.info("list from db -> "+messages);
		return  messages;
	}
	@SuppressWarnings({"rawtypes"})
	public User getByUsernameAndPassword(String username, String password) 
	{
		Object[] params  = {username , password};
		List users = getHibernateTemplate().find("from User where username = ? and password = ?", params);
        if (users.size() == 1)
        {
            return (User) users.get(0);
        }
		return null;
	}
	public String getUserFullName(String userid) 
	{
		@SuppressWarnings({"unchecked" })
		List<User> users =(List<User>) getHibernateTemplate().find("from User where username = ?", userid);
        if (users.size() == 1)
        {
        	String name = users.get(0).getFirstname()+" "+users.get(0).getLastname();
        	log.info("Name of user is "+name);
            return name;
        }
		return null;
	}
}
