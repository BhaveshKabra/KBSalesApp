package org.bhavesh.kbsales.service;

import java.util.Optional;

import org.bhavesh.kbsales.bean.User;
import org.bhavesh.kbsales.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	UserRepository userrepo;

	public UserService(UserRepository userrepo) {
		this.userrepo = userrepo;
	}
	public User getUserbyid(String name)
	{
		Optional<User> optUser=userrepo.findById(name);
		if(optUser.isPresent())
			return optUser.get();
		else
			return null;
	}
}
