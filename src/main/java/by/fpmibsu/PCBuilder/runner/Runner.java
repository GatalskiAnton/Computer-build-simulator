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
import by.fpmibsu.PCBuilder.service.CoolerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {
        System.setProperty("log4j.configurationFile", ".\\src\\main\\resources\\log4j2.xml");
        Logger log = LogManager.getLogger(CoolerService.class);

        log.error("error");

        UserDao userDao = new UserDao();
        System.out.println(userDao.findUserByLogin("Eugene"));
    }
}