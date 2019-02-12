/*******
 Customer DataBase Access/Connection 
 *******/
 
package BusinessObjects;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class CustomerClass {

  public static void main(String[] args){
      
      Path path = Paths.get("accounts_database.accdb");
      String database = path.toFile().getAbsolutePath();
      
        try{
               Connection con =
               DriverManager.getConnection("jdbc:ucanaccess://"+database);
               Statement stmt = con.createStatement();
               String sql = "SELECT * from Customer";
               System.out.println(sql);
               ResultSet rs = stmt.executeQuery(sql);
               
               while(rs.next()){
                   System.out.println("ID: " + rs.getString(1));
                   System.out.println("UserName: " + rs.getString(2));
                   System.out.println("Password: " + rs.getString(3));
                   System.out.println("FirstName: " + rs.getString(4));
                   System.out.println("LastName: " + rs.getString(5));
                   System.out.println("Email: " + rs.getString(6));
                   System.out.println("Address: " + rs.getString(7));
                   System.out.println("CardNumber: " + rs.getString(8));
                   System.out.println("CardType: " + rs.getString(9));
                   System.out.println("=================================");
               }
              con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
  }
}
