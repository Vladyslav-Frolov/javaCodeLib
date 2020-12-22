package info.vladyslav.javabasics.u02jdbc.jdbc01base;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {
        /**
         * эта строка загружает драйвер DB.
         * раскомментируйте если прописываете драйвер вручную, но этого уже не нужно лет как 10-15
         */
        //Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bank?serverTimezone=EST5EDT",
                "root", "qwert")) {


            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");

            while (rs.next()) {
                System.out.println(rs.getRow() + ". " + rs.getString("account_id")
                        + "\t" + rs.getString("product_cd"));
            }

            /**
             * stmt.close();
             * При закрытии Statement автоматически закрываются
             * все связанные с ним открытые объекты ResultSet
             */
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
