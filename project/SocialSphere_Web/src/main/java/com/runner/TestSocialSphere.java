package com.runner;

import com.dao.PostDAO;
import com.dao.PostDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.Post;
import com.model.PostUserJoin;
import com.model.User;

import java.util.List;

public class TestSocialSphere {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        //TODO: Register New User
//        User user = new User(0, "John Doe", "johndoe@example.com", "john123");
//        boolean res = userDAO.checkIfUserExists(user);
//        if (res) System.out.println("User already exists");
//        else {
//            int addedUser = userDAO.addUser(user);
//            System.out.println(addedUser + " user added.");
//        }

        //TODO: Login User
//        boolean res = userDAO.loginUser(new User("ABC", "abc123"));
//        if (res) System.out.println("Login Successfull");
//
//        PostDAO postDAO = new PostDAOImpl();

        //TODO: Add New Post
//        Post post = new Post("Third Post", "Example 3", 2);
//        int res = postDAO.addPost(post);
//        System.out.println(res + " post added");

        //TODO: View all posts based on timestamp
//        List<PostUserJoin> posts = postDAO.viewAllPost();
//        for (PostUserJoin post : posts)
//            System.out.println(post);

    }
}
