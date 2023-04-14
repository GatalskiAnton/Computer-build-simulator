//package by.fpmibsu.PCBuilder.dao;
//
//import by.fpmibsu.PCBuilder.db.ConnectionCreator;
//import by.fpmibsu.PCBuilder.entity.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PCDao implements PCDaoI<Integer, PC> {
//
//    private static final String SQL_SELECT_ALL_PC = "SELECT * FROM pc";
//    private static final String SQL_SELECT_PC_BY_ID = "SELECT * FROM pc WHERE id = ?";
//
//    private static final String SQL_UPDATE_PC = "UPDATE pc SET id = ?, price = ?, name = ?, brand = ?, color = ? WHERE id = ?";
//
//    private static final String SQl_DELETE_PC_BY_ID = "DELETE FROM pc WHERE id = ?";
//
//    private static final String SQL_DELETE_PC = "DELETE FROM pc WHERE id = ?, price = ?, name = ?, brand = ?, color = ?";
//
//    private static final String SQL_INSERT_PC = "INSERT INTO pc(id, price, name, brand, color) VALUES (?,?,?,?,?)";
//
//    @Override
//    public List<PC> findAll() throws DaoException {
//        List<PC> PCs = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = ConnectionCreator.createConnection();
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PC);
//            ComponentParser parser = new ComponentParser();
//            while (resultSet.next()){
//                PC pc = new PC();
//                pc.setId(resultSet.getInt("id"));
//                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
//                pc.setPowerSupply(parser.parsePowerSupply(resultSet.getString("powersuply")));
//                pc.setPCCase(parser.parsePCCase(resultSet.getString("pccase")));
//                pc.setSsd(parser.parseSSD(resultSet.getString("ssd")));
//                pc.setHdd(parser.parseHDD(resultSet.getString("hdd")));
//                pc.setMotherboard(parser.parseMotherboard(resultSet.getString("motherboard")));
//                pc.setGpu(parser.parseGPU(resultSet.getString("gpu")));
//                pc.setCpu(parser.parseCPU(resultSet.getString("cpu")));
//                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
//                pc.setRam(parser.parseRAM(resultSet.getString("ram")));
//                PCs.add(pc);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            close(connection);
//        }
//        return PCs;
//    }
//
//    @Override
//    public PC findPCById(Integer id) throws DaoException {
//        PC pc = new PC();
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = ConnectionCreator.createConnection();
//            statement = connection.prepareStatement(SQL_SELECT_PC_BY_ID);
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            ComponentParser parser = new ComponentParser();
//            while (resultSet.next()){
//                pc.setId(resultSet.getInt("id"));
//                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
//                pc.setPowerSupply(parser.parsePowerSupply(resultSet.getString("powersuply")));
//                pc.setPCCase(parser.parsePCCase(resultSet.getString("pccase")));
//                pc.setSsd(parser.parseSSD(resultSet.getString("ssd")));
//                pc.setHdd(parser.parseHDD(resultSet.getString("hdd")));
//                pc.setMotherboard(parser.parseMotherboard(resultSet.getString("motherboard")));
//                pc.setGpu(parser.parseGPU(resultSet.getString("gpu")));
//                pc.setCpu(parser.parseCPU(resultSet.getString("cpu")));
//                pc.setCooler(parser.parseCooler(resultSet.getString("cooler")));
//                pc.setRam(parser.parseRAM(resultSet.getString("ram")));
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            close(connection);
//        }
//        return pc;
//    }
//
//    @Override
//    public PC update(PC pc) throws DaoException {
//        return null;
//    }
//
//    @Override
//    public boolean delete(PC pc) throws DaoException {
//        return false;
//    }
//
//    @Override
//    public boolean delete(Integer id) throws DaoException {
//        return false;
//    }
//
//    @Override
//    public int insert(PC pc) {
//        return 0;
//    }
//}
