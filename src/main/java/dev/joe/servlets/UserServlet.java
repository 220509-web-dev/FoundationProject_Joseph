package dev.joe.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.joe.DAO.UserDao;
import dev.joe.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final UserDao userDao;
    public UserServlet (ObjectMapper mapper, UserDao userDao) {
        this.mapper = mapper;
        this.userDao = userDao;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG}: " + LocalDateTime.now() + " - UserServlet initiated.");
        System.out.println("[LOG}: " + LocalDateTime.now() + " - Init param, test init key: " +
                this.getServletConfig().getInitParameter("test init key!"));
        System.out.println("[LOG}: " + LocalDateTime.now() + " - Context param, test context key: " +
                this.getServletContext().getInitParameter("test context key!"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - UserServlet received a GET request.");
        System.out.println("[LOG]: Was request filtered? " + req.getAttribute("was-filtered"));

        String request = req.getQueryString();
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        try {
            if (request.equals("id=" + id)) {
                UserDao userDao = new UserDao();
                User user = userDao.getUserById(Integer.parseInt(id));
                String respPayload = mapper.writeValueAsString(user);
                resp.setContentType("application/JSON");
                resp.getWriter().write(respPayload);
            } else if (request.equals("username=" + username)) {
                UserDao userDao = new UserDao();
                User user = userDao.getUserByUsername(username);
                String respPayload = mapper.writeValueAsString(user);
                resp.setContentType("application/JSON");
                resp.getWriter().write(respPayload);
            } else if (request.equals("firstname=" + firstname)) {
                UserDao userDao = new UserDao();
                User user = userDao.getUserByFirstname(firstname);
                String respPayload = mapper.writeValueAsString(user);
                resp.setContentType("application/JSON");
                resp.getWriter().write(respPayload);
            } else if (request.equals("lastname=" + lastname)) {
                UserDao userDao = new UserDao();
                User user = userDao.getUserByLastname(lastname);
                String respPayload = mapper.writeValueAsString(user);
                resp.setContentType("application/JSON");
                resp.getWriter().write(respPayload);
            } else {
                List<User> users = userDao.getAllUsers();
                String respPayload = mapper.writeValueAsString(users);
                resp.setContentType("application/JSON");
                resp.getWriter().write(respPayload);
            }
        } catch (Exception e) {
            System.err.println("Failed to retrieve user credentials.");
            throw e;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - UserServlet received a POST request.");

        try {
            ObjectMapper mapper = new ObjectMapper();
            User newUser = mapper.readValue(req.getInputStream(), User.class);
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setStatus(204);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
