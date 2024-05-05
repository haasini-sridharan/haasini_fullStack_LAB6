package com.GreatLearning.Lab6.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GreatLearning.Lab6.Backend.Entity.User;
import com.GreatLearning.Lab6.Backend.Repository.UserRepository;

@Service
public class FullInfoUser implements UserDetailsService {

	@Autowired
	UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = null;
		user = userrepo.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Name not found in the records");

		return new UserInfo(user);
	}

}
