package com.Servlets;

import com.dao.PostLikeDAO;
import com.dao.PostLikeDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.PostLike;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addpostlike")
public class AddPostLikeServlet extends HttpServlet {
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
        int postID = (Integer) req.getAttribute("postId");

        PostLikeDAO postLikeDAO = new PostLikeDAOImpl();

        boolean likeExists = postLikeDAO.checkIfLikeExists((new PostLike(userId, postID)));

        if (!likeExists)
            postLikeDAO.addPostLike(new PostLike(userId, postID));

        req.getRequestDispatcher("home?operation=ViewAllPosts").forward(req, resp);
    }
}
