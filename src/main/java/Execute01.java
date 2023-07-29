import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // First Step: --> Register Driver
        // If it cannot reach the driver it will throw an exception

        Class.forName("org.postgresql.Driver");

        // Second Step: Create connection
        // we are going to type our database that we created in pgAdmin
        // Here we are adding SQLException because IntelliJ is wondering what to do if there is no database, it will throw exception.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");

        // test if connection is established.
        System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        //Statement stmt = con.createStatement();

        // Step Four:

        // task 1.
        // create a table named employee with column names
        // of : "employee_id", "employee_name", salary

        //boolean sql = stmt.execute("CREATE TABLE employee(employee_id SMALLINT,employee_name VARCHAR(20),salary REAL);\n");
        // execute() method is a boolean value where it will return T/F value.
        // after running this CREATE TABLE, we need to comment it out because we will get an error if we try running the code again.
        // when it is used in DDL -> Data Definition Language meaning (CREATE/DROP/UPDATE Table) returns T/F
        // when it is used in DQL -> Data Query Language meaning (SELECT...) it returns T/F

        //System.out.println("sqlCreated: "+sql);

//        String query2 = "ALTER TABLE employee ADD COLUMN city VARCHAR(20)";
//        boolean sql2 = stmt.execute(query2);

        // Task 3 DELETE employee table from schema
        //String query3 = "DROP TABLE employee";
        //stmt.execute(query3);

        // Step 5: last step is to close connection and close statement
        //con.close();
        //stmt.close();


    }
}
