package dev.joe.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.joe.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class AuthServlet extends HttpServlet {

    private final ObjectMapper mapper;

    public AuthServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(401);
            resp.setContentType("application/JSON");
            HashMap<String, Object> errormessage = new HashMap<>();
            errormessage.put("code: ", 401);
            errormessage.put("Message: ", "No session found.");
            errormessage.put("Timesstamp: ", LocalDateTime.now().toString());

            resp.setStatus(401);
            resp.setContentType("application/JSON");
            resp.getWriter().write(mapper.writeValueAsString(errormessage));
            return;
        }
        System.out.println("[LOG]: - Session found!");
        System.out.println("[LOG]: - Session details: " + session.getAttribute("auth user"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);
        String providedFirstname = (String) credentials.get("firstname");
        String providedLastname = (String) credentials.get("lastname");
        String providedUsername = (String) credentials.get("username");
        String providedPassword = (String) credentials.get("password");

        for (User user : users) {
            if (providedFirstname.equals(user.getFirstname()) && providedLastname.equals(user.getLastname()) && providedUsername.equals(user.getUsername())) {
                System.out.println("[LOG]: - found user!");

                HttpSession session = req.getSession();
                session.setAttribute("auth user: ", user);

                resp.setStatus(204);
                return;
            }
        }
        resp.setStatus(400);
        resp.setContentType("application/JSON");
        HashMap<String, Object> errormessage = new HashMap<>();
        errormessage.put("code: ", 400);
        errormessage.put("Message: ", "Invalid credentials. User not found.");
        errormessage.put("Timesstamp: ", LocalDateTime.now().toString());

        resp.getWriter().write(mapper.writeValueAsString(errormessage));
*/    }
}
