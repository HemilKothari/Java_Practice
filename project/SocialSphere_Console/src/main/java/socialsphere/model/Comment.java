package socialsphere.model;

public class Comment {
    private int commentId;
    private String commentContent;
    private int userId;
    private int postId;

    public Comment() {
    }

    public Comment(int commentId, String commentContent, int userId, int postId) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.userId = userId;
        this.postId = postId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
