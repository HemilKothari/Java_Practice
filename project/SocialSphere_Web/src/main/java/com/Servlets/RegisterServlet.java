package com.Servlets;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String userName = (String) req.getAttribute("userName");
        String userEmail = (String) req.getAttribute("userEmail");
        String userPassword = (String) req.getAttribute("userPassword");

        UserDAO userDAO = new UserDAOImpl();

        boolean found = userDAO.checkIfUserExists(new User(userName));

        if (found) {
            resp.sendRedirect("http://localhost:8080/SocialSphere_Web/");
            return;
        }

        userDAO.addUser(new User(0, userName, userEmail, userPassword));
        resp.sendRedirect("login.html");
    }
}
