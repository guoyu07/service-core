package com.panthole.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.panthole.domain.User;


@Repository
public class UserDao {
	private static final Logger LOGGER = Logger.getLogger(UserDao.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	public UserDao(){
		
	}
	
	@Transactional
    public User store(final User entity) {
        return entityManager.merge(entity);
    }
	
	public User findById(final String id) {
        Assert.notNull(id);
        try {
            return entityManager.find(User.class, id);
        } catch (final Exception e) {
        	UserDao.LOGGER.error(e);
            return null;
        }
    }
}
