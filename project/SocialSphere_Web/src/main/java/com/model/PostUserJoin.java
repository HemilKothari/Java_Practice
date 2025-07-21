package com.model;

import java.sql.Timestamp;

public class PostUserJoin {
    private int postId;
    private String postTitle;
    private String postContent;
    private Timestamp postTime;
    private String userName;

    public PostUserJoin(int postId, String postTitle, String postContent, Timestamp postTime, String userName) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
        this.userName = userName;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PostUserJoin{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postTime=" + postTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
