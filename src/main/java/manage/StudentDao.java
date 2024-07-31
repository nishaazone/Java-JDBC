package manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDb(Student st) {

        boolean f = false;
        // jdbc code...
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "insert into students (sName, sPhone, sCity) values (?,?,?)";

            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value of parameters
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            // execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f = false;
        // jdbc code...
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "delete from students where sId=?";

            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value of parameters
            pstmt.setInt(1, userId);

            // execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public static void showAllStudents() {
        // jdbc code...
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "select * from students";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            System.out.println("+++++++++++++++++++++++++++++++++++");
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);
                System.out.println("Id :" + id);
                System.out.println("Name :" + name);
                System.out.println("Phone :" + phone);
                System.out.println("City :" + city);
                System.out.println("+++++++++++++++++++++++++++++++++++");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean updateStudent(Student st, int userIdUp) {
        boolean f = false;
        // jdbc code...
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "UPDATE students SET sName = ?, sPhone = ?, sCity = ? where sId = ?";

            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value of parameters
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());
            pstmt.setInt(4, userIdUp);

            // execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
}
