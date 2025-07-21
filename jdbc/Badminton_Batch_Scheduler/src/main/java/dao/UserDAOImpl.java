package dao;

import model.Batch;
import model.User;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    @Override
    public int addUser(int id, User user) {
        try {
            String sql = "select count(*) from users where batchId = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            if (resultSet.next())
                count = resultSet.getInt(1);
            Batch batch = new Batch();
            if(batch.getMaxCapacity() - 1 > count) {
                sql = "insert into users values(?,?,?)";
                preparedStatement = DBUtil.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, user.getUserID());
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setInt(3, user.getBatchId());

                int res = 0;
                res = preparedStatement.executeUpdate();
                return res;
            } else {
                System.out.println("Batch is full.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
