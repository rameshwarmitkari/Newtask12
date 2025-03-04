package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Q2 {
	public static void main(String[] args) throws Exception {
        // Establish connection to MySQL database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestSql", "root", "Ram@1234");

        // Create a statement
        Statement st = con.createStatement();

        // SQL query to create the table if not exists
        String createTableSQL = "CREATE TABLE employees9 ("
                + " empcode INT PRIMARY KEY, "
                + " empname VARCHAR(50) NOT NULL, "
                + " empage INT NOT NULL, "
                + " esalary INT NOT NULL "
                + " )";
        st.execute(createTableSQL);

        // Insert data into the table
        st.executeUpdate("INSERT INTO employees9 (empcode, empname, empage, esalary) VALUES "
                + "(101, 'Jenny', 25, 10000), "
                + "(102, 'Jacky', 30, 20000), "
                + "(103, 'Joe', 20, 40000), "
                + "(104, 'John', 40, 80000), "
                + "(105, 'Shameer', 25, 90000)");

        // Retrieve and display data
        String query = "SELECT * FROM employees9";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int empcode = rs.getInt("empcode");
            String empname = rs.getString("empname");
            int empage = rs.getInt("empage");
            int esalary = rs.getInt("esalary");

            System.out.println(empcode + " | " + empname + " | " + empage + " | " + esalary);
        }

        System.out.println("Data inserted successfully!");

        // Close connections
        rs.close();
        st.close();
        con.close();
    }


}
