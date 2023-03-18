import by.fpmibsu.PCBuilder.entity.component.Motherboard;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pcbuilder", "root", "root");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            System.out.println(id + " " + login + " " + password);
        }
    }
}