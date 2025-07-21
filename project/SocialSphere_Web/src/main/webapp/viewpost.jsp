<%@ page import="java.util.List" %>
<%@ page import="com.model.PostUserJoin" %>

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
            for (PostUserJoin post : posts) {
            %>
                <h3><%= post.getUserName() %> : <%= post.getPostTitle() %></h3>
                <p><%= post.getPostContent() %></p>
                <p><%= post.getPostTime() %></p>
                <form action="addcomment.jsp" method="post" style="display:inline;">
                    <input type="hidden" name="postId" value="<%= post.getPostId() %>">
                    <button type="submit">Add Comment</button>
                </form>
                <form action="home" method="post" style="display:inline;">
                    <input type="hidden" name="postId" value="<%= post.getPostId() %>">
                    <input type="hidden" name="operation" value="ViewAllComments">
                    <button type="submit">View All Comments</button>
                </form>
            <%
            }
            %>

    <%
        }
    %>

  </body>
</html>
