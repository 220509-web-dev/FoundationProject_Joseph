package dev.joe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class SanityServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - SanityServlet initialized!");
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Init param, test-init-key: " +
                this.getServletConfig().getInitParameter("test-init-key"));
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Context param, test-context-key: " +
                this.getServletContext().getInitParameter("test-context-key"));
    }

    @Override
    public void destroy() {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - SanityServlet was destroyed.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - SanityServlet received a GET request.");
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Request URI: " + req.getRequestURI());
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Request method: " + req.getMethod());
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Request header, example: " + req.getHeader("example"));
        System.out.println("[LOG]: " + LocalDateTime.now() + " - Request query string: " + req.getQueryString());

        resp.setStatus(200);
        resp.setHeader("Content type", "text/plain");
        //resp.setHeader("example response header", "example response value");
        resp.getWriter().write("This is the response payload.");
    }
}
