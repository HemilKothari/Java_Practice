package socialsphere.dao;

import socialsphere.model.Comment;
import socialsphere.model.Post;
import socialsphere.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDAOImpl implements CommentDAO{

    @Override
    public int addComment(Comment comment) {
            try {
                String sql = "insert into comments(comment_content, user_id, post_id) values (?,?,?)";
                PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, comment.getCommentContent());
                preparedStatement.setInt(2, comment.getUserId());
                preparedStatement.setInt(3, comment.getPostId());
                int res = preparedStatement.executeUpdate();
                return res;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
