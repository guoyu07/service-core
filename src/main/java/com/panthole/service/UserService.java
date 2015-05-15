package com.panthole.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panthole.dao.UserDao;
import com.panthole.domain.User;

@Service
public class UserService {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

	public UserService() {
	}

	public User saveUser(final User user) {
		return userDao.store(user);
	}
	
	 public User getUser(final String userId) {
	        try {
	            return userDao.findById(userId);
	        } catch (final Exception e) {
	            UserService.LOGGER.error(e);
	            return null;
	        }
	    }
}
