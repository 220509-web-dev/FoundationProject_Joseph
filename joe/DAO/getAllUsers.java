package dev.joe.DAO;

import dev.joe.ProjectDB.User;

public class getAllUsers {
    public static void main(String[] args) {
        UserDAO userDao = new getUserMethod();
        System.out.println(userDao.getAllUsers());
    }
}
