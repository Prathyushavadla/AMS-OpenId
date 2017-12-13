package org.mitre.openid.connect.service;

import org.mitre.openid.connect.model.User;

import org.springframework.stereotype.Service;


public interface UserService {

	public User saveOrUpdateUser(User User);
	
	public User getUserByUsername(String userName);
	
	
}
