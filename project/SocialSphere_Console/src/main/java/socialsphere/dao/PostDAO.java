package socialsphere.dao;

import socialsphere.model.Post;
import socialsphere.model.PostUserJoin;

import java.util.List;

public interface PostDAO {
    int addPost(Post post);
    List<PostUserJoin> viewAllPost();
}
