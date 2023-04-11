package by.fpmibsu.PCBuilder.runner;

import java.sql.*;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.utils.ComponentParser;
import by.fpmibsu.PCBuilder.dao.utils.ComponentToJSONConverter;
import by.fpmibsu.PCBuilder.db.ConnectionCreator;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.PCCase;
//import org.json.JSONObject;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import by.fpmibsu.PCBuilder.entity.component.RAM;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

public class Runner {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DaoException, InterruptedException {


    }
}