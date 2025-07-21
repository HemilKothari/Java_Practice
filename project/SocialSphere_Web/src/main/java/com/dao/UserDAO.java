package com.dao;


import com.model.User;

public interface UserDAO {
    int addUser(User user);
    boolean checkIfUserExists(User user);
    boolean loginUser(User user);
    int getUserIdFromName(User user);
    int getPostCount(int userId);
    int getCommentCount(int userId);
}
