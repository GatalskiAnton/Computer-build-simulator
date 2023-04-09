package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.entity.component.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ComponentDaoI<K, C extends Component> {
    List<C> findAll() throws DaoException;
    C findComponentById(K id) throws DaoException;
    C update(C c) throws DaoException;
    boolean delete(C c) throws DaoException;
    boolean delete(K id) throws DaoException;
    int insert(C c) throws DaoException;
    default void close(Connection connection) throws DaoException{
        try {
            if (connection != null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
