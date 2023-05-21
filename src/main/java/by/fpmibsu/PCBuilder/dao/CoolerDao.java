package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoolerDao implements ComponentDaoI<Integer, Cooler> {

    private static final String SQL_SELECT_ALL_COOLER = "SELECT * FROM cooler";

    private static final String SQL_SELECT_COOLER_BY_ID = "SELECT * FROM cooler WHERE id = ?";

    private static final String SQL_UPDATE_COOLER = "UPDATE cooler SET id = ?, price = ?, name = ?, brand = ?, TDP = ?, socket = ?, diameter = ? WHERE id = ?";

    private static final String SQl_DELETE_COOLER_BY_ID = "DELETE FROM cooler WHERE id = ?";

    private static final String SQL_DELETE_COOLER = "DELETE FROM cooler WHERE id = ? AND price = ? AND name = ? AND brand = ? AND TDP = ? AND socket = ? AND diameter = ?";

    private static final String SQL_INSERT_COOLER = "INSERT INTO cooler(id, price, name, brand, TDP, socket, diameter) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_SELECT_COOLER_BY_PARAMETERS = "SELECT * FROM cooler WHERE price BETWEEN ? AND ? AND TDP BETWEEN ? AND ? AND socket IN(?)";

    private static final String SQl_SELECT_COOLER_BY_SOCKET = "SELECT * from cooler WHERE socket = ?";

    private static final String SQL_SELECT_COOLER_BY_TDP = "SELECT * from cooler WHERE TDP = ?";

    @Override
    public List<Cooler> findAll() throws DaoException {
        List<Cooler> coolers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_COOLER);
            while (resultSet.next()) {
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
            while (resultSet.next()) {
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
            statement.setInt(2, cooler.getPrice());
            statement.setString(3, cooler.getName());
            statement.setString(4, cooler.getBrand());
            statement.setInt(5, cooler.getTDP());
            statement.setString(6, cooler.getSocket().toString());
            statement.setInt(7, cooler.getDiameter());
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
            statement.setInt(2, cooler.getPrice());
            statement.setString(3, cooler.getName());
            statement.setString(4, cooler.getBrand());
            statement.setInt(5, cooler.getTDP());
            statement.setString(6, cooler.getSocket().toString());
            statement.setInt(7, cooler.getDiameter());
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
            statement.setInt(2, cooler.getPrice());
            statement.setString(3, cooler.getName());
            statement.setString(4, cooler.getBrand());
            statement.setInt(5, cooler.getTDP());
            statement.setString(6, cooler.getSocket().toString());
            statement.setInt(7, cooler.getDiameter());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }

    public List<Cooler> findCoolerByParameters(int minPrice, int maxPrice, int minTDP, int maxTDP, String socket) throws DaoException {

        String socketRequest;
        if (Objects.equals(socket, ""))
            socketRequest = "AM5', " +
                    "'AM4', " +
                    "'AM3', " +
                    "'LGA1700', " +
                    "'LGA1200', " +
                    "'LGA1151', " +
                    "'LGA1150', " +
                    "'LGA2066";
        else {
            socketRequest = socket;
        }
        List<Cooler> coolers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_COOLER_BY_PARAMETERS);
            statement.setInt(1, minPrice);
            statement.setInt(2, maxPrice);
            statement.setInt(3, minTDP);
            statement.setInt(4, maxTDP);
            statement.setString(5, socketRequest);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
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

    public List<Cooler> findComponentBySocket(Socket socket) throws DaoException {
        List<Cooler> coolers = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQl_SELECT_COOLER_BY_SOCKET);
            statement.setString(1, socket.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
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

    public List<Cooler> findComponentByTDP(int TDP) throws DaoException {
        List<Cooler> coolers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_COOLER_BY_TDP);
            statement.setInt(1, TDP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
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
}


