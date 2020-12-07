package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    static String URL = "jdbc:mysql://localhost:3306/testdb";
    static String USERNAME = "root";
    static String PASSWORD = "root1";

    Connection connection = null;

    public Util() {
        Driver driver = null;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

/*        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("драйвер не подключился");
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) System.out.println("соединение с БД установлено");
        } catch (SQLException e) {
            System.out.println(e);
        }*/
    }

    public Connection getConnection() {
        return connection;
    }
}
