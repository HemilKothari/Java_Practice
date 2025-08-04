package com.dao;

import com.model.CommentLike;

public interface CommentLikeDAO {
    int addCommentLike(CommentLike commentLike);
    boolean checkIfLikeExists(CommentLike commentLike);
}
