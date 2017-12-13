package org.mitre.openid.connect.repository.impl;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.openid.connect.model.BlacklistedSite;
import org.mitre.openid.connect.model.User;
import org.mitre.openid.connect.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaUserRepository implements UserRepository{
	
	@PersistenceContext(unitName="defaultPersistenceUnit")
	private EntityManager manager;

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<User> getAll() {
		TypedQuery<User> query = manager.createNamedQuery("select a from User a", User.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public User saveOrUpdateUser(User user) {
		System.out.println("JpaUserRepository.save "+user.getUsername());
		return saveOrUpdate(user.getUsername(), manager, user);
	}
	@Override
	@Transactional(value="defaultTransactionManager")
	public  User getUserByUsername(String username)
	{
		System.out.println("JpaUserRepository.getUserByUsername "+username);
		return manager.find(User.class, username);
		
	}

}
