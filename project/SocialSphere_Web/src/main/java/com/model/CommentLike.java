package com.model;

public class CommentLike {
    private int likeId;
    private int userId;
    private int commentId;

    public CommentLike() {
    }

    public CommentLike(int likeId, int userId, int commentId) {
        this.likeId = likeId;
        this.userId = userId;
        this.commentId = commentId;
    }

    public CommentLike(int userId, int commentId) {
        this.userId = userId;
        this.commentId = commentId;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "CommentLike{" +
                "likeId=" + likeId +
                ", userId=" + userId +
                ", commentId=" + commentId +
                '}';
    }
}
