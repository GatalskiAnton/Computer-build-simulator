package by.fpmibsu.PCBuilder.runner;

import java.sql.*;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {
        System.setProperty("log4j.configurationFile", "file:\\\\C:\\Users\\ag629\\IdeaProjects\\tomcat\\src\\main\\resources\\log4j2.xml");
        UserDao userDao = new UserDao();
        System.out.println(userDao.findUserByLogin("Eugene"));
    }
}