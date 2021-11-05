package com.itemcode.pos.domain.user.dao;

import com.itemcode.pos.domain.user.entity.User;

public interface UserDAO {

	User findUserAccount(String userName);

}
