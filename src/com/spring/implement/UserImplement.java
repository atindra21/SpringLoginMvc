package com.spring.implement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.bean.User;
import com.spring.dao.UserDao;

public class UserImplement implements UserDao {
	
	HibernateTemplate hibernateTemplate;
	Logger log = Logger.getLogger(UserImplement.class);
		
	public void save(User u) 
	{
		log.info("saving using htemp -> "+ u.getFirstname());
		getHibernateTemplate().saveOrUpdate(u);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("rawtypes")
	public List getUserDetails(String username) {
		List userDetails = getHibernateTemplate().find("from User where username = ?", username);
		log.info("list from db -> " + userDetails);
		if(userDetails != null )
			return userDetails;
		else {
			log.info("Unable to fetch user details from database.");
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public List getUsers() {
		List users = getHibernateTemplate().find("select username from User");
		log.info("list of users from db -> " + users);
		if(users != null )
			return users;
		else {
			log.info("Unable to fetch usernames from database.");
			return null;
		}
	}

	@Override
	public void updatePassword(String newPassword,String username) 
	{
		log.info("change password to "+ newPassword);
		getHibernateTemplate().bulkUpdate("Update User set password = ? where username =?",newPassword,username);
	}

	@Override
	public void updateUser(String newFirstName, String newLastName, String newPhone, String username) {
		log.info("updating user information of "+ username);
		String query = "Update User set firstname=? set lastname=? set phone =? where username =?";
		getHibernateTemplate().bulkUpdate(query,newFirstName,newLastName,newPhone,username);
		log.info("user details updated");
	}
}
