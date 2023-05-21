package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CPUDao implements ComponentDaoI<Integer, CPU> {

    private static final String SQL_SELECT_ALL_CPU = "SELECT * FROM cpu";

    private static final String SQL_SELECT_CPU_BY_ID = "SELECT * FROM cpu WHERE id = ?";

    private static final String SQL_UPDATE_CPU = "UPDATE cpu SET id = ?, price = ?, name = ?, brand = ?, clockSpeed = ?, socket = ?, TDP = ?, core = ? WHERE id = ?";

    private static final String SQl_DELETE_CPU_BY_ID = "DELETE FROM cpu WHERE id = ?";

    private static final String SQL_DELETE_CPU = "DELETE FROM cpu WHERE id = ? AND price = ? AND name = ? AND brand = ? AND clockSpeed = ? AND socket = ? AND TDP = ? AND core = ?";

    private static final String SQL_INSERT_CPU = "INSERT INTO cpu(id, price, name, brand, clockSpeed, socket, TDP, core) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_SELECT_CPU_BY_SOCKET = "SELECT * FROM cpu WHERE socket = ?";

    private static final String SQl_SELECT_CPU_BY_TDP = "SELECT * FROM cpu WHERE TDP = ?";

    @Override
    public List<CPU> findAll() throws DaoException {
        List<CPU> cpus = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CPU);
            while (resultSet.next()) {
                CPU cpu = new CPU();
                cpu.setId(resultSet.getInt("id"));
                cpu.setPrice(resultSet.getInt("price"));
                cpu.setName(resultSet.getString("name"));
                cpu.setBrand(resultSet.getString("brand"));
                cpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                cpu.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cpu.setTDP(resultSet.getInt("TDP"));
                cpu.setCore(resultSet.getInt("core"));
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cpus;
    }

    @Override
    public CPU findComponentById(Integer id) throws DaoException {
        CPU cpu = new CPU();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_CPU_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cpu.setId(resultSet.getInt("id"));
                cpu.setPrice(resultSet.getInt("price"));
                cpu.setName(resultSet.getString("name"));
                cpu.setBrand(resultSet.getString("brand"));
                cpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                cpu.setTDP(resultSet.getInt("TDP"));
                cpu.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cpu.setCore(resultSet.getInt("core"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cpu;
    }

    @Override
    public CPU update(CPU cpu) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_CPU);
            statement.setInt(1, cpu.getId());
            statement.setInt(2, cpu.getPrice());
            statement.setString(3, cpu.getName());
            statement.setString(4, cpu.getBrand());
            statement.setInt(5, cpu.getClockSpeed());
            statement.setString(6, cpu.getSocket().toString());
            statement.setInt(7, cpu.getTDP());
            statement.setInt(8, cpu.getCore());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cpu;
    }

    @Override
    public boolean delete(CPU cpu) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_CPU);
            statement.setInt(1, cpu.getId());
            statement.setInt(2, cpu.getPrice());
            statement.setString(3, cpu.getName());
            statement.setString(4, cpu.getBrand());
            statement.setInt(5, cpu.getClockSpeed());
            statement.setString(6, cpu.getSocket().toString());
            statement.setInt(7, cpu.getTDP());
            statement.setInt(8, cpu.getCore());
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
            statement = connection.prepareStatement(SQl_DELETE_CPU_BY_ID);
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
    public int insert(CPU cpu) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_CPU);
            statement.setInt(1, cpu.getId());
            statement.setInt(2, cpu.getPrice());
            statement.setString(3, cpu.getName());
            statement.setString(4, cpu.getBrand());
            statement.setInt(5, cpu.getClockSpeed());
            statement.setString(6, cpu.getSocket().toString());
            statement.setInt(7, cpu.getTDP());
            statement.setInt(8, cpu.getCore());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }

    public List<CPU> findComponentBySocket(Socket socket) throws DaoException {
        List<CPU> cpus = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_CPU_BY_SOCKET);
            statement.setString(1, socket.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CPU cpu = new CPU();
                cpu.setId(resultSet.getInt("id"));
                cpu.setPrice(resultSet.getInt("price"));
                cpu.setName(resultSet.getString("name"));
                cpu.setBrand(resultSet.getString("brand"));
                cpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                cpu.setTDP(resultSet.getInt("TDP"));
                cpu.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cpu.setCore(resultSet.getInt("core"));
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cpus;
    }

    public List<CPU> findComponentByTDP(int TDP) throws DaoException {
        List<CPU> cpus = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQl_SELECT_CPU_BY_TDP);
            statement.setInt(1, TDP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CPU cpu = new CPU();
                cpu.setId(resultSet.getInt("id"));
                cpu.setPrice(resultSet.getInt("price"));
                cpu.setName(resultSet.getString("name"));
                cpu.setBrand(resultSet.getString("brand"));
                cpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                cpu.setTDP(resultSet.getInt("TDP"));
                cpu.setSocket(Socket.valueOf(resultSet.getString("socket")));
                cpu.setCore(resultSet.getInt("core"));
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return cpus;
    }
}
