package com.dao;


import com.model.Comment;
import com.model.CommentUserJoin;

import java.util.List;

public interface CommentDAO {
    int addComment(Comment comment);
    List<CommentUserJoin> viewComments(int postId);
}
