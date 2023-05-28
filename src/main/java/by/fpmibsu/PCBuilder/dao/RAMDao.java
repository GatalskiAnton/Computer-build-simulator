package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RAMDao implements ComponentDaoI<Integer, RAM> {

    private static final String SQL_SELECT_ALL_RAM = "SELECT * FROM ram";

    private static final String SQL_SELECT_RAM_BY_ID = "SELECT * FROM ram WHERE id = ?";

    private static final String SQL_UPDATE_RAM = "UPDATE ram SET id = ?, price = ?, name = ?, brand = ?, speed = ?, memoryType = ? WHERE id = ?";

    private static final String SQl_DELETE_RAM_BY_ID = "DELETE FROM ram WHERE id = ?";

    private static final String SQL_DELETE_RAM = "DELETE FROM ram WHERE id = ?, price = ?, name = ?, brand = ?, speed = ?, memoryType = ?";

    private static final String SQL_INSERT_RAM = "INSERT INTO ram(id, price, name, brand, speed, memoryType) VALUES (?,?,?,?,?,?)";

    @Override
    public List<RAM> findAll() throws DaoException {
        List<RAM> rams = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_RAM);
            while (resultSet.next()) {
                RAM ram = new RAM();
                ram.setId(resultSet.getInt("id"));
                ram.setPrice(resultSet.getInt("price"));
                ram.setName(resultSet.getString("name"));
                ram.setBrand(resultSet.getString("brand"));
                ram.setSpeed(resultSet.getInt("speed"));
                ram.setMemoryType(MemoryType.valueOf(resultSet.getString("memoryType")));
                rams.add(ram);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return rams;
    }

    @Override
    public RAM findComponentById(Integer id) throws DaoException {
        RAM ram = new RAM();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_RAM_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ram.setId(resultSet.getInt("id"));
                ram.setPrice(resultSet.getInt("price"));
                ram.setName(resultSet.getString("name"));
                ram.setBrand(resultSet.getString("brand"));
                ram.setSpeed(resultSet.getInt("speed"));
                ram.setMemoryType(MemoryType.valueOf(resultSet.getString("memoryType")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return ram;
    }

    @Override
    public RAM update(RAM ram) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_RAM);
            statement.setInt(1, ram.getId());
            statement.setInt(2, ram.getPrice());
            statement.setString(3, ram.getName());
            statement.setString(4, ram.getBrand());
            statement.setInt(5, ram.getSpeed());
            statement.setString(6, ram.getMemoryType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return ram;
    }

    @Override
    public boolean delete(RAM ram) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_RAM);
            statement.setInt(1, ram.getId());
            statement.setInt(2, ram.getPrice());
            statement.setString(3, ram.getName());
            statement.setString(4, ram.getBrand());
            statement.setInt(5, ram.getSpeed());
            statement.setString(6, ram.getMemoryType().toString());
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
            statement = connection.prepareStatement(SQl_DELETE_RAM_BY_ID);
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
    public int insert(RAM ram) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_RAM);
            statement.setInt(1, ram.getId());
            statement.setInt(2, ram.getPrice());
            statement.setString(3, ram.getName());
            statement.setString(4, ram.getBrand());
            statement.setInt(5, ram.getSpeed());
            statement.setString(6, ram.getMemoryType().toString());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}