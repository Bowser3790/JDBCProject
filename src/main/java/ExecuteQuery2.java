import java.sql.*;

public class ExecuteQuery2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            // First Step: --> Register Driver
            // If it cannot reach the driver it will throw an exception

            Class.forName("org.postgresql.Driver");

            // Second Step: Create connection
            // we are going to type our database that we created in pgAdmin
            // Here we are adding SQLException because IntelliJ is wondering what to do if there is no database, it will throw exception.
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                    "dev_user", "password");

            // test if connection is established.
            //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

            // Step Three: Create Statement (to create SQL query)

            Statement stmt = con.createStatement();
// example 1 *****************************************
//            String query1 = "SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10\n";
//            boolean result = stmt.execute(query1);
//            System.out.println("result: "+result);
//
//        // ******** to display query result we use ResultSet() and executeQuery() ******
//
//            ResultSet rs1 = stmt.executeQuery(query1);
            //rs1.next();
            //System.out.println(rs1.getString("country_name"));
        // Here in order to get the next() country name we would need to copy and paste this code
        // again and again if we want to get the next name and this would have to repeat 6 times to get the results
        // we will use a while-loop in order to get the results here.
        //rs1.next();
        //System.out.println(rs1.getString("country_name"));

//            while (rs1.next()){
//                System.out.println(rs1.getString("country_name"));
//                //System.out.println(rs1.getString(1));
//            }



//            System.out.println("********TASK 2********");
//
//            String query2 = "SELECT phone_code, country_name FROM countries WHERE phone_code > 600";
//            //boolean result2 = stmt.execute(query2);
//            //System.out.println("result2: " +result2);
//
//            ResultSet rs2 = stmt.executeQuery(query2);
//            while(rs2.next()){
//                System.out.println(rs2.getInt("phone_code") + " -- "
//                        + rs2.getString("country_name"));
//
//            }

            System.out.println("**********TASK 3*********");
            // Task 3 get all information about developers for whose salary is the lowest.

            String query3 = "SELECT * FROM developers WHERE salary = (SELECT MIN(salary) FROM developers)";
            ResultSet rs3 = stmt.executeQuery(query3);
            while(rs3.next()){
                System.out.println( rs3.getInt("id")+ " -- " + rs3.getString("name")
                        + " -- " +rs3.getInt("salary")+" -- " +rs3.getString("prog_lang"));
            }

            // TASK 3

        System.out.println("*******TASK 4********");
        // task is to display students grades that are higher than passing grades of departments

            String query4 = "SELECT name, grade FROM students WHERE grade > (SELECT AVG(pass_grade) FROM departments)";
            ResultSet rs4 = stmt.executeQuery(query4);
            while(rs4.next()){
                System.out.println( rs4.getString("name")+ " -- " + rs4.getInt("grade"));
            }

// ResultSet has other methods such as first() Last() next() NOTE there are no methods that go backwards only forward -->
















        // Step 5: last step is to close connection and close statement
            con.close();
            stmt.close();
        // if you run this you need to re-establish connection in pgAdmin


        }
}
