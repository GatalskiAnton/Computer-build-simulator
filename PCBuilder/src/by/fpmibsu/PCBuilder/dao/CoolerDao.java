package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoolerDao implements ComponentDaoI<Integer, Cooler> {

    private static final String SQL_SELECT_ALL_COOLER = "SELECT * FROM cooler";

    private static final String SQL_SELECT_COOLER_BY_ID = "SELECT * FROM cooler WHERE id = ?";

    private static final String SQL_UPDATE_COOLER = "UPDATE cooler SET id = ?, price = ?, name = ?, brand = ?, TDP = ?, socket = ?, diameter = ? WHERE id = ?";

    private static final String SQl_DELETE_COOLER_BY_ID = "DELETE FROM cooler WHERE id = ?";

    private static final String SQL_DELETE_COOLER = "DELETE FROM cooler WHERE id = ? AND price = ? AND name = ? AND brand = ? AND TDP = ? AND socket = ? AND diameter = ?";

    private static final String SQL_INSERT_COOLER = "INSERT INTO cooler(id, price, name, brand, TDP, socket, diameter) VALUES (?,?,?,?,?,?,?)";

    @Override
    public List<Cooler> findAll() throws DaoException {
        List<Cooler> coolers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_COOLER);
            while (resultSet.next()){
                Cooler cooler = new Cooler();
                cooler.setId(resultSet.getInt("id"));
                cooler.setPrice(resultSet.getInt("price"));
                cooler.setName(resultSet.getString("name"));
                cooler.setBrand(resultSet.getString("brand"));
                cooler.setTDP(resultSet.getInt("TDP"));
                cooler.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cooler.setDiameter(resultSet.getInt("diameter"));
                coolers.add(cooler);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return coolers;
    }

    @Override
    public Cooler findComponentById(Integer id) throws DaoException {
        Cooler cooler = new Cooler();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_COOLER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                cooler.setId(resultSet.getInt("id"));
                cooler.setPrice(resultSet.getInt("price"));
                cooler.setName(resultSet.getString("name"));
                cooler.setBrand(resultSet.getString("brand"));
                cooler.setTDP(resultSet.getInt("TDP"));
                cooler.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cooler.setDiameter(resultSet.getInt("diameter"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cooler;
    }

    @Override
    public Cooler update(Cooler cooler) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_COOLER);
            statement.setInt(1, cooler.getId());
            statement.setInt(2,cooler.getPrice());
            statement.setString(3,cooler.getName());
            statement.setString(4,cooler.getBrand());
            statement.setInt(5,cooler.getTDP());
            statement.setString(6,cooler.getSocket().toString());
            statement.setInt(7,cooler.getDiameter());
            statement.setInt(8, cooler.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cooler;
    }

    @Override
    public boolean delete(Cooler cooler) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_COOLER);
            statement.setInt(1, cooler.getId());
            statement.setInt(2,cooler.getPrice());
            statement.setString(3,cooler.getName());
            statement.setString(4,cooler.getBrand());
            statement.setInt(5,cooler.getTDP());
            statement.setString(6,cooler.getSocket().toString());
            statement.setInt(7,cooler.getDiameter());
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
            statement = connection.prepareStatement(SQl_DELETE_COOLER_BY_ID);
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
    public int insert(Cooler cooler) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_COOLER);
            statement.setInt(1, cooler.getId());
            statement.setInt(2,cooler.getPrice());
            statement.setString(3,cooler.getName());
            statement.setString(4,cooler.getBrand());
            statement.setInt(5,cooler.getTDP());
            statement.setString(6,cooler.getSocket().toString());
            statement.setInt(7,cooler.getDiameter());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
