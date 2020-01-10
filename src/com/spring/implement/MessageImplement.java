package com.spring.implement;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.bean.Message;
import com.spring.dao.MessageDao;
import com.spring.specs.Validator;

public class MessageImplement implements MessageDao{
	Logger log = Logger.getLogger(MessageImplement.class);

	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(Message m) {
		if (Validator.isValidMessage(m)) {
			getHibernateTemplate().saveOrUpdate(m);
			log.info("message added");
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public List getMessages(String username) {
		log.info("username -> " + username);
		List messages = getHibernateTemplate().find("from Message where Username = ?", username);
		log.info("messages list from db -> " + messages);
		return messages;
	}
	
	public void delete(int id) {
		log.info("deleting message ");
		Message message = hibernateTemplate.load(Message.class, id);
		log.info(message.getId()+"-"+message.getName()+"-"+message.getMessage());
		getHibernateTemplate().delete(message);
		getHibernateTemplate().flush();
		log.info("message deleted");
	}
}
