package com.dao;



import com.model.Post;
import com.model.PostUserJoin;

import java.util.List;

public interface PostDAO {
    int addPost(Post post);
    List<PostUserJoin> viewAllPost();
    int getLikeCount(int postId);
    int getCommentCount(int postId);
}
