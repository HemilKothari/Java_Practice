package com.Servlets;

import com.dao.CommentDAO;
import com.dao.CommentDAOImpl;
import com.model.CommentUserJoin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewcomments")
public class ViewCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CommentDAO commentDAO = new CommentDAOImpl();

        int postID = (Integer) req.getAttribute("postId");
        List<CommentUserJoin> comments = commentDAO.viewComments(postID);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("viewcomments.jsp").forward(req, resp);
    }
}
