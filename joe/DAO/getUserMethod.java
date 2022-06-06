package dev.joe.DAO;

import dev.joe.ProjectDB.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getUserMethod implements UserDAO {
    String dbinfo = "jdbc:postgresql://localhost/postgres?user=postgres&password=password";
    @Override
    public User createUser(User user) {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "INSERT INTO landarch_app.app_users (firstname, lastname, username, password)"
            + "values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("Welcome to Terra Verde!");
            resultSet.next();
            int generatedId = resultSet.getInt("id");
            user.setId(generatedId);
            return user;

        } catch (SQLException e) {
            System.out.println("User creation failed.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "SELECT * FROM landarch_app.app_users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByFirstname(String firstname) {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "SELECT * FROM landarch_app.app_users WHERE firstname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByLastname(String lastname) {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "SELECT * FROM landarch_app.app_users WHERE lastname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lastname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "SELECT * FROM landarch_app.app_users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try(Connection connection = DriverManager.getConnection(dbinfo)) {
            String sql = "SELECT * FROM landarch_app.app_users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Something went wrong with the database.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(int id) {
        return null;
    }
}
