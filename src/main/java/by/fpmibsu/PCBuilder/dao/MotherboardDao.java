package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotherboardDao implements ComponentDaoI<Integer, Motherboard> {

    private static final String SQL_SELECT_ALL_MOTHERBOARD = "SELECT * FROM motherboard";

    private static final String SQL_SELECT_MOTHERBOARD_BY_ID = "SELECT * FROM motherboard WHERE id = ?";

    private static final String SQL_UPDATE_MOTHERBOARD = "UPDATE motherboard SET id = ?, price = ?, name = ?, brand = ?, socket = ? WHERE id = ?";

    private static final String SQl_DELETE_MOTHERBOARD_BY_ID = "DELETE FROM motherboard WHERE id = ?";

    private static final String SQL_DELETE_MOTHERBOARD = "DELETE FROM motherboard WHERE id = ?, price = ?, name = ?, brand = ?, socket = ?";

    private static final String SQL_INSERT_MOTHERBOARD = "INSERT INTO motherboard(id, price, name, brand, socket) VALUES (?,?,?,?,?)";

    private static final String SQL_SELECT_MOTHERBOARD_BY_SOCKET = "SELECT * FROM motherboard WHERE socket = ?";

    @Override
    public List<Motherboard> findAll() throws DaoException {
        List<Motherboard> motherboards = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_MOTHERBOARD);
            while (resultSet.next()) {
                Motherboard motherboard = new Motherboard();
                motherboard.setId(resultSet.getInt("id"));
                motherboard.setPrice(resultSet.getInt("price"));
                motherboard.setName(resultSet.getString("name"));
                motherboard.setBrand(resultSet.getString("brand"));
                motherboard.setSocket(Socket.valueOf(resultSet.getString("socket")));
                motherboards.add(motherboard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return motherboards;
    }

    @Override
    public Motherboard findComponentById(Integer id) throws DaoException {
        Motherboard motherboard = new Motherboard();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_MOTHERBOARD_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                motherboard.setId(resultSet.getInt("id"));
                motherboard.setPrice(resultSet.getInt("price"));
                motherboard.setName(resultSet.getString("name"));
                motherboard.setBrand(resultSet.getString("brand"));
                motherboard.setSocket(Socket.valueOf(resultSet.getString("socket")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return motherboard;
    }

    @Override
    public Motherboard update(Motherboard motherboard) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_MOTHERBOARD);
            statement.setInt(1, motherboard.getId());
            statement.setInt(2, motherboard.getPrice());
            statement.setString(3, motherboard.getName());
            statement.setString(4, motherboard.getBrand());
            statement.setString(5, motherboard.getSocket().toString());
            statement.setInt(6, motherboard.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return motherboard;
    }

    @Override
    public boolean delete(Motherboard motherboard) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_MOTHERBOARD);
            statement.setInt(1, motherboard.getId());
            statement.setInt(2, motherboard.getPrice());
            statement.setString(3, motherboard.getName());
            statement.setString(4, motherboard.getBrand());
            statement.setString(5, motherboard.getSocket().toString());
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
            statement = connection.prepareStatement(SQl_DELETE_MOTHERBOARD_BY_ID);
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
    public int insert(Motherboard motherboard) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_MOTHERBOARD);
            statement.setInt(1, motherboard.getId());
            statement.setInt(2, motherboard.getPrice());
            statement.setString(3, motherboard.getName());
            statement.setString(4, motherboard.getBrand());
            statement.setString(5, motherboard.getSocket().toString());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }

    public List<Motherboard> findComponentBySocket(Socket socket) throws DaoException {
        List<Motherboard> motherboards = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_MOTHERBOARD_BY_SOCKET);
            statement.setString(1, socket.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Motherboard motherboard = new Motherboard();
                motherboard.setId(resultSet.getInt("id"));
                motherboard.setPrice(resultSet.getInt("price"));
                motherboard.setName(resultSet.getString("name"));
                motherboard.setBrand(resultSet.getString("brand"));
                motherboard.setSocket(Socket.valueOf(resultSet.getString("socket")));
                motherboards.add(motherboard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return motherboards;
    }
}
