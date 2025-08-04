package com.model;

public class PostLike {
    private int likeId;
    private int userId;
    private int postId;

    public PostLike() {
    }

    public PostLike(int likeId, int userId, int postId) {
        this.likeId = likeId;
        this.userId = userId;
        this.postId = postId;
    }

    public PostLike(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
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
        return "PostLike{" +
                "likeId=" + likeId +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
