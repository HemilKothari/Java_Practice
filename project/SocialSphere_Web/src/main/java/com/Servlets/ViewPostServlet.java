package com.Servlets;

import com.dao.PostDAO;
import com.dao.PostDAOImpl;
import com.model.PostUserJoin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewposts")
public class ViewPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PostDAO postDAO = new PostDAOImpl();

        List<PostUserJoin> posts = postDAO.viewAllPost();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("viewpost.jsp").forward(req, resp);
    }
}
