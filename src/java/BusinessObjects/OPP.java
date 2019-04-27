package BusinessObjects;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*************
*OPP BO
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/
public class OPP {
    
/********************
 Variable Declarations
**********************/
    int accID;
    String username;
    String password;
    String fName;
    String lName;
    
/*****************
 *Database location
*******************/
    String yourDatabase = ("jdbc:ucanaccess://C:/Users/Madbr/Downloads/accounts_database.accdb");
    
    Path path = Paths.get("accounts_database.accdb");
    String database = path.toFile().getAbsolutePath();
    
    /********************************
     * Constructors
     * @param accID the OPP ID
     * @param username the OPP username
     * @param password the OPP password
     * @param fName the OPP first name
     * @param lName the OPP last name
     *********************************/
    public OPP(int accID, String username, String password, String fName, String lName){
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }
        
    public OPP() {
        this.accID = 0;
        this.username = "";
        this.password = "";
        this.fName = "";
        this.lName = "";
    }
    
/******************
*Get and Set Methods
*******************/
    public int getAccID(){
        return accID;
    }
    public void setAccID(int e){
        this.accID = e;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String e){
        this.username = e;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String e){
        this.password = e;
    }
    public String getFName(){
        return fName;
    }
    public void setFName(String e){
        this.fName = e;
    }
    public String getLName(){
        return lName;
    }
    public void setLName(String e){
        this.lName = e;
    }
    
    
/********************
*OPP Login Method
*********************/
    public void selectOPPLogin(String uname){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM OPP WHERE UserName = '" +uname+ "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            accID = rs.getInt("ID");
            username = rs.getString("UserName");
            password = rs.getString("Password");
            fName = rs.getString("FirstName");
            lName = rs.getString("LastName");
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/********************
*Select Method
*********************/
    public void selectOPP(int selID){
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from OPP WHERE ID ="+selID;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            accID = rs.getInt("ID");
            username = rs.getString("UserName");
            password = rs.getString("Password");
            fName = rs.getString("FirstName");
            lName = rs.getString("LastName");
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
/********************
 * Insert Method
*********************/
    public void insertOPP(String accID, String username, String password, String fName, String lName){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "INSERT into OPP(ID, UserName, Password, FirstName, LastName)" + "values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accID);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, fName);
            ps.setString(5, lName);
            ps.execute();
            System.out.println("added new OPP item succesfully");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
 /********************
*Update Method
*********************/
    public void updateOPP(){
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "UPDATE OPP SET UserName =?,  Password =?, FirstName =?, LastName =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fName);
            ps.setString(4, lName);
            ps.executeUpdate();
            System.out.println("OPP Successfully Updated");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/********************
*Delete Method
*********************/
    public void deleteOPP(){
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from OPP WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accID);
            ps.executeUpdate();
            System.out.println("OPP with ID "+accID+" was succesfully deleted");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/********************
* Display Method
*********************/
    public void Display(){
        System.out.println("Customer ID "+this.accID);
        System.out.println("Customer Username "+this.username);
        System.out.println("Customer Password "+this.password);
        System.out.println("Customer FirstName "+this.fName);
        System.out.println("Customer LastName "+this.lName);
    }
/********************
*Main Method
*********************/
    public static void main(String args[]){
        OPP opp1 = new OPP();
        opp1.selectOPP(3);
        opp1.Display();
    }
    
    
           
}