package com.spring.dao;

import java.util.List;
import com.spring.bean.User;

public interface UserDao
{
	public void save(User u);

	@SuppressWarnings("rawtypes")
	public List getUserDetails(String username);

	@SuppressWarnings("rawtypes")
	public List getUsers();

	public void updatePassword(String newPassword,String username);

	public void updateUser(String newFirstName, String newLastName, String newPhone, String username);

}
