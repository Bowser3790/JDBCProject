import java.sql.*;

public class transactions01 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // test if connection is established.
        //System.out.println("Connection Created Successfully"); // will show if everything runs above. (ran successfully)

        // Step Three: Create Statement (to create SQL query)

        Statement stmt = con.createStatement();

        String query01 = "UPDATE accounts SET amount = amount + ? WHERE account_nu=?";
        PreparedStatement ps1 = con.prepareStatement(query01);
        con.setAutoCommit(false); // false if you want to manually commit.
        // below is where ACID comes into play see transactions in PosgreSQL notes in quizlett.
        Savepoint sp = null;

        try {
            sp = con.setSavepoint(); // rollback will come back to this point.
            ps1.setDouble(1, -1000);
            ps1.setInt(2, 1234);
            ps1.executeUpdate();

            // suppose there is an issue in the system.
            if (false) {
                throw new Exception();
            }


            ps1.setDouble(1, 1000);
            ps1.setInt(2, 5678);
            ps1.executeUpdate();
            con.commit();// this makes data persistant.. this is a manual commit so you should set con.autocommit above to false.  If you dont have this then you should use auto commit.
            // think of this as a git hub commit to make the update to your repository.
            ps1.close();
            con.close();// isolate
        }catch (Exception e){
            con.rollback(sp); // cancels all previous transactions/ activities... returns to savePoint sp
        }
        }
}
