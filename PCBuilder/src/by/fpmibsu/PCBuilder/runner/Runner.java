package by.fpmibsu.PCBuilder.runner;
import java.sql.*;

import by.fpmibsu.PCBuilder.dao.utils.ComponentParser;
import org.json.JSONObject;
public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String jsonString = "{id :1, price: 30, name: supply1, brand: brand1, TDP: 100, socket: AM4, diameter:25}";
        ComponentParser parser = new ComponentParser();
        System.out.println(parser.parseCooler(jsonString));

    }
}