<% int postId = Integer.parseInt(request.getParameter("postId")); %>
<html>
<head>
    <title>Create Comment</title>
</head>
<body>
<h2>Add Comment</h2>
<form action="home" method="post">
    <input type="hidden" name="postId" value="<%= postId %>">
    <textarea name="commentContent" cols="20" rows="5" placeholder="Enter your comment here..."></textarea>
    <input type="submit" value="Add Comment" name="operation">
</form>
</body>
</html>