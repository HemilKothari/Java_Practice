<%@ page import="java.util.List" %>
<%@ page import="com.model.PostUserJoin" %>
<%@ page import="com.dao.PostDAO"%>
<%@ page import="com.dao.PostDAOImpl"%>

<html>
  <body>
    <h1>Posts</h1>

    <form action="home?operation=dashboard" method="post" style="display:inline;">
        <button type="submit">Go To Dashboard</button>
    </form>

    <%
    List<PostUserJoin> posts = (List<PostUserJoin>) request.getAttribute("posts");
    if (posts == null) {
    %>
        <p>No posts found.</p>
    <% }
    else {
            PostDAO postDAO = new PostDAOImpl();
            for (PostUserJoin post : posts) {
            int postId = post.getPostId();
            %>
                <h3><%= post.getUserName() %> : <%= post.getPostTitle() %></h3>
                <p><%= post.getPostContent() %></p>
                <p><%= post.getPostTime() %></p>
                <form action="addcomment.jsp" method="post" style="display:inline;">
                    <input type="hidden" name="postId" value="<%= postId %>">
                    <button type="submit">Add Comment</button>
                </form>
                <form action="home" method="post" style="display:inline;">
                    <input type="hidden" name="postId" value="<%= postId %>">
                    <input type="hidden" name="operation" value="ViewAllComments">
                    <button type="submit">View Comments</button>
                </form>
                <h5 style="display:inline;"><%= postDAO.getCommentCount(postId) %> </h5>
                <form action="home" method="post" style="display:inline;">
                    <input type="hidden" name="postId" value="<%= postId %>">
                    <input type="hidden" name="operation" value="AddPostLike">
                    <button type="submit">Like</button>
                </form>
                <h5 style="display:inline;"><%= postDAO.getLikeCount(postId) %> </h5>

            <%
            }
            %>

    <%
        }
    %>

  </body>
</html>
