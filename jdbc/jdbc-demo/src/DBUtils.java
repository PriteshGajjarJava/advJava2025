import java.sql.*;
// Singleton Design Pattern
public class DBUtils {
    static Connection con = null;
    static Connection getDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.err.println("JDBC Driver class NOT found");
        }
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "");
            } catch (SQLException e1) {
                System.err.println("Error while creating connection...");
            }
        }
        return con;
    }

    static void closeConnection() {
        try {
            con.close();
        } catch(SQLException e) { }
    }
}
