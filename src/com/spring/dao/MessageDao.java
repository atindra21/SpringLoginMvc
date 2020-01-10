package com.spring.dao;

import java.util.List;
import com.spring.bean.Message;

public interface MessageDao {

	public void save(Message m);
	
	public void delete(int id);

	@SuppressWarnings({ "rawtypes" })
	public List getMessages(String username);
}
