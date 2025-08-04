<%@ page import="com.dao.UserDAO"%>
<%@ page import="com.dao.UserDAOImpl"%>
<%@ page import="com.model.User"%>

<%
String userName = (String) session.getAttribute("userName");
if(userName == null) {
    response.sendRedirect("login.html");
    return;
}
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles/dashboard.css">
</head>
<body>
<h2>Welcome <%= userName %></h2>
<form action="createpost.html" method="post" style="display:inline;">
    <button type="submit">Create Post</button>
</form>
<form action="home" method="post" style="display:inline;">
    <input type="hidden" name="operation" value="ViewAllPosts">
    <button type="submit">View All Posts</button>
</form>
<form action="home" method="post" style="display:inline;">
    <input type="hidden" name="operation" value="Logout">
    <button type="submit">Logout</button>
</form>

<%
UserDAO userDAO = new UserDAOImpl();
int userId = userDAO.getUserIdFromName(new User((String) session.getAttribute("userName")));
%>

<h3>Posts: <%= userDAO.getPostCount(userId) %> </h3>
<h3>Comment: <%= userDAO.getCommentCount(userId) %> </h3>
<h3>Posts Liked: <%= userDAO.getPostLikeCount(userId) %> </h3>
<h3>Comments Liked: <%= userDAO.getCommentLikeCount(userId) %> </h3>
</body>
</html>