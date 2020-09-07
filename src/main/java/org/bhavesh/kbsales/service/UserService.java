package org.bhavesh.kbsales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.User;
import org.bhavesh.kbsales.bean.pojo.UserPOJO;
import org.bhavesh.kbsales.mapper.UserMapper;
import org.bhavesh.kbsales.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	UserRepository userrepo;
	UserMapper mapper;
	public UserService(UserRepository userrepo,UserMapper mapper) {
		this.userrepo = userrepo;
		this.mapper=mapper;
	}
	public UserPOJO getUserbyid(String name)
	{
		Optional<User> optUser=userrepo.findById(name);
		if(optUser.isPresent())
			return mapper.usertoUserPOJO(optUser.get());
		else
			return null;
	}
	public List<UserPOJO> getAllUser()
	{
		Iterable<User> iterable=userrepo.findAll();
		List<UserPOJO> list=new ArrayList<>();
		iterable.forEach(e-> list.add(mapper.usertoUserPOJO(e)));
		return list;
	}
}
