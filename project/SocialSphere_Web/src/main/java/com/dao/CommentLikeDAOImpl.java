package com.dao;

import com.model.CommentLike;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentLikeDAOImpl implements CommentLikeDAO{
    @Override
    public int addCommentLike(CommentLike commentLike) {
        try {
            String sql = "insert into commentlikes(comment_id, user_id) values (?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, commentLike.getCommentId());
            preparedStatement.setInt(2, commentLike.getUserId());
            int res = preparedStatement.executeUpdate();
            System.out.println(res + " like added.");
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean checkIfLikeExists(CommentLike commentLike) {
        try {
            String sql = "select count(*) from commentlikes where comment_id = ? and user_id = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, commentLike.getCommentId());
            preparedStatement.setInt(2, commentLike.getUserId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
