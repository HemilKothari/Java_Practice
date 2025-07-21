<%@ page import="java.util.List" %>
<%@ page import="com.model.CommentUserJoin" %>

<html>
  <body>
    <h1>Comments</h1>

    <form action="home?operation=dashboard" method="post" style="display:inline;">
        <button type="submit">Go To Dashboard</button>
    </form>

    <form action="home?operation=ViewAllPosts" method="post" style="display:inline;">
        <button type="submit">View All Posts</button>
    </form>

    <%
    List<CommentUserJoin> comments = (List<CommentUserJoin>) request.getAttribute("comments");
    if (comments == null) {
    %>
        <p>No comments found.</p>
    <% }
    else { 
            for (CommentUserJoin comment : comments) {
            %>
                <h3><%= comment.getUserName() %></h3>
                <p><%= comment.getCommentContent() %></p>
                <p><%= comment.getCommentTime() %></p>
            <%
            }

        }
    %>

  </body>
</html>
