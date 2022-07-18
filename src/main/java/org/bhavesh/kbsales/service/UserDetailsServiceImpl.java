package org.bhavesh.kbsales.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.bhavesh.kbsales.bean.Authorities;
import org.bhavesh.kbsales.bean.User;
import org.bhavesh.kbsales.repository.AuthoritiesRepository;
import org.bhavesh.kbsales.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthoritiesRepository authRepository;
	
	Logger logger=LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username)
	{
		logger.debug("Username provided is {}",username);
		Optional<User> user= userRepository.findById(username);
		if(user.isEmpty())
		{
			logger.debug("User is null");
			throw new UsernameNotFoundException("Username or password is incorrect");
		}
		return user.get();
	}
	
	public Set<String> getAllAuthorities()
	{
		Iterable<Authorities> authlist=authRepository.findAll();
		HashSet<String> hashset=new HashSet<>();
		authlist.forEach( auth -> hashset.add(auth.getAuthority()));
		return hashset;
	}
	
	public void save(String username,String password,String authority)
	{
		Authorities authorities=new Authorities(authority);
		List<Authorities> authortity =new ArrayList<>();
		authortity.add(authorities);
		User user=new User(username,new BCryptPasswordEncoder(8).encode(password),authortity);
		authorities.setUser(user);
		authRepository.save(authorities);
		userRepository.save(user);
		logger.debug(user.getUsername());

	}
	public void update(String username,String password) 
	{
		logger.debug("Update passoword for {}",username);
		Optional<User> optuser=userRepository.findById(username);
		if(optuser.isPresent())
		{
		User user=optuser.get();
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		userRepository.save(user);
		}
	}
	
	public List<String> getAllUsername()
	{
		Iterable<User> userlist=userRepository.findAll();
		ArrayList<String> usernames=new ArrayList<>();
		for(User user : userlist)
		{	
			usernames.add(user.getUsername());
		}
		return usernames;
	}
}
