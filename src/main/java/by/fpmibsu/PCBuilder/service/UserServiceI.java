package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.service.utils.GoogleException;

public interface UserServiceI {
    boolean isExist(String login) throws DaoException;

    boolean isCorrectUser(String login, String password) throws DaoException, GoogleException;

    User changePassword(User user, String hashPassword) throws DaoException;

    boolean createUser(String login, String password) throws DaoException;

    boolean createUserByGoogle(String login) throws DaoException;

}
