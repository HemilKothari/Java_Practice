package com.servlets;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/book")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        BookDAO bookDAO = new BookDAOImpl();
        String operation = req.getParameter("operation");
        int res = -1;
        String msg = "";
        switch (operation) {
            case "Add Book":
                res = bookDAO.insert(new Book(0, req.getParameter("bookName"), Float.parseFloat(req.getParameter("bookPrice"))));
                msg = res + " books inserted.";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("result.jsp").forward(req, resp);
                break;

            case "Update Book":
                res = bookDAO.update(new Book(Integer.parseInt(req.getParameter("bookId")), req.getParameter("bookName"), Float.parseFloat(req.getParameter("bookPrice"))));
                msg = res + " books updated.";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("result.jsp").forward(req, resp);
                break;

            case "Delete Book":
                res = bookDAO.delete(Integer.parseInt(req.getParameter("bookId")));
                msg = res + " books deleted.";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("result.jsp").forward(req, resp);
                break;

            case "View Books":
                List<Book> books = bookDAO.view();
                req.setAttribute("books", books);
                req.getRequestDispatcher("view.jsp").forward(req, resp);
                break;

            default: resp.sendRedirect("http://localhost:8080/Bookstore_Web_MVC/");

        }

    }
}
