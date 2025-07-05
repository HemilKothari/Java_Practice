package com.servlets;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String bookIdStr = req.getParameter("bookId");

        if (bookIdStr == null || bookIdStr.trim().isEmpty()) {
            resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
            return;
        }

        int bookId = 0;
        try {
            bookId = Integer.parseInt(bookIdStr.trim());
            if (bookId <= 0) {
                resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
            return;
        }

        BookDAO bookDAO = new BookDAOImpl();
        int deletedRows = bookDAO.delete(bookId);
        out.println(deletedRows + " rows deleted.");
    }
}
