package org.mitre.openid.connect.service.impl;

import org.mitre.openid.connect.model.User;
import org.mitre.openid.connect.repository.UserRepository;
import org.mitre.openid.connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
/*	for new user creation and while updating the password or enabled  */
	@Override
	public User saveOrUpdateUser(User user) {
		System.out.println("UserServiceImpl.createUser "+user.getUsername());
		getUserByUsername(user.getUsername());
		return userRepository.saveOrUpdateUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		System.out.println("UserServiceImpl.getUserByUsername "+username);
		return userRepository.getUserByUsername(username);
	}

}
