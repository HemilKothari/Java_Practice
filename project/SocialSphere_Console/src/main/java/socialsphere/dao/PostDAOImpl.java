package socialsphere.dao;

import socialsphere.model.Post;
import socialsphere.model.PostUserJoin;
import socialsphere.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO{
    @Override
    public int addPost(Post post) {
        try {
            String sql = "insert into posts(post_title, post_content, user_id) values (?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, post.getPostTitle());
            preparedStatement.setString(2, post.getPostContent());
            preparedStatement.setInt(3, post.getUserId());
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<PostUserJoin> viewAllPost() {
        List<PostUserJoin> posts = null;
        try {
            posts = new ArrayList<>();
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "select p.post_title, p.post_content, p.post_time, u.user_name from posts p join users u on p.user_id = u.user_id order by post_time desc";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
                posts.add(new PostUserJoin(resultSet.getString(1),resultSet.getString(2),resultSet.getTimestamp(3),resultSet.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
