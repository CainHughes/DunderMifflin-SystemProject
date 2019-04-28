package BusinessObjects;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/*************
*Customer BO
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/
public class Customer {
    
 /********************
 *Variable Declarations
**********************/
    
    int accID;
    String username;
    String password;
    String fName;
    String lName;
    String email;
    String address;
    int cardNum;
    String cardType;
    int lastID;
    public Cart cart;
    
 /*****************
 *Database location
*******************/
    String yourDatabase = ("jdbc:ucanaccess://C:/Users/donov/Documents/accounts_database.accdb");
    
    
    Path path = Paths.get("accounts_database.accdb");
    String database = path.toFile().getAbsolutePath();
    
    /**********************************************
     * Constructors
     * @param accID the customer's id.
     * @param username the customer's username
     *  @param password the customer's password.
     *  @param fName the customer's first name.
     *  @param lName the customer's last name.
     *  @param email the customer's email.
     *  @param address the customer's address.
     * @param cardNum the customer's card number.
     * @param cardType the customer's card type.
    ************************************************/
    public Customer(int accID, String username, String password, String fName, String lName, String email, String address, int cardNum, String cardType){
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;
        this.cardNum = cardNum;
        this.cardType = cardType;
    }
        
    public Customer() {
        this.accID = 0;
        this.username = "";
        this.password = "";
        this.fName = "";
        this.lName = "";
        this.email = "";
        this.address = "";
        this.cardNum = 0;
        this.cardType = "";
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String e){
        this.email = e;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String e){
        this.address = e;
    }
    public int getCardNum(){
        return cardNum;
    }
    public void setCardNum(int e){
        this.cardNum = e;
    }
    public String getCardType(){
        return cardType;
    }
    public void setCardType(String e){
        this.cardType = e;
    }
    
/********************
*Customer Login Method
*********************/
    public void selectCustomerLogin(String uname){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Customer WHERE UserName = '" +uname+ "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            accID = rs.getInt("ID");
            username = rs.getString("UserName");
            password = rs.getString("Password");
            fName = rs.getString("FirstName");
            lName = rs.getString("LastName");
            email = rs.getString("Email");
            address = rs.getString("Address");
            cardNum = rs.getInt("CardNumber");
            cardType = rs.getString("CardType");
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/************
*Select Method
************/
    public void selectCustomer(int selID){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Customer WHERE ID ="+selID;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            accID = rs.getInt("ID");
            username = rs.getString("UserName");
            password = rs.getString("Password");
            fName = rs.getString("FirstName");
            lName = rs.getString("LastName");
            email = rs.getString("Email");
            address = rs.getString("Address");
            cardNum = rs.getInt("CardNumber");
            cardType = rs.getString("CardType");
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/**************************
*Select Last Customer Method
****************************/
    public void selectLastCustomer(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Customer";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            lastID = rs.getInt("ID");     
            con.close();
            }
            accID = 1 + lastID;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/************
*Insert Method
************/
    public void insertCustomer(String accID, String username, String password, String fName, String lName, String email, String address, int cardNum, String cardType){
        try{
            
            Connection con = DriverManager.getConnection(yourDatabase);
            String sql = "INSERT into Customer(ID, UserName, Password, FirstName, LastName, Email, Address, CardNumber, CardType)" + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accID);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, fName);
            ps.setString(5, lName);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setInt(8, cardNum);
            ps.setString(9, cardType);
            ps.execute();
            System.out.println("added new customer item succesfully");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/************
*Update Method
************/
    public void updateCustomer(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(yourDatabase);
            String sql = "UPDATE Customer SET UserName =?,  Password =?, FirstName =?, LastName =?, Email =?, Address =?, CardNumber =?, CardType =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fName);
            ps.setString(4, lName);
            ps.setString(5, email);
            ps.setString(6, address);
            ps.setInt(7, cardNum);
            ps.setString(8, cardType);
            ps.setInt(9, accID);
            ps.executeUpdate();
            System.out.println("Customer Successfully Updated");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/************
*Delete Method
************/
    public void deleteCustomer(){
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from Customer WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accID);
            ps.executeUpdate();
            System.out.println("Customer with ID "+accID+" was succesfully deleted");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
/**************
*Display Method
***************/
    public void Display(){
        System.out.println("Customer ID "+this.accID);
        System.out.println("Customer Username "+this.username);
        System.out.println("Customer Password "+this.password);
        System.out.println("Customer FirstName "+this.fName);
        System.out.println("Customer LastName "+this.lName);
        System.out.println("Customer Email "+this.email);
        System.out.println("Customer Address "+this.address);
        System.out.println("Customer CardNumber "+this.cardNum);
        System.out.println("Customer CardType "+this.cardType);
    }
/***********
*Main Method
************/
    public static void main(String args[]){
    Customer cust1 = new Customer();
    cust1.selectCustomer(2);
    cust1.setAddress("555 Glory Hills");
    cust1.setCardNum(45543);
    cust1.setCardType("Visa");
    cust1.updateCustomer();
 
    }
    
    
           
}