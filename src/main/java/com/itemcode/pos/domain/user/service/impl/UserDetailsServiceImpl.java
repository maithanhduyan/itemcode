package com.itemcode.pos.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itemcode.pos.domain.user.entity.User;
import com.itemcode.pos.domain.user.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		UserDetails userDetails = null;
		try {
			user = userService.findByUsername(username);
			if (user == null) {
				System.out.println("User not found " + username + "!");
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}

			// [ROLE_USER, ROLE_ADMIN,..]
			List<String> roleNames = new ArrayList<>();
			roleNames.add("ROLE_USER");

			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

			userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), //
					user.getEncrytedPassword(), grantList);
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		return userDetails;
	}

}
