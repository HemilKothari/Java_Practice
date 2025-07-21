package com.Servlets;

import com.dao.PostDAO;
import com.dao.PostDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.Post;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/createpost")
public class CreatePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);

        UserDAO userDAO = new UserDAOImpl();
        int userId = userDAO.getUserIdFromName(new User((String) session.getAttribute("userName")));
        if (userId <= 0) {
            resp.sendRedirect("http://localhost:8080/SocialSphere_Web/");
            return;
        }
        String postTitle = (String) req.getAttribute("postTitle");
        String postContent = (String) req.getAttribute("postContent");

        PostDAO postDAO = new PostDAOImpl();
        postDAO.addPost(new Post(postTitle, postContent, userId));
        req.getRequestDispatcher("home?operation=dashboard").forward(req, resp);
    }
}
