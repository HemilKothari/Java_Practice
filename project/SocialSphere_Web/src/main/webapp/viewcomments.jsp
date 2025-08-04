<%@ page import="java.util.List" %>
<%@ page import="com.model.CommentUserJoin" %>
<%@ page import="com.dao.CommentDAO"%>
<%@ page import="com.dao.CommentDAOImpl"%>

<html>
<head>
    <title>View Comments</title>
    <link rel="stylesheet" type="text/css" href="styles/viewcomments.css">
</head>
  <body>
  <div class="comment">
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
            CommentDAO commentDAO = new CommentDAOImpl();
            for (CommentUserJoin comment : comments) {
            int commentId = comment.getCommentId();
            System.out.println("commentId for this comment: " + commentId);
            %>
                <h3><%= comment.getUserName() %></h3>
                <p><%= comment.getCommentContent() %></p>
                <p><%= comment.getCommentTime() %></p>
                <form action="home" method="post" style="display:inline;">
                    <input type="hidden" name="commentId" value="<%= commentId %>">
                    <input type="hidden" name="postId" value="<%= request.getAttribute("postId") %>">
                    <input type="hidden" name="operation" value="AddCommentLike">
                    <button type="submit">Like</button>
                </form>
                <h5 style="display:inline;"><%= commentDAO.getLikeCount(commentId) %> </h5>
            <%
            }

        }
    %>

    </div>

  </body>
</html>
