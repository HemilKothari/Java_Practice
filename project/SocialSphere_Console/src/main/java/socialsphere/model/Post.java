package socialsphere.model;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private String postTitle;
    private String postContent;
    private Timestamp postTime;
    private int userId;

    public Post() {
    }

    public Post(int postId,String postTitle, String postContent, Timestamp postTime, int userId) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
        this.userId = userId;
    }

    public Post(String postTitle, String postContent, int userId) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postTime=" + postTime +
                ", userId=" + userId +
                '}';
    }
}
