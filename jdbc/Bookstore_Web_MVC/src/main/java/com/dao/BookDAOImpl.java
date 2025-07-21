package com.dao;

import com.model.Book;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public int insert(Book book) {
        try {
            String sql = "insert into books(name, price) values(?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setFloat(2, book.getPrice());
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Book book) {
        try {
            String sql = "update books set name= ?, price= ? where id= ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setInt(3, book.getId());
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            String sql = "delete from books where id= ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> view() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "select * from books";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> view(int id) {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "select * from books where id = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3)));
            } else {
                System.out.println("No book found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> view(String name) {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "select * from books where name like ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean found = false;
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3)));
                found = true; }
            if (!found)
                System.out.println("No books found with name: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
