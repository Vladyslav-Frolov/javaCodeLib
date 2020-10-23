package info.vladyslav.codeLibrary.u02jdbc.jdbc01base;

import java.sql.*;

public class SomeClass {
    public static final String URL = "jdbc:mysql://localhost/hotel?serverTimezone=EST5EDT";
    public static final String USER = "root";
    public static final String PASSWORD = "qwert";

    public static final String SELECT_QUERY_COMPLEX =
            "SELECT id ?" + // num
                    "FROM rooms"; // r

    protected void someMethod() {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(SELECT_QUERY_COMPLEX)) {

            ps.setString(1, "num");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("num"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}