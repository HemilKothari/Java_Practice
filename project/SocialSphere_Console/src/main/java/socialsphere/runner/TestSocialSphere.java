package socialsphere.runner;

import socialsphere.dao.PostDAO;
import socialsphere.dao.PostDAOImpl;
import socialsphere.dao.UserDAO;
import socialsphere.dao.UserDAOImpl;
import socialsphere.model.Post;
import socialsphere.model.PostUserJoin;
import socialsphere.model.User;

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
