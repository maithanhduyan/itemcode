package com.itemcode.pos.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itemcode.pos.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE u.active = 1 AND u.username = :username")
	User findByUsername(@Param("username") String username);
}
