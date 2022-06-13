package dev.joe.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.joe.DAO.UserDao;
import dev.joe.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class TVServlet extends HttpServlet {

    private final UserDao userDao;
    private final ObjectMapper mapper;
    public TVServlet (ObjectMapper mapper, UserDao userDao) {
        this.mapper = mapper;
        this.userDao = userDao;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet was initialized.");
        System.out.println("[LOG}: " + LocalDateTime.now() + " - Init param, test init key: " +
                this.getServletConfig().getInitParameter("test init key!"));
        System.out.println("[LOG}: " + LocalDateTime.now() + " - Context param, test context key: " +
                this.getServletContext().getInitParameter("test context key!"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet received a GET request.");
        System.out.println("[LOG]: Was request filtered? " + req.getAttribute("was-filtered"));

        List<User> users = userDao.getAllUsers();
        String respPayload = mapper.writeValueAsString(users);
        resp.setContentType("application/JSON");
        resp.getWriter().write(respPayload);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet received a POST request.");
        System.out.println("[LOG]: Was request filtered? " + req.getAttribute("was-filtered"));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet received a PUT request.");
        System.out.println("[LOG]: Was request filtered? " + req.getAttribute("was-filtered"));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet received a DELETE request.");
        System.out.println("[LOG]: Was request filtered? " + req.getAttribute("was-filtered"));

    }

    @Override
    public void destroy() {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - TVServlet was destroyed.");
    }
}
