package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.dao.utils.ComponentParser;
import by.fpmibsu.PCBuilder.dao.utils.ComponentToJSONConverter;
import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCDao implements PCDaoI<Integer, PC> {

    private static final String SQL_SELECT_ALL_PC = "SELECT * FROM pc";
    private static final String SQL_SELECT_PC_BY_ID = "SELECT * FROM pc WHERE id = ?";

    private static final String SQL_UPDATE_PC = "UPDATE pc SET id = ?, powersuply = ?, ssd = ?, hdd = ?, pccase = ?, motherboard = ?, gpu = ?, cpu = ?, cooler = ?, ram = ? WHERE id = ?";

    private static final String SQl_DELETE_PC_BY_ID = "DELETE FROM pc WHERE id = ?";

    private static final String SQL_INSERT_PC = "INSERT INTO pc(id, powersuply, ssd, hdd, pccase, motherboard, gpu, cpu, cooler, ram)  VALUES (?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<PC> findAll() throws DaoException {
        List<PC> PCs = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PC);
            ComponentParser parser = new ComponentParser();
            while (resultSet.next()){
                PC pc = new PC();
                pc.setId(resultSet.getInt("id"));
                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
                pc.setPowerSupply(parser.parsePowerSupply(resultSet.getString("powersuply")));
                pc.setPCCase(parser.parsePCCase(resultSet.getString("pccase")));
                pc.setSsd(parser.parseSSD(resultSet.getString("ssd")));
                pc.setHdd(parser.parseHDD(resultSet.getString("hdd")));
                pc.setMotherboard(parser.parseMotherboard(resultSet.getString("motherboard")));
                pc.setGpu(parser.parseGPU(resultSet.getString("gpu")));
                pc.setCpu(parser.parseCPU(resultSet.getString("cpu")));
                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
                pc.setRam(parser.parseRAM(resultSet.getString("ram")));
                PCs.add(pc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return PCs;
    }

    @Override
    public PC findPCById(Integer id) throws DaoException {
        PC pc = new PC();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_PC_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            ComponentParser parser = new ComponentParser();
            while (resultSet.next()){
                pc.setId(resultSet.getInt("id"));
                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
                pc.setPowerSupply(parser.parsePowerSupply(resultSet.getString("powersuply")));
                System.out.println(resultSet.getString("powersuply"));
                pc.setPCCase(parser.parsePCCase(resultSet.getString("pccase")));
                pc.setSsd(parser.parseSSD(resultSet.getString("ssd")));
                pc.setHdd(parser.parseHDD(resultSet.getString("hdd")));
                pc.setMotherboard(parser.parseMotherboard(resultSet.getString("motherboard")));
                pc.setGpu(parser.parseGPU(resultSet.getString("gpu")));
                pc.setCpu(parser.parseCPU(resultSet.getString("cpu")));
                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
                pc.setRam(parser.parseRAM(resultSet.getString("ram")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return pc;
    }

    @Override
    public PC update(PC pc) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_PC);
            statement.setInt(1, pc.getId());
            statement.setString(2, ComponentToJSONConverter.PowerSupplyToJSON(pc.getPowerSupply()));
            statement.setString(3, ComponentToJSONConverter.ROMToJSON(pc.getSsd()));
            statement.setString(4, ComponentToJSONConverter.ROMToJSON(pc.getHdd()));
            statement.setString(5, ComponentToJSONConverter.PCCaseToJSON(pc.getPCCase()));
            statement.setString(6, ComponentToJSONConverter.MotherboardToJSON(pc.getMotherboard()));
            statement.setString(7, ComponentToJSONConverter.GPUToJSON(pc.getGpu()));
            statement.setString(8, ComponentToJSONConverter.CPUToJSON(pc.getCpu())) ;
            statement.setString(9, ComponentToJSONConverter.CoolerToJSON(pc.getCooler()));
            statement.setString(10, ComponentToJSONConverter.RAMToJSON(pc.getRam()));
            statement.setInt(11, pc.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return pc;
    }

    @Override
    public boolean delete(PC pc) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQl_DELETE_PC_BY_ID);
            statement.setInt(1, pc.getId());
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
            statement = connection.prepareStatement(SQl_DELETE_PC_BY_ID);
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
    public int insert(PC pc) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_PC);
            statement.setInt(1, pc.getId());
            statement.setString(2, ComponentToJSONConverter.PowerSupplyToJSON(pc.getPowerSupply()));
            statement.setString(3, ComponentToJSONConverter.ROMToJSON(pc.getSsd()));
            statement.setString(4, ComponentToJSONConverter.ROMToJSON(pc.getHdd()));
            statement.setString(5, ComponentToJSONConverter.PCCaseToJSON(pc.getPCCase()));
            statement.setString(6, ComponentToJSONConverter.MotherboardToJSON(pc.getMotherboard()));
            statement.setString(7, ComponentToJSONConverter.GPUToJSON(pc.getGpu()));
            statement.setString(8, ComponentToJSONConverter.CPUToJSON(pc.getCpu())) ;
            statement.setString(9, ComponentToJSONConverter.CoolerToJSON(pc.getCooler()));
            statement.setString(10, ComponentToJSONConverter.RAMToJSON(pc.getRam()));

            rowsUpdate = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }

        return rowsUpdate;
    }
}
