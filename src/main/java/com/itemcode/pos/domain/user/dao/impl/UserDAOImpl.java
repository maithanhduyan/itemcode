package com.itemcode.pos.domain.user.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itemcode.pos.domain.user.dao.UserDAO;
import com.itemcode.pos.domain.user.entity.User;

@Repository
@Transactional
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public User findUserAccount(String userName) {
		try {

		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
