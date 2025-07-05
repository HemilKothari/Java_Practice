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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String bookName = req.getParameter("bookName");
        String bookPriceStr = req.getParameter("bookPrice");

        if (bookName == null || bookName.trim().isEmpty() || bookPriceStr == null || bookPriceStr.trim().isEmpty()) {
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
        HttpSession session = req.getSession();
        BookDAO bookDAO = new BookDAOImpl();
        int insertedRows = bookDAO.insert(new Book(0, bookName, bookPrice));
        out.println(insertedRows + " rows inserted.");
    }
}
