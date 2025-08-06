import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlInjection {
    public void searchProducts(String product_name) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
             Statement stmt = con.createStatement()) {
            
            // Vulnerable line: direct concatenation of user input into the SQL query
            String query = "SELECT * FROM products WHERE name = '" + product_name + "'";
            
            // Execution of the vulnerable query
            stmt.executeQuery(query);
            System.out.println("Query executed: " + query);
        }
    }
}
