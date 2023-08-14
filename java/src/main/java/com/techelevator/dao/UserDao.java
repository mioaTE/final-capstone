package com.techelevator.dao;

import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByUsername (String name);

    User createUser(RegisterUserDto user);

}
