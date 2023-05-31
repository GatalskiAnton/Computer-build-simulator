package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.dao.utils.PCComponents;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PCDao<K,PC extends by.fpmibsu.PCBuilder.entity.PC>{
    List<PCComponents> findAll() throws DaoException;
    PCComponents findPCById(K id) throws DaoException;
    PC update(PC pc) throws DaoException;
    boolean delete(PC pc) throws DaoException;
    boolean delete(K id) throws DaoException;
    int insert(PC pc) throws DaoException;
    default void close(Connection connection) throws DaoException{
        try {
            if (connection != null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    int insertEmpty(PC pc) throws DaoException;
}
