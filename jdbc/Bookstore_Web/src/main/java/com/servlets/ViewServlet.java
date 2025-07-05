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
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        BookDAO bookDAO = new BookDAOImpl();
        List<Book> allBooks = bookDAO.view();

        out.println("<h2>Books List</h2>");
        out.println("<table border>");
        out.println("<tr>");
        out.println("<th>Book Id</th>");
        out.println("<th>Book Name</th>");
        out.println("<th>Book Price</th>");
        out.println("</tr>");
        for (Book b : allBooks) {
            out.println("<tr>");
            out.println("<td>" + b.getId() + "</td>");
            out.println("<td>" + b.getName() + "</td>");
            out.println("<td>" + b.getPrice() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}