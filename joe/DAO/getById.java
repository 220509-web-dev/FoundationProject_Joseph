package dev.joe.DAO;

import dev.joe.ProjectDB.User;

public class getById {
    public static void main(String[] args) {
        UserDAO userDao = new getUserMethod();
        User a = userDao.getUserById(3);
        System.out.println(a);
    }
}
