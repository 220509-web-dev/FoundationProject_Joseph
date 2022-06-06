package dev.joe.DAO;

import dev.joe.ProjectDB.User;

public class createUser {
    public static void main(String[] args) {
        UserDAO userDao = new getUserMethod();
        User user = new User("Sam", "Samson", "ssamson78", "password");
        userDao.createUser(user);
        System.out.println(user);
    }
}
