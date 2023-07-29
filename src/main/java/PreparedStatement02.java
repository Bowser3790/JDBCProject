import java.sql.*;

public class PreparedStatement02 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // test if connection is established.
        //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        Statement stmt = con.createStatement();

        // using preparedStatment, DELETE students who are from 'Math Department' from students table

        String query01 = "DELETE FROM students WHERE department ILIKE ?";
        PreparedStatement ps1 = con.prepareStatement(query01);
        ps1.setString(1,"math");
        int numOfLinesDeleted = ps1.executeUpdate();
        System.out.println("Number of Lines Deleted: " + numOfLinesDeleted);

        // TASK 2 - Insert Software engineering department using prepared statement into departments table.
         //(id=5006, pass_grade = 475, campus = 'South')

        String query02 = "DELETE FROM departments WHERE department ILIKE ?";
        PreparedStatement ps2 = con.prepareStatement(query02);
        ps2.setString(1,"computers");
        int numOfLinesDeleted = ps2.executeUpdate();
        System.out.println("Number of Lines Deleted: " + numOfLinesDeleted);

        String query03 = "INSERT INTO departments VALUES(?,?,?,?)";
        PreparedStatement ps3 = con.prepareStatement(query03);
        ps3.setInt(1,5006);
        ps3.setString(2,"software_engineering");
        ps3.setInt(3,475);
        ps3.setString(4,"South");
        int numOfLinesUpdated = ps3.executeUpdate();
        System.out.println(numOfLinesUpdated + " --> Updated Lines!!!");

        stmt.close();
        con.close();




    }
}
