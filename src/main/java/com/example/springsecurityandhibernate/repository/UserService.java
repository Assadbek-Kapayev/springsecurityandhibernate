package com.example.springsecurityandhibernate.repository;

import com.example.springsecurityandhibernate.model.User;
import com.example.springsecurityandhibernate.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

	List<User> findAll();

	User findById(long id);

	void update(long id, User user);

	void delete(long id);
}
