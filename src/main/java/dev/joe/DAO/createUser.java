package dev.joe.DAO;

import dev.joe.models.User;

public class createUser {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("Sam", "Samson", "ssamson78", "password");
        userDao.createUser(user);
        System.out.println(user);
    }
}
