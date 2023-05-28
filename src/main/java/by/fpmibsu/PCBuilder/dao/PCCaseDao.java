package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.PCCase;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCCaseDao implements ComponentDaoI<Integer, PCCase> {

    private static final String SQL_SELECT_ALL_PCCASE = "SELECT * FROM pccase";

    private static final String SQL_SELECT_PCCASE_BY_ID = "SELECT * FROM pccase WHERE id = ?";

    private static final String SQL_UPDATE_PCCASE = "UPDATE pccase SET id = ?, price = ?, name = ?, brand = ?, color = ? WHERE id = ?";

    private static final String SQl_DELETE_PCCASE_BY_ID = "DELETE FROM pccase WHERE id = ?";

    private static final String SQL_DELETE_PCCASE = "DELETE FROM pccase WHERE id = ?, price = ?, name = ?, brand = ?, color = ?";

    private static final String SQL_INSERT_PCCASE = "INSERT INTO pccase(id, price, name, brand, color) VALUES (?,?,?,?,?)";

    @Override
    public List<PCCase> findAll() throws DaoException {
        List<PCCase> cases = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PCCASE);
            while (resultSet.next()){
                PCCase pcCase = new PCCase();
                pcCase.setId(resultSet.getInt("id"));
                pcCase.setPrice(resultSet.getInt("price"));
                pcCase.setName(resultSet.getString("name"));
                pcCase.setBrand(resultSet.getString("brand"));
                pcCase.setColor(Color.valueOf(resultSet.getString("color")));
                cases.add(pcCase);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cases;
    }

    @Override
    public PCCase findComponentById(Integer id) throws DaoException {
        PCCase motherboard = new PCCase();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_PCCASE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                motherboard.setId(resultSet.getInt("id"));
                motherboard.setPrice(resultSet.getInt("price"));
                motherboard.setName(resultSet.getString("name"));
                motherboard.setBrand(resultSet.getString("brand"));
                motherboard.setColor(Color.valueOf(resultSet.getString("color")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return motherboard;
    }

    @Override
    public PCCase update(PCCase pcCase) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_PCCASE);
            statement.setInt(1, pcCase.getId());
            statement.setInt(2,pcCase.getPrice());
            statement.setString(3,pcCase.getName());
            statement.setString(4,pcCase.getBrand());
            statement.setString(5, pcCase.getColor().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return pcCase;
    }

    @Override
    public boolean delete(PCCase pcCase) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_PCCASE);
            statement.setInt(1, pcCase.getId());
            statement.setInt(2,pcCase.getPrice());
            statement.setString(3,pcCase.getName());
            statement.setString(4,pcCase.getBrand());
            statement.setString(5, pcCase.getColor().toString());
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
            statement = connection.prepareStatement(SQl_DELETE_PCCASE_BY_ID);
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
    public int insert(PCCase pcCase) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_PCCASE);
            statement.setInt(1, pcCase.getId());
            statement.setInt(2, pcCase.getPrice());
            statement.setString(3, pcCase.getName());
            statement.setString(4, pcCase.getBrand());
            statement.setString(5, pcCase.getColor().toString());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
