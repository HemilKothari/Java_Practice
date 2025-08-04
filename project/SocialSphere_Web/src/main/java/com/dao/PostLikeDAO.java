package com.dao;

import com.model.PostLike;

public interface PostLikeDAO {
    int addPostLike(PostLike postLike);
    boolean checkIfLikeExists(PostLike postLike);
}
