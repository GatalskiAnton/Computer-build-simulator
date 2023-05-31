package by.fpmibsu.PCBuilder.runner;

import java.sql.*;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDaoImpl;
import by.fpmibsu.PCBuilder.service.CoolerServiceImpl;
import by.fpmibsu.PCBuilder.service.PCServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {
//        System.setProperty("log4j.configurationFile", ".\\src\\main\\resources\\log4j2.xml");
        Logger log = LogManager.getLogger(CoolerServiceImpl.class);

        log.error("error");


        PCServiceImpl pcService = new PCServiceImpl();
        System.out.println(pcService.getPc("svidevich@gmail.com"));
    }
}