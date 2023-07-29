import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // test if connection is established.
        //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        Statement stmt = con.createStatement();
        // TASK 1 ->  UPDATE pass_grade to 475 of Mathematics department (use preparedStatement)

        String query01= "UPDATE departments SET pass_grade=? WHERE department ILIKE ?";
        PreparedStatement ps1=con.prepareStatement(query01);
        ps1.setInt(1,475); // 1 stands for the first ? in the query
        ps1.setString(2, "Math");// 2 stands for the 2nd ? in the query

        int numOfUpdatedRows = ps1.executeUpdate();
        System.out.println(numOfUpdatedRows + " Executed Successfully!");

//         Task 2
//         UPDATE pass_grade of Literature department to 455 (use PreparedStatement)

        String query02 = "UPDATE departments SET pass_grade=? WHERE department ILIKE ?";// ILIKE is case-insensitive, LIKE is case-sensitive
        PreparedStatement ps2 = con.prepareStatement(query02);
        ps2.setInt(1,455);
        ps2.setString(2,"English");
        int numOfRowsUpdated = ps2.executeUpdate();
        System.out.println(numOfRowsUpdated + " Rows Updated!");


        stmt.close();
        con.close();



    }
}
