package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.*;
import javassist.bytecode.LineNumberAttribute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoI<Integer, User> {

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";

    private static final String SQL_SELECT_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";

    private static final String SQL_UPDATE_USERS = "UPDATE users SET login = ?, password = ?, admin = ?, email = ?, fromGoogle = ? WHERE id = ?";

    private static final String SQl_DELETE_USERS_BY_ID = "DELETE FROM users WHERE id = ?";

    private static final String SQL_DELETE_USERS = "DELETE FROM users WHERE id = ? AND login = ? AND password = ? AND admin = ?";

    private static final String SQL_INSERT_USERS = "INSERT INTO users(login, password, admin, email, fromGoogle) VALUES (?,?,?,?,?)";

    private static final String SQL_SELECT_USERS_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_HASHPASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";

    private static final String SQL_INSERT_BY_LOGIN = "INSERT INTO users(login, fromGoogle) VALUES(?,?)";

    private static final String SQL_GET_PC_BY_ID = "SELECT id FROM pc WHERE userId = ?";


    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
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
            while (resultSet.next()) {
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
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setString(4, user.getLogin());
            statement.setBoolean(5, user.isFromGoogle());
            statement.setInt(6, user.getId());
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
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getHashPassword());
            statement.setBoolean(4, user.isAdmin());
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
        PreparedStatement statement;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_USERS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setString(4, user.getEmail());
            statement.setBoolean(5, user.isFromGoogle());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }

    @Override
    public int insertByLogin(User user) throws DaoException {

        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            System.out.println(user.getHashPassword());
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_USERS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getHashPassword());
            statement.setBoolean(3, false);
            statement.setString(4, user.getEmail());
            statement.setBoolean(5, true);
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }

    @Override
    public int getPcById(Integer id) throws DaoException {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_GET_PC_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                PC pc = new PC();
                PCDao dao = new PCDao();
                pc.setUserId(id);
                dao.insertEmpty(pc);
                return getPcById(id);
            }
            else {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            return -1;
        }
    }

    public User findUserByLogin(String login) throws DaoException {
        User user = new User();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_USERS_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
        }
        catch (SQLException e){
            return null;
        }
        try {
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getInt("admin") != 0);
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            close(connection);
        }
        return user;
    }

    public User findUserByLogin(String login, String hashPassword) throws DaoException {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_HASHPASSWORD);
            statement.setString(1, login);
            statement.setString(2, hashPassword);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getInt("admin") != 0);
            }
        } catch (SQLException e) {
            System.out.println(e);
            user = null;
        } finally {
            close(connection);
        }
        return user;
    }


}