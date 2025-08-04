package com.Servlets;

import com.dao.CommentLikeDAO;
import com.dao.CommentLikeDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.CommentLike;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addcommentlike")
public class AddCommentLikeServlet extends HttpServlet {
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
        int commentId = (Integer) req.getAttribute("commentId");
        int postId = (Integer) req.getAttribute("postId");

        CommentLikeDAO commentLikeDAO = new CommentLikeDAOImpl();

        boolean likeExists = commentLikeDAO.checkIfLikeExists((new CommentLike(userId, commentId)));

        if (!likeExists)
            commentLikeDAO.addCommentLike(new CommentLike(userId, commentId));

        req.setAttribute("postId", (Integer) postId);
        req.getRequestDispatcher("home?operation=ViewAllComments").forward(req, resp);
    }
}
