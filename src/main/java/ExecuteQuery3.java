import java.sql.*;

public class ExecuteQuery3 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // test if connection is established.
        //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        Statement stmt = con.createStatement();

        // task 1

        // Print the department with the 2nd highest pass_grade

        String query5 = "SELECT department, pass_grade FROM departments ORDER BY pass_grade DESC OFFSET 1 LIMIT 1";
        ResultSet rs5 = stmt.executeQuery(query5);
        while(rs5.next()){
            System.out.println(rs5.getString("department") + " -- " + rs5.getInt("pass_grade"));
        }
        System.out.println("TASK 2");
        // Print the department with the 2nd highest pass_grade using sub-query
        String query6 = "SELECT department, pass_grade FROM departments WHERE pass_grade = (SELECT MAX(pass_grade)" +
                "FROM departments WHERE pass_grade<(SELECT MAX(pass_grade) FROM departments))";
        ResultSet rs6 = stmt.executeQuery(query6);
        while (rs6.next()){
            System.out.println(rs6.getString("department") + " -- " + rs6.getInt("pass_grade"));
        }

        // TASK 3
        System.out.println("TASK 3");

        // LIST department name campus and highest grades of students from every department

        String query7 = "SELECT department, campus, (SELECT MAX(grade) FROM students s " +
                "WHERE s.department = d.department) max_grade FROM departments d";
        ResultSet rs7 = stmt.executeQuery(query7);
        while(rs7.next()){
            System.out.println(rs7.getString("department") + " -- " + rs7.getString("campus")
            + " -- " + rs7.getInt("max_grade"));

        }

        con.close();
        stmt.close();



    }
}
