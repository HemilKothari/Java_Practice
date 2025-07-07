<%@ page import="java.util.List" %>
<%@ page import="com.dao.BookDAO" %>
<%@ page import="com.dao.BookDAOImpl" %>
<%@ page import="com.model.Book" %>

<html>
  <body>
    <h1>View All Books</h1>

    <%
    List<Book> allBooks = (List<Book>)request.getAttribute("books");
    if (allBooks == null) {
    %>
        <p>No books found.</p>
    <% }
    else { 
    %>

    <table border>
        <tr>
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Book Price</th>
        </tr>

            <%
            for (Book b : allBooks) {
            %>
            <tr>
                <td><%= b.getId()%></td>
                <td><%= b.getName()%></td>
                <td><%= b.getPrice()%></td>
            </tr>
            <%
            }
            %>
        </table>

    <%
        }
    %>

  </body>
</html>
