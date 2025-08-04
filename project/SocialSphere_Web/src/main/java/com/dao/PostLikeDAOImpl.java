package com.dao;

import com.model.PostLike;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostLikeDAOImpl implements PostLikeDAO{
    @Override
    public int addPostLike(PostLike postLike) {
        try {
            String sql = "insert into postlikes(post_id, user_id) values (?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, postLike.getPostId());
            preparedStatement.setInt(2, postLike.getUserId());
            int res = preparedStatement.executeUpdate();
            System.out.println(res + " like added.");
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean checkIfLikeExists(PostLike postLike) {
        try {
            String sql = "select count(*) from postlikes where post_id = ? and user_id = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, postLike.getPostId());
            preparedStatement.setInt(2, postLike.getUserId());
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
