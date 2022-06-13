package dev.joe.DAO;

import dev.joe.models.User;

import java.util.List;

public interface DAOuser {

    User createUser(User user);
    User getUserById(int id);
    User getUserByFirstname(String firstname);
    User getUserByLastname(String lastname);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    User updateUser(User user);
    User deleteUser(int id);
}