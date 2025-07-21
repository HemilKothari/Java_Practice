package com.Servlets;

import com.dao.*;
import com.model.Comment;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addcomment")
public class AddCommentServlet extends HttpServlet {
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
        String commentContent = (String) req.getAttribute("commentContent");

        CommentDAO commentDAO = new CommentDAOImpl();
        commentDAO.addComment(new Comment(commentContent, userId, postID));
        req.getRequestDispatcher("home?operation=ViewAllPosts").forward(req, resp);
    }
}
