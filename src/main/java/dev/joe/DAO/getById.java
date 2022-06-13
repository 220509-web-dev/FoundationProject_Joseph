package dev.joe.DAO;

import dev.joe.models.User;

public class getById {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User id = userDao.getUserById(Integer.parseInt("id"));
        System.out.println(id);
    }
}