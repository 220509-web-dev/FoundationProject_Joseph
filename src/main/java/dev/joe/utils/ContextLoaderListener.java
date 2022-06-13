package dev.joe.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.joe.DAO.UserDao;
import dev.joe.servlets.AuthServlet;
import dev.joe.servlets.TVServlet;
import dev.joe.servlets.UserServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("[LOG]: " + LocalDateTime.now() + " - Context Loader was initialized.");

        ObjectMapper mapper = new ObjectMapper();
        UserDao userDao = new UserDao();

        UserServlet userServlet = new UserServlet(mapper, userDao);
        TVServlet tvServlet = new TVServlet(mapper, userDao);
        AuthServlet authServlet = new AuthServlet(mapper);

        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users");
        context.addServlet("TVServlet", tvServlet).addMapping("/tvusers");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - The context was destroyed.");
    }
}
