package by.fpmibsu.PCBuilder.runner;
import java.sql.*;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.utils.ComponentParser;
import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import org.json.JSONObject;
public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException {
        PCDao pcDao = new PCDao();

        System.out.println(pcDao.findPCById(1));
    }
}