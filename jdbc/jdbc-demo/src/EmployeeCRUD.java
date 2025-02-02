import java.sql.*;

public class EmployeeCRUD {
    // Add
    static public void addEmployee(int id, String name, float salary) throws SQLException {
        Connection con = DBUtils.getDbConnection();
        PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setFloat(3, salary);
        ps.executeUpdate();
        System.out.println("Record added successfully..");
    }

    // Delete
    static public void deleteEmployee(int id) throws SQLException {
        Connection con = DBUtils.getDbConnection();
        PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Record deleted successfully..");
    }

    // Updata Salary
    static public void updateSalary(int id, float salary) throws SQLException {
        Connection con = DBUtils.getDbConnection();
        PreparedStatement ps = con.prepareStatement("update emp set salary=? where id=?");
        ps.setFloat(1, salary);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Record updated successfully..");
    }

    // Select * from Emp
    static public void showAllEmp() throws SQLException {
        Connection con = DBUtils.getDbConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from emp");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float sal = rs.getFloat("salary");
            System.out.println("{" + id + "," + name + "," + sal +"}");
        }
    }
}
