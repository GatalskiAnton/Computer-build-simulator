package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import by.fpmibsu.PCBuilder.service.utils.GoogleException;

public class UserService implements UserServiceI {

    @Override
    public boolean isExist(String login) throws DaoException {
        UserDao userDao = new UserDao();
        return userDao.findUserByLogin(login) != null;
    }

    @Override
    public boolean isCorrectUser(String login, String password) throws DaoException, GoogleException {
        UserDao userDao = new UserDao();
        User user = userDao.findUserByLogin(login);
        if (user.isFromGoogle()) {
            throw new GoogleException("Login using google account.");
        }
        return Authentication.isCorrectPassword(password, user.getHashPassword());
    }

    @Override
    public User changePassword(User user, String newHashPassword) throws DaoException {
        UserDao userDao = new UserDao();
        user.setHashPassword(newHashPassword);
        User newUser = userDao.update(user);
        return newUser;
    }

    @Override
    public boolean createUser(String login, String password) throws DaoException {
        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setHashPassword(Authentication.getHashPassword(password));
        newUser.setEmail(login);
        newUser.setAdmin(false);
        int result = userDao.insert(newUser);
        return result != 0;
    }

    @Override
    public boolean createUserByGoogle(String login) throws DaoException {
        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setFromGoogle(true);
        newUser.setLogin(login);
        newUser.setHashPassword(null);
        newUser.setAdmin(false);
        newUser.setEmail(login);
        return userDao.insertByLogin(newUser) != 0;
    }
}
