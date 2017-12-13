package org.mitre.openid.connect.repository;

import java.util.Collection;

import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.openid.connect.model.User;

public interface UserRepository {

	public Collection<User> getAll();

	public User saveOrUpdateUser(User user);

	public User getUserByUsername(String username);

}
