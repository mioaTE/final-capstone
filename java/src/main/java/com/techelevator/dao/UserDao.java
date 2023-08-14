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

    int findIdByUsername(String username);

    User getUserById(Long userId);

    List<User> findAll();

    User findByUsername(String username) throws UsernameNotFoundException;

    boolean create(String username, String password, String role);

//    int findIdByUsername(String name);
}
