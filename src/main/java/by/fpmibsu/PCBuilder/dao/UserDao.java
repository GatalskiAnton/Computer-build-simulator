package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoI<Integer, User> {

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";

    private static final String SQL_SELECT_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";

    private static final String SQL_UPDATE_USERS = "UPDATE users SET id = ?, login = ?, password = ?, admin = ? WHERE id = ?";

    private static final String SQl_DELETE_USERS_BY_ID = "DELETE FROM users WHERE id = ?";

    private static final String SQL_DELETE_USERS = "DELETE FROM users WHERE id = ? AND login = ? AND password = ? AND admin = ?";

    private static final String SQL_INSERT_USERS = "INSERT INTO users(id, login, password, admin) VALUES (?,?,?,?)";

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("admin"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return users;
    }

    @Override
    public User findUserById(Integer id) throws DaoException {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_USERS_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getInt("admin") != 0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return user;
    }

    @Override
    public User update(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_USERS);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getHashPassword());
            statement.setBoolean(4, user.isAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return user;
    }

    @Override
    public boolean delete(User user) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_USERS);
            statement.setInt(1, user.getId());
            statement.setString(2,user.getLogin());
            statement.setString(3, user.getHashPassword());
            statement.setBoolean(4,user.isAdmin());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate > 0;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQl_DELETE_USERS_BY_ID);
            statement.setInt(1, id);
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate > 0;
    }

    @Override
    public int insert(User user) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_USERS);
            statement.setInt(1, user.getId());
            statement.setString(2,user.getLogin());
            statement.setString(3, user.getHashPassword());
            statement.setBoolean(4,user.isAdmin());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
