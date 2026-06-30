package com.itp.pppjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itp.pppjwt.model.DBUser;
import com.itp.pppjwt.repository.DBUserRepository;

@Service
public class MyUserDetailsServiceNew implements UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DBUser dbuser=dbUserRepository.findByUsername(username);
		
		if(dbuser==null)
			throw new UsernameNotFoundException("User does not exist");
		
		return new MyUserDecorator(dbuser);
	}

}
