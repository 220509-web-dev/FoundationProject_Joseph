package dev.joe.DAO;

import dev.joe.models.User;

public class getByUsername {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User b = userDao.getUserByUsername("msmylie89");
        System.out.println(b);
    }
}
