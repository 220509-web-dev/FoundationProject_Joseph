package dev.joe.DAO;

import dev.joe.ProjectDB.User;

public class getByUsername {
    public static void main(String[] args) {
        UserDAO userDao = new getUserMethod();
        User b = userDao.getUserByUsername("msmylie89");
        System.out.println(b);
    }
}
