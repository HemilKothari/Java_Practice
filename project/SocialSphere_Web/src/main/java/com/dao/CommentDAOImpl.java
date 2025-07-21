package com.dao;


import com.model.Comment;
import com.model.CommentUserJoin;
import com.util.DBUtil;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    @Override
    public int addComment(Comment comment) {
        try {
            String sql = "insert into comments(comment_content, user_id, post_id) values (?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, comment.getCommentContent());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setInt(3, comment.getPostId());
            int res = preparedStatement.executeUpdate();
            System.out.println(res + " comment added.");
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<CommentUserJoin> viewComments(int postId) {
        List<CommentUserJoin> comments = null;
        try {
            comments = new ArrayList<>();
            String sql = "select c.comment_id, c.comment_content, c.comment_time, u.user_name from comments c join users u on c.user_id = u.user_id where c.post_id = ? order by comment_time desc";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                comments.add(new CommentUserJoin(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3), resultSet.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}
