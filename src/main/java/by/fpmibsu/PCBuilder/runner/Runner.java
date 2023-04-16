package by.fpmibsu.PCBuilder.runner;
import java.sql.*;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {
    UserDao userDao = new UserDao();
    userDao.insert(new User(10,"111", "222",false,"gggg"));


    }
}