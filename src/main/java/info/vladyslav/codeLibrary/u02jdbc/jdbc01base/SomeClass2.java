package info.vladyslav.codeLibrary.u02jdbc.jdbc01base;

import java.sql.*;

public class SomeClass2 {
    public static final String URL = "jdbc:mysql://localhost/hotel?serverTimezone=EST5EDT";
    public static final String USER = "root";
    public static final String PASSWORD = "qwert";

    public static final String SQL_FIND_FREE_ROOMS = "SELECT r.id                                                                                           'id',\n" +
            "       rt.full_name                                                                                   'room type',\n" +
            "       rc.name                                                                                        'room classes',\n" +
            "       rt.number_of_adults + rt.number_of_children                                                    'num',\n" +
            "       rt.number_of_adults                                                                            'adults',\n" +
            "       rt.number_of_children                                                                          'children',\n" +
            "       CAST((UNIX_TIMESTAMP(?) - UNIX_TIMESTAMP(?)) / (60 * 60 * 24) as SIGNED) 'days',\n" +
            "       r.cost_per_day                                                                                 `cost per day`,\n" +
            "       ROUND(((UNIX_TIMESTAMP('2020-10-14') - UNIX_TIMESTAMP('2020-10-01')) / (60 * 60 * 24) * r.cost_per_day),\n" +
            "             2)                                                                                       `total price`\n" +
            "FROM rooms r\n" +
            "         JOIN room_classes rc ON r.class_id = rc.id\n" +
            "         JOIN room_types rt ON r.type_id = rt.id\n" +
            "WHERE r.id NOT IN (\n" +
            "    SELECT r.id\n" +
            "    FROM hotel.order_flow ofl\n" +
            "             JOIN rooms r ON ofl.room_id = r.id\n" +
            "    WHERE ofl.check_out > '2020-10-01'\n" +
            "      and ofl.check_in < '2020-10-14'\n" +
            "      and ofl.room_order_status_id IN (1, 3, 4))";

    protected void someMethod() {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_FREE_ROOMS)) {

            int k = 1;
            ps.setString(k++, "2020-10-14");
            ps.setString(k, "2020-10-01");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("room type"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SomeClass2().someMethod();
    }
}