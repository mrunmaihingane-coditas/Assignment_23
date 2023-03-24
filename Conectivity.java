import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectivity {
     static Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/coditas_eltp","root","Pass@123");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}