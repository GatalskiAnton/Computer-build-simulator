package by.fpmibsu.PCBuilder.runner;
import java.sql.*;

import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {


        CoolerDao coolerDao = new CoolerDao();
        System.out.println(coolerDao.findAll());


    }
}