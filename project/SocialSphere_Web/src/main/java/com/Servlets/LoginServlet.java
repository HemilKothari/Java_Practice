package com.Servlets;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String userName = (String) req.getAttribute("userName");
        String userPassword = (String) req.getAttribute("userPassword");

        UserDAO userDAO = new UserDAOImpl();

        boolean found = userDAO.loginUser(new User(userName, userPassword));
        if (!found) {
            resp.sendRedirect("http://localhost:8080/SocialSphere_Web/");
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("userName", userName);
        System.out.println("Session set for user: " + session.getAttribute("userName"));

        req.getRequestDispatcher("home?operation=dashboard").forward(req, resp);

    }
}
