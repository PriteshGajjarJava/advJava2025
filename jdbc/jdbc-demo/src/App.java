import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Step 1: Load JDBC Driver class from JAR file
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded...");
        }catch(Exception e) {
            e.printStackTrace();
        }

        // Step 2: Create DB connection
        String jdbcURL = "jdbc:mysql://localhost/college"; // collge is DB name
        Connection connection = DriverManager.getConnection(jdbcURL, "root", ""); // last parameter is password

        // Step 3: Create Statement
        Statement st = connection.createStatement();

        // Take input
        System.out.println("Enter ID: ");
        int id = sc.nextInt();

        System.out.println("Enter Name: ");
        String name = sc.next();

        System.out.println("Enter Marks: ");
        float marks = sc.nextFloat();

        // insert into student values(3, 'pga3', 83)
        String query = "Insert into student values(" + id + ",'" + name + "'," + marks +")";


        // Step 4: Execute query
        st.executeUpdate(query);

        // Stpe 5: Close connection
        connection.close();
    }
}
