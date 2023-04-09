package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.PCCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PCDao implements PCDaoI<Integer, PC> {

    private static final String SQL_SELECT_ALL_PC = "SELECT * FROM pc";
    private static final String SQL_SELECT_PCCASE_BY_ID = "SELECT * FROM pc WHERE id = ?";

    private static final String SQL_UPDATE_PCCASE = "UPDATE pc SET id = ?, price = ?, name = ?, brand = ?, color = ? WHERE id = ?";

    private static final String SQl_DELETE_PCCASE_BY_ID = "DELETE FROM pc WHERE id = ?";

    private static final String SQL_DELETE_PCCASE = "DELETE FROM pc WHERE id = ?, price = ?, name = ?, brand = ?, color = ?";

    private static final String SQL_INSERT_PCCASE = "INSERT INTO pc(id, price, name, brand, color) VALUES (?,?,?,?,?)";

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
                //json format data??

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
        return null;
    }

    @Override
    public PC update(PC pc) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(PC pc) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public int insert(PC pc) {
        return 0;
    }
}
