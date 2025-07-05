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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String bookIdStr = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String bookPriceStr = req.getParameter("bookPrice");

        if (bookIdStr == null || bookIdStr.trim().isEmpty() || bookName == null || bookName.trim().isEmpty() || bookPriceStr == null || bookPriceStr.trim().isEmpty()) {
            resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
            return;
        }

        int bookId = 0;
        try {
            bookId = Integer.parseInt(bookPriceStr.trim());
            if (bookId <= 0) {
                resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
            return;
        }

        float bookPrice = 0;
        try {
            bookPrice = Float.parseFloat(bookPriceStr.trim());
            if (bookPrice <= 0) {
                resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("http://localhost:8080/Bookstore_Web/index.html");
            return;
        }

        BookDAO bookDAO = new BookDAOImpl();
        int updatedRows = bookDAO.update(new Book(bookId, bookName, bookPrice));
        out.println(updatedRows + " rows updated.");
    }
}
