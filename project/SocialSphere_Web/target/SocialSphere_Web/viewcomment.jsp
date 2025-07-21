<%@ page import="java.util.List" %>
<%@ page import="com.model.CommentUserJoin" %>

<html>
  <body>
    <h1>Comments</h1>

    <%
    List<CommentUserJoin> comments = (List<PostUserJoin>) request.getAttribute("comments");
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
            %>
            <form action="viewpost.jsp" method="comment" style="display:inline;">
                <button type="submit">View All Posts</button>
            </form>
    <%
        }
    %>

  </body>
</html>
