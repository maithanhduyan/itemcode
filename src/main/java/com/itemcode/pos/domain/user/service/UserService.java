package com.itemcode.pos.domain.user.service;

import com.itemcode.pos.domain.user.entity.User;

public interface UserService {
	User findByUsername(String username);
	User createNewUser(String username, String encryptPassword);
}
