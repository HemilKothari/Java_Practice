package com.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/home")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String operation = req.getParameter("operation");

        switch (operation) {
            case "Register":
                req.setAttribute("userName", req.getParameter("userName"));
                req.setAttribute("userEmail", req.getParameter("userEmail"));
                req.setAttribute("userPassword", req.getParameter("userPassword"));
                req.getRequestDispatcher("register").forward(req,resp);
                break;

            case "Login":
                req.setAttribute("userName", req.getParameter("userName"));
                req.setAttribute("userPassword", req.getParameter("userPassword"));
                req.getRequestDispatcher("login").forward(req,resp);
                break;

            case "dashboard" :
                resp.sendRedirect("dashboard.jsp");
                break;

            case "Create Post":
                req.setAttribute("postTitle", req.getParameter("postTitle"));
                req.setAttribute("postContent", req.getParameter("postContent"));
                req.getRequestDispatcher("createpost").forward(req, resp);
                break;

            case "ViewAllPosts":
                req.getRequestDispatcher("viewposts").forward(req, resp);
                break;

            case "Logout":
                req.getRequestDispatcher("logout").forward(req, resp);
                break;

            case "Add Comment":
                req.setAttribute("postId",Integer.parseInt(req.getParameter("postId")));
                req.setAttribute("commentContent", req.getParameter("commentContent"));
                req.getRequestDispatcher("addcomment").forward(req, resp);
                break;

            case "ViewAllComments":
                req.setAttribute("postId",Integer.parseInt(req.getParameter("postId")));
                req.getRequestDispatcher("viewcomments").forward(req, resp);
                break;

            case "AddPostLike":
                req.setAttribute("postId",Integer.parseInt(req.getParameter("postId")));
                req.getRequestDispatcher("addpostlike").forward(req, resp);
                break;

            case "AddCommentLike":
                req.setAttribute("commentId",Integer.parseInt(req.getParameter("commentId")));
                req.setAttribute("postId",Integer.parseInt(req.getParameter("postId")));
                req.getRequestDispatcher("addcommentlike").forward(req, resp);
                break;


            default:
                resp.sendRedirect("http://localhost:8080/SocialSphere_Web/");
        }
    }
}
