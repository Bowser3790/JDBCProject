import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // test if connection is established.
        //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        Statement stmt = con.createStatement();


        System.out.println("********TASK 1********");
//        // update salaries of developers who salary is less than the average salary -> to the average salary.
//
//        String query01 = "UPDATE developers SET salary = (SELECT AVG(salary) FROM developers) " +
//                "WHERE salary < (SELECT AVG(salary) FROM developers)";
//         int updatedRows = stmt.executeUpdate(query01);
//             System.out.println("Updated Rows: " +updatedRows);


        //  TASK 2 add a new developer to developer table

        //System.out.println("************TASK 2***********");

    //        String query02 = "INSERT INTO developers(name,salary,prog_lang) VALUES('Gerard',7000,'C++') ";
    //        int numberOfInsertedRows = stmt.executeUpdate(query02);
    //        System.out.println("number of inserted rows: " + numberOfInsertedRows);

//        System.out.println("Task 3");
//        // DELETE rows with ID of 4
//        String query3 = "DELETE FROM developers WHERE id=4";
//
//        int numOfDeletedRows = stmt.executeUpdate(query3);
//        System.out.println(numOfDeletedRows + " deleted rows, successfully!");

        // task 4 DELETE rows from developers table if prog_lang is 'css'
//        String query4 = "DELETE FROM developers WHERE prog_lang LIKE 'Css'"; // variable is case sensitive
//
//        int numOfDeletedRows = stmt.executeUpdate(query4);
//        System.out.println(numOfDeletedRows + " deleted rows, successfully!");

        stmt.close();
        con.close();



    }

    }
