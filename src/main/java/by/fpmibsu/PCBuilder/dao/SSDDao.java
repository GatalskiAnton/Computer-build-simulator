package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.RAM;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SSDDao implements ComponentDaoI<Integer, SSD> {

    private static final String SQL_SELECT_ALL_SSD = "SELECT * FROM ssd";

    private static final String SQL_SELECT_SSD_BY_ID = "SELECT * FROM ssd WHERE id = ?";

    private static final String SQL_UPDATE_SSD = "UPDATE ssd SET id = ?, price = ?, name = ?, brand = ?, capacity = ? WHERE id = ?";

    private static final String SQl_DELETE_SSD_BY_ID = "DELETE FROM ssd WHERE id = ?";

    private static final String SQL_DELETE_SSD = "DELETE FROM ssd WHERE id = ?, price = ?, name = ?, brand = ?, capacity = ?";

    private static final String SQL_INSERT_SSD = "INSERT INTO ssd(id, price, name, brand, capacity) VALUES (?,?,?,?,?)";
    @Override
    public List<SSD> findAll() throws DaoException {
        List<SSD> ssds = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SSD);
            while (resultSet.next()){
                SSD ssd = new SSD();
                ssd.setId(resultSet.getInt("id"));
                ssd.setPrice(resultSet.getInt("price"));
                ssd.setName(resultSet.getString("name"));
                ssd.setBrand(resultSet.getString("brand"));
                ssd.setCapacity(resultSet.getInt("capacity"));
                ssds.add(ssd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return ssds;
    }

    @Override
    public SSD findComponentById(Integer id) throws DaoException {
        SSD ssd = new SSD();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_SSD_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ssd.setId(resultSet.getInt("id"));
                ssd.setPrice(resultSet.getInt("price"));
                ssd.setName(resultSet.getString("name"));
                ssd.setBrand(resultSet.getString("brand"));
                ssd.setCapacity(resultSet.getInt("capacity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return ssd;
    }

    @Override
    public SSD update(SSD ssd) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_SSD);
            statement.setInt(1, ssd.getId());
            statement.setInt(2,ssd.getPrice());
            statement.setString(3,ssd.getName());
            statement.setString(4,ssd.getBrand());
            statement.setInt(5,ssd.getCapacity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return ssd;
    }

    @Override
    public boolean delete(SSD ssd) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_SSD);
            statement.setInt(1, ssd.getId());
            statement.setInt(2, ssd.getPrice());
            statement.setString(3, ssd.getName());
            statement.setString(4, ssd.getBrand());
            statement.setInt(5,ssd.getCapacity());
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
            statement = connection.prepareStatement(SQl_DELETE_SSD_BY_ID);
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
    public int insert(SSD ssd) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_SSD);
            statement.setInt(1, ssd.getId());
            statement.setInt(2, ssd.getPrice());
            statement.setString(3, ssd.getName());
            statement.setString(4, ssd.getBrand());
            statement.setInt(5,ssd.getCapacity());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
