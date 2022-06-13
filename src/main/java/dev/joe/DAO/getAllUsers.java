package dev.joe.DAO;

public class getAllUsers {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getAllUsers());
    }
}
