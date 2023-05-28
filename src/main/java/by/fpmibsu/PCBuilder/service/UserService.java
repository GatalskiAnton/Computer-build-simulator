package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import by.fpmibsu.PCBuilder.service.utils.GoogleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class UserService implements UserServiceI {
    private static Logger log = LogManager.getLogger(UserService.class);

    @Override
    public boolean isExist(String login) throws DaoException {
        UserDao userDao = new UserDao();
        return userDao.findUserByLogin(login).getLogin() != null;
    }

    @Override
    public boolean isCorrectUser(String login, String password) throws DaoException, GoogleException {
        UserDao userDao = new UserDao();
        User user = userDao.findUserByLogin(login);
        if(user == null || user.getLogin() == null) {
            return false;
        }
        if (user.isFromGoogle()) {
            throw new GoogleException("Login using google account.");
        }
        return Authentication.isCorrectPassword(password, user.getHashPassword());
    }

    @Override
    public User changePassword(User user, String newPassword) throws DaoException {
        UserDao userDao = new UserDao();
        user.setHashPassword(Authentication.getHashPassword(newPassword));
        User newUser = userDao.update(user);
        return newUser;
    }

    @Override
    public boolean createUser(String login, String password, boolean fromGoogle) throws DaoException {
        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setHashPassword(Authentication.getHashPassword(password));
        newUser.setEmail(login);
        newUser.setAdmin(false);
        newUser.setFromGoogle(fromGoogle);
        int result = userDao.insert(newUser);
        return result != 0;
    }

    @Override
    public boolean createUserByGoogle(String login) throws DaoException {
        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setFromGoogle(true);
        newUser.setLogin(login);
        newUser.setHashPassword("");
        newUser.setAdmin(false);
        newUser.setEmail(login);
        return userDao.insertByLogin(newUser) != 0;
    }

    @Override
    public User getUser(String login) {
        UserDao userDao = new UserDao();
        try {
            return userDao.findUserByLogin(login);
        } catch (DaoException e) {
            return null;
        }
    }
}
