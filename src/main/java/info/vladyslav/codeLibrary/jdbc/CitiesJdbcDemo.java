package info.vladyslav.codeLibrary.jdbc;

import java.sql.*;

/**
 * Надо смотреть чтобы версия сервера совпадала с версией зависимости в pom.xml.
 * Чтобы проверить сервер нужно внести команду в консоле (при работающей связи с сервером в Идее): SELECT version();
 * На момент написания кода версия сервера и зависимости <mysql-connector-java> 8.0.19
 */

public class CitiesJdbcDemo {
    /**
     * JDBC Driver and database url
     */
//    static final String JDBC_DRIVER = "com.mysql.cj.info.vladyslav.codeLibrary.jdbc.Driver"; // устарело лет 10-15 назад

    // ниже обязательно добавляем тайм-зону для SQL сервера → ?serverTimezone=EST5EDT
    static final String DATABASE_URL = "jdbc:mysql://localhost/world?serverTimezone=EST5EDT";
    // "world" это название базы данных, а в ней есть таблица "city" вот с ней и будем потом работать

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "qwert";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

//        System.out.println("Registering JDBC driver...");

//        Class.forName(JDBC_DRIVER); // устарело лет 10-15 назад, но если надо прописать, то раскомментировать

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM city";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String countryCode = resultSet.getString("countrycode");
            String district = resultSet.getString("district");
            int population = resultSet.getInt("population");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Country Code: " + countryCode);
            System.out.println("District: " + district);
            System.out.println("Population: " + population);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }

}
