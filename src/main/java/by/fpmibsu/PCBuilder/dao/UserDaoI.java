package by.fpmibsu.PCBuilder.dao;

import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDaoI<K, U extends User> {
    List<U> findAll() throws DaoException;

    U findUserById(K id) throws DaoException;

    U update(U u) throws DaoException;

    boolean delete(U u) throws DaoException;

    boolean delete(K id) throws DaoException;

    int insert(U u) throws DaoException;

    default void close(Connection connection) throws DaoException {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    int insertByLogin(U user) throws DaoException;

    int getPcById(K id) throws  DaoException;
}