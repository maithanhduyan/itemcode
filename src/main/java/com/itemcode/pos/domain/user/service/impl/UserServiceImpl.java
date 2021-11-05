package com.itemcode.pos.domain.user.service.impl;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itemcode.pos.domain.user.entity.User;
import com.itemcode.pos.domain.user.repository.UserRepository;
import com.itemcode.pos.domain.user.service.UserService;
import com.itemcode.pos.utils.EncrytedPasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User createNewUser(String username, String encryptPassword) {
		User user = new User();
		try {

			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setEncrytedPassword(new BCryptPasswordEncoder().encode(encryptPassword));
			user.setActive(1);
			user.setCreatedBy("SYSTEM");
			user.setCreatedDate(new Date());
			user.setDescription("");
			User saveUser = userRepository.save(user);
			return saveUser;
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		return null;
	}

	public User createNewUser(String username, String encryptPassword, String description, String createdById) {
		User user = new User();
		try {

			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(encryptPassword));
			user.setActive(1);
			user.setCreatedBy("SYSTEM");
			user.setCreatedDate(new Date());
			user.setDescription("");
			User saveUser = userRepository.save(user);
			return saveUser;
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		return null;
	}

}
