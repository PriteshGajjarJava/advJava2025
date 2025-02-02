import java.sql.SQLException;
import java.util.Scanner;

public class EmpCrudDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" ********** \n 1: Add \n 2: Update Salary \n 3: Delete \n 4: Show All \n 5: Exit \n ********** \n" + //
                                " ");
            System.out.println("Enter your choice (1-5): ");
            int choice = sc.nextInt();
            if (choice == 5) {
                DBUtils.closeConnection();
                System.exit(0);
            }

            int id = 0; String name = null; float sal = 0;
            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    System.out.println("Enter Name: ");
                    name = sc.next();
                    System.out.println("Enter Salary: ");
                    sal = sc.nextFloat();
                    try {
                     EmployeeCRUD.addEmployee(id, name, sal);
                    } catch(SQLException e) {
                        System.out.println("Error while adding record.." + e);
                    }
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    System.out.println("Enter New Salary: ");
                    sal = sc.nextFloat();
                    try {
                        EmployeeCRUD.updateSalary(id, sal);
                    } catch(SQLException e) {
                        System.out.println("Error while updating record.." + e);
                    }
                break;
                case 3:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    try {
                    EmployeeCRUD.deleteEmployee(id);
                    } catch(SQLException e) {
                        System.out.println("Error while deleting record.." + e);
                    }

                    break;
                case 4:
                try {
                        EmployeeCRUD.showAllEmp();
                    } catch(SQLException e) {
                        System.out.println("Error while retrieving data.." + e);
                    }
                    break;
                default: System.out.println("Invalid choice..");
            }
        }

    }
}
