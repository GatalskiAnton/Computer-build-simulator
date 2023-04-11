package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PowerSupplyDao implements ComponentDaoI<Integer, PowerSupply> {

    private static final String SQL_SELECT_ALL_POWER_SUPPLY = "SELECT * FROM powersuply";

    private static final String SQL_SELECT_POWER_SUPPLY_BY_ID = "SELECT * FROM powersuply WHERE id = ?";

    private static final String SQL_UPDATE_POWER_SUPPLY = "UPDATE powersuply SET id = ?, price = ?, name = ?, brand = ?, power = ? WHERE id = ?";

    private static final String SQl_DELETE_POWER_SUPPLY_BY_ID = "DELETE FROM powersuply WHERE id = ?";

    private static final String SQL_DELETE_POWER_SUPPLY = "DELETE FROM powersuply WHERE id = ?, price = ?, name = ?, brand = ?, power = ?";

    private static final String SQL_INSERT_POWER_SUPPLY = "INSERT INTO powersuply(id, price, name, brand, power) VALUES (?,?,?,?,?)";
    @Override
    public List<PowerSupply> findAll() throws DaoException {
        List<PowerSupply> powerSupplies = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_POWER_SUPPLY);
            while (resultSet.next()){
                PowerSupply powerSupply = new PowerSupply();
                powerSupply.setId(resultSet.getInt("id"));
                powerSupply.setPrice(resultSet.getInt("price"));
                powerSupply.setName(resultSet.getString("name"));
                powerSupply.setBrand(resultSet.getString("brand"));
                powerSupply.setPower(resultSet.getInt("power"));
                powerSupplies.add(powerSupply);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return powerSupplies;
    }

    @Override
    public PowerSupply findComponentById(Integer id) throws DaoException {
        PowerSupply powerSupply = new PowerSupply();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_POWER_SUPPLY_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                powerSupply.setId(resultSet.getInt("id"));
                powerSupply.setPrice(resultSet.getInt("price"));
                powerSupply.setName(resultSet.getString("name"));
                powerSupply.setBrand(resultSet.getString("brand"));
                powerSupply.setPower(resultSet.getInt("power"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return powerSupply;
    }

    @Override
    public PowerSupply update(PowerSupply powerSupply) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_POWER_SUPPLY);
            statement.setInt(1, powerSupply.getId());
            statement.setInt(2,powerSupply.getPrice());
            statement.setString(3,powerSupply.getName());
            statement.setString(4,powerSupply.getBrand());
            statement.setInt(5, powerSupply.getPower());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return powerSupply;
    }

    @Override
    public boolean delete(PowerSupply powerSupply) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_POWER_SUPPLY);
            statement.setInt(1, powerSupply.getId());
            statement.setInt(2,powerSupply.getPrice());
            statement.setString(3,powerSupply.getName());
            statement.setString(4,powerSupply.getBrand());
            statement.setInt(5, powerSupply.getPower());
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
            statement = connection.prepareStatement(SQl_DELETE_POWER_SUPPLY_BY_ID);
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
    public int insert(PowerSupply powerSupply) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_POWER_SUPPLY);
            statement.setInt(1, powerSupply.getId());
            statement.setInt(2, powerSupply.getPrice());
            statement.setString(3, powerSupply.getName());
            statement.setString(4, powerSupply.getBrand());
            statement.setInt(5, powerSupply.getPower());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
