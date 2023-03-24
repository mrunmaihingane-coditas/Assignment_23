import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("STUDENT MANGEMENT ");
        Scanner sc = new Scanner(System.in);
        Connection con = Conectivity.connection();
        boolean flage = true;
        while (flage){
            System.out.println("ENTER 1 : add 10 recodrs");
            System.out.println("ENTER 2 : show all records");
            System.out.println("ENTER 3 : alter table by adding field ");
            System.out.println("ENTER 4 : fetch only thoes Emply who are from Pune and salary > 20000");
            System.out.println("ENTER 5 : Update salary by 1000 of employee whoes designmation SE ");
            System.out.println("ENTER 6 : Delete those employee who left the orgnization");
            System.out.println("ENTER 0 : EXIT ");
            int ch = sc.nextInt();
            Employee employee = new Employee();
            switch (ch){
                case 1:
                   employee.add10recordes();
                    break;
                case 2:
                    employee.showRecords();
                    break;
                case 3:
                    employee.alterTable();
                    break;
                case 4:
                    employee.fetch();
                    break;
                case 5:
                    employee.updateSEsalary();
                    break;
                case 6:
                    employee.delet();
                    break;
                case 0:
                    flage=false;
                    break;
            }
        }



    }
}