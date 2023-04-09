package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HDDDao implements ComponentDaoI<Integer, HDD> {

    private static final String SQL_SELECT_ALL_HDD = "SELECT * FROM hdd";

    private static final String SQL_SELECT_HDD_BY_ID = "SELECT * FROM hdd WHERE id = ?";

    private static final String SQL_UPDATE_HDD = "UPDATE hdd SET id = ?, price = ?, name = ?, brand = ?, capacity = ? WHERE id = ?";

    private static final String SQl_DELETE_HDD_BY_ID = "DELETE FROM gpu WHERE id = ?";

    private static final String SQL_DELETE_HDD = "DELETE FROM gpu WHERE id = ?, price = ?, name = ?, brand = ?, capacity = ?";

    private static final String SQL_INSERT_HDD = "INSERT INTO gpu(id, price, name, brand, capacity) VALUES (?,?,?,?,?)";

    @Override
    public List<HDD> findAll() throws DaoException {
        List<HDD> hdds = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_HDD);
            while (resultSet.next()){
                HDD hdd = new HDD();
                hdd.setId(resultSet.getInt("id"));
                hdd.setPrice(resultSet.getInt("price"));
                hdd.setName(resultSet.getString("name"));
                hdd.setBrand(resultSet.getString("brand"));
                hdd.setCapacity(resultSet.getInt("capacity"));
                hdds.add(hdd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return hdds;
    }

    @Override
    public HDD findComponentById(Integer id) throws DaoException {
        HDD hdd = new HDD();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_HDD_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                hdd.setId(resultSet.getInt("id"));
                hdd.setPrice(resultSet.getInt("price"));
                hdd.setName(resultSet.getString("name"));
                hdd.setBrand(resultSet.getString("brand"));
                hdd.setCapacity(resultSet.getInt("capacity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return hdd;
    }

    @Override
    public HDD update(HDD hdd) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_HDD);
            statement.setInt(1, hdd.getId());
            statement.setInt(2,hdd.getPrice());
            statement.setString(3,hdd.getName());
            statement.setString(4,hdd.getBrand());
            statement.setInt(5, hdd.getCapacity());
            statement.setInt(6, hdd.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return hdd;
    }

    @Override
    public boolean delete(HDD hdd) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_HDD);
            statement.setInt(1, hdd.getId());
            statement.setInt(2,hdd.getPrice());
            statement.setString(3,hdd.getName());
            statement.setString(4,hdd.getBrand());
            statement.setInt(5, hdd.getCapacity());
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
            statement = connection.prepareStatement(SQl_DELETE_HDD_BY_ID);
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
    public int insert(HDD hdd) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_HDD);
            statement.setInt(1, hdd.getId());
            statement.setInt(2, hdd.getPrice());
            statement.setString(3, hdd.getName());
            statement.setString(4, hdd.getBrand());
            statement.setInt(5, hdd.getCapacity());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
