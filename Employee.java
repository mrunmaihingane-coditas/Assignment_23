import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Employee {

    Scanner sc = new Scanner(System.in);

    int id;
    String name;
    String designmation;
    String date ;
    int exp;
    int salary;
    String status; // working or left

    public void add10recordes(){
        Connection con = Conectivity.connection();
        try {
            for (int i =0;i<10;i++){
                System.out.println("Enter name");
                name = sc.nextLine();
                System.out.println("Enter designament");
                designmation=sc.nextLine();
                System.out.println("Enter date");
                date = sc.nextLine();
                System.out.println("ENTER salary");
                salary = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter status");
                status = sc.nextLine();
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee (name, desgnation, DOJ, salary, status) VALUES (?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,designmation);
            ps.setDate(3, Date.valueOf(date));
            ps.setInt(4,salary);
            ps.setString(5,status);
            ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void showRecords(){
        Connection con = Conectivity.connection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from employee");
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void alterTable(){
        Connection con = Conectivity.connection();
        try {
            PreparedStatement ps = con.prepareStatement("alter table employee add column city varchar(9) default 'Pune'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public void fetch(){
        Connection con = Conectivity.connection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name, salary, city from employee where city ='Pune' and salary < 20000");
            while (rs.next()){
                System.out.println(rs.getString("name")+"==="+rs.getInt("salary")+"==="+rs.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public void updateSEsalary(){
        Connection con = Conectivity.connection();
        try {
            PreparedStatement ps = con.prepareStatement("update employee set salary = salary+1000 where desgnation = 'SE'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public void delet(){
        Connection con = Conectivity.connection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from employee where status = 'LEFT'");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
