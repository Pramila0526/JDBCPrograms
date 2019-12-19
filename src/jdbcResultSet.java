import java.sql.*;

public class jdbcResultSet {
   public static void main(String[] args) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/alldata","root", "root");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
         System.out.println("id  name    job");
         
         while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dept = rs.getString("dept");
            String salary = rs.getString("salary");
            System.out.println(id+"   "+name+"    "+dept+ "   " +salary);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}