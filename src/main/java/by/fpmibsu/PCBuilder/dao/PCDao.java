package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.*;
import by.fpmibsu.PCBuilder.entity.component.Cooler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCDao implements PCDaoI<Integer, PC> {

    private static final String SQL_SELECT_ALL_PC = "SELECT * FROM pc";
    private static final String SQL_SELECT_PC_BY_ID = "SELECT * FROM pc WHERE id = ?";

    private static final String SQL_UPDATE_PC = "UPDATE pc SET id = ?, userId = ?, powersupplyId = ?, ssdId = ?, hddId = ?," +
            " pccaseId = ?, motherboardId = ?, gpuId = ?, cpuId = ?, coolerId = ?, ramId = ? WHERE id = ?";

    private static final String SQl_DELETE_PC_BY_ID = "DELETE FROM pc WHERE id = ?";

    private static final String SQL_INSERT_EMPTY_PC = "INSERT INTO pc(id,userId) VALUES(?,?)";

    private static final String SQL_INSERT_PC = "INSERT INTO pc(id, userId, powersupplyId, ssdId, hddId, pccaseId, motherboardId, gpuId, cpuId, coolerId, ramId) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    public List<PC> findAll() throws DaoException {
        List<PC> PCs = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PC);
            while (resultSet.next()){
                PC pc = new PC();
                GetPc(pc, resultSet);
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
            while (resultSet.next()){
                GetPc(pc, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return pc;
    }

    private void GetPc(PC pc, ResultSet resultSet) throws SQLException, DaoException {
        pc.setId(resultSet.getInt("id"));
        pc.setUserId(resultSet.getInt("userId"));
        PowerSupplyDao powerSupplyDao = new PowerSupplyDao();
        pc.setPowerSupply(powerSupplyDao.findComponentById(resultSet.getInt("powerSupplyId")));
        SSDDao ssdDao = new SSDDao();
        pc.setSsd(ssdDao.findComponentById(resultSet.getInt("ssdId")));
        HDDDao hddDao = new HDDDao();
        pc.setHdd(hddDao.findComponentById(resultSet.getInt("hddId")));
        PCCaseDao pcCaseDao = new PCCaseDao();
        pc.setPCCase(pcCaseDao.findComponentById(resultSet.getInt("pccaseId")));
        MotherboardDao motherboardDao = new MotherboardDao();
        pc.setMotherboard(motherboardDao.findComponentById(resultSet.getInt("motherboardId")));
        GPUDao gpuDao = new GPUDao();
        pc.setGpu(gpuDao.findComponentById(resultSet.getInt("gpuId")));
        CPUDao cpuDao = new CPUDao();
        pc.setCpu(cpuDao.findComponentById(resultSet.getInt("cpuId")));
        CoolerDao coolerDao = new CoolerDao();
        pc.setCooler(coolerDao.findComponentById(resultSet.getInt("coolerId")));
        RAMDao ramDao = new RAMDao();
        pc.setRam(ramDao.findComponentById(resultSet.getInt("ramId")));
    }

    @Override
    public PC update(PC pc) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_UPDATE_PC);
            fillStatement(pc, statement);
            statement.setInt(12, pc.getId());
            statement.executeUpdate();
            return pc;
        } catch (SQLException e) {
            System.out.println(e);
            return  null;
        }
    }

    private static void fillStatement(PC pc, PreparedStatement statement) throws SQLException {
        statement.setInt(1, pc.getId());
        statement.setInt(2, pc.getUserId());
        statement.setInt(3, pc.getPowerSupply() != null ? pc.getPowerSupply().getId(): null);
        statement.setInt(4, pc.getSsd() != null ? pc.getSsd().getId(): null);
        statement.setInt(5, pc.getHdd() != null ? pc.getHdd().getId(): null);
        statement.setInt(6, pc.getPCCase() != null ? pc.getPCCase().getId(): null);
        statement.setInt(7, pc.getMotherboard() != null ? pc.getMotherboard().getId(): null);
        statement.setInt(8, pc.getGpu() != null ? pc.getGpu().getId(): null);
        statement.setInt(9, pc.getCpu() != null ? pc.getCpu().getId(): null);
        statement.setInt(10, pc.getCooler() != null ? pc.getCooler().getId(): null);
        statement.setInt(11, pc.getRam() != null ? pc.getRam().getId(): null);
    }

    @Override
    public boolean delete(PC pc) throws DaoException {
        return delete(pc.getId());
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQl_DELETE_PC_BY_ID);
            statement.setInt(1, id);
            statement.executeQuery();
            return  true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int insert(PC pc) throws DaoException{
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_PC);
            fillStatement(pc, statement);
            rowsUpdate = statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return rowsUpdate;
    }

    @Override
    public int insertEmpty(PC pc) throws DaoException {
        int rowsUpdate;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_INSERT_EMPTY_PC);
            statement.setInt(1, 0);
            statement.setInt(2, pc.getUserId());
            rowsUpdate = statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
        }
        return rowsUpdate;
    }
}
