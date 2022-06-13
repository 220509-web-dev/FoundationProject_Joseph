package dev.joe.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class CustomFilter extends HttpFilter {

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - CustomFilter initialized.");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("[LOG]: " + LocalDateTime.now() + " - CustomFilter intercepted web request.");
        req.setAttribute("was-filtered", true);
        resp.setHeader("example response header", "some example value");
        chain.doFilter(req, resp);

    }
}
