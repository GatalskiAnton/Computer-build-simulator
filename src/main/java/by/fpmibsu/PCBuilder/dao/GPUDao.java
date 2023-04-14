package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GPUDao implements ComponentDaoI<Integer, GPU> {

    private static final String SQL_SELECT_ALL_GPU = "SELECT * FROM gpu";

    private static final String SQL_SELECT_GPU_BY_ID = "SELECT * FROM gpu WHERE id = ?";

    private static final String SQL_UPDATE_GPU = "UPDATE gpu SET id = ?, price = ?, name = ?, brand = ?, clockSpeed = ?, videoMemoryType = ?, videoMemory = ? WHERE id = ?";

    private static final String SQl_DELETE_GPU_BY_ID = "DELETE FROM gpu WHERE id = ?";

    private static final String SQL_DELETE_GPU = "DELETE FROM gpu WHERE id = ? AND price = ? AND name = ? AND brand = ? AND clockSpeed = ? AND video = ? AND TDP = ? AND core = ?";

    private static final String SQL_INSERT_GPU = "INSERT INTO gpu(id, price, name, brand, clockSpeed, videoMemoryType, videoMemory) VALUES (?,?,?,?,?,?,?)";


    @Override
    public List<GPU> findAll() throws DaoException {
        List<GPU> gpus = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_GPU);
            while (resultSet.next()){
                GPU gpu = new GPU();
                gpu.setId(resultSet.getInt("id"));
                gpu.setPrice(resultSet.getInt("price"));
                gpu.setName(resultSet.getString("name"));
                gpu.setBrand(resultSet.getString("brand"));
                gpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                gpu.setVideoMemoryType(VideoMemoryType.valueOf(resultSet.getString("videoMemoryType")));
                gpu.setVideoMemory(resultSet.getInt("videoMemory"));
                gpus.add(gpu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
    return gpus;
    }

    @Override
    public GPU findComponentById(Integer id) throws DaoException {
        GPU gpu = new GPU();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_GPU_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                gpu.setId(resultSet.getInt("id"));
                gpu.setPrice(resultSet.getInt("price"));
                gpu.setName(resultSet.getString("name"));
                gpu.setBrand(resultSet.getString("brand"));
                gpu.setClockSpeed(resultSet.getInt("clockSpeed"));
                gpu.setVideoMemoryType(VideoMemoryType.valueOf(resultSet.getString("videoMemoryType")));
                gpu.setVideoMemory(resultSet.getInt("videoMemory"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return gpu;
    }

    @Override
    public GPU update(GPU gpu) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_GPU);
            statement.setInt(1, gpu.getId());
            statement.setInt(2,gpu.getPrice());
            statement.setString(3,gpu.getName());
            statement.setString(4,gpu.getBrand());
            statement.setInt(5, gpu.getClockSpeed());
            statement.setString(6,gpu.getVideoMemoryType().toString());
            statement.setInt(7, gpu.getVideoMemory());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return gpu;
    }

    @Override
    public boolean delete(GPU gpu) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_GPU);
            statement.setInt(1, gpu.getId());
            statement.setInt(2,gpu.getPrice());
            statement.setString(3,gpu.getName());
            statement.setString(4,gpu.getBrand());
            statement.setInt(5, gpu.getClockSpeed());
            statement.setString(6,gpu.getVideoMemoryType().toString());
            statement.setInt(7, gpu.getVideoMemory());
            statement.setInt(8, gpu.getId());
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
            statement = connection.prepareStatement(SQl_DELETE_GPU_BY_ID);
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
    public int insert(GPU gpu) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_GPU);
            statement.setInt(1, gpu.getId());
            statement.setInt(2,gpu.getPrice());
            statement.setString(3,gpu.getName());
            statement.setString(4,gpu.getBrand());
            statement.setInt(5, gpu.getClockSpeed());
            statement.setString(6, gpu.getVideoMemoryType().toString());
            statement.setInt(7, gpu.getVideoMemory());
            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
