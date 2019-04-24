/**
 *
 * Cart Business object
 */
package BusinessObjects;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Cart {
    
    ArrayList<Item> cartList = new ArrayList<>();
    ArrayList<String> itemID = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemTable = new ArrayList<>();
    String custID;

    //just change this to wherever it's located on your computer
    String accPath = "C:/Users/donov/Documents/accounts_database.accdb";
    String invPath = "C:/Users/donov/Documents/inventory_database.accdb";
    String accSql,invSql;
    
    
// setter getter
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }
    
//Constructor
    
    public Cart(String custID) {
        this.custID = custID;
    }
    public Cart() {
    }
    
//Select Method
    public void selectDB() {
        try{
            Connection accCon = DriverManager.getConnection("jdbc:ucanaccess://"+accPath);
            Connection invCon = DriverManager.getConnection("jdbc:ucanaccess://"+invPath);
            Statement accStmt = accCon.createStatement();
            Statement invStmt = invCon.createStatement();

            accSql = "select * from Cart where custID = "+custID+";";
            System.out.println(accSql);
            ResultSet accRs = accStmt.executeQuery(accSql);
            while(accRs.next()){
                itemID.add(accRs.getString(2));
                quantity.add(accRs.getString(3));
                itemTable.add(accRs.getString(4));
                invSql = "select * from "+ accRs.getString(4) +" where ID = "+ accRs.getString(2)+";";
                System.out.println(invSql);
                ResultSet invRs = invStmt.executeQuery(invSql);
                invRs.next();
                Item i1 = new Item(invRs.getString("ID"), invRs.getString("ItemName"), invRs.getInt("Stock"), invRs.getDouble("Price"), invRs.getString("Manufacturer"), invRs.getString("ModelNumber"), invRs.getString("Description"));
                cartList.add(i1);
            }
            accCon.close();
        }
        catch (SQLException se){
            System.out.println("SQL Exception: "+se);
        }
        catch(Exception ex){
            System.out.println("Other Exception: "+ex);
        }
    }
//Insert Method
    public void insertDB(String itemID, String quantity, String itemTable) {
        try{
            Connection accCon = DriverManager.getConnection("jdbc:ucanaccess://"+accPath);
            Statement stmt = accCon.createStatement();
            String sql = "INSERT into Cart values ("+custID+","+itemID+","+quantity+",'"+itemTable+"')";
            System.out.println(sql);
            int rs = stmt.executeUpdate(sql);
            if (rs == 1){
                System.out.println("Data inserted");
                selectDB();
            }
            else{
                System.out.println("Error inserting data");
                }
        }
        catch (SQLException se){
            System.out.println("SQL Exception: "+se);
        }
        catch(Exception ex){
            System.out.println("Other Exception: "+ex);
        }
    }
//Update Method
    public void updateDB(String itemID, String quantity){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection accCon = DriverManager.getConnection("jdbc:ucanaccess://"+accPath);
            Statement stmt = accCon.createStatement();
            String sql;
            sql = "Update Accounts set quantity = " + quantity + "WHERE CustID = '"+custID+"' AND itemID = '"+itemID+"';";
            System.out.println(sql);
            int rs = stmt.executeUpdate(sql);
            if (rs == 1){
                System.out.println("Data updated");
            }
            else{
                System.out.println("Error updating data");
                }
            accCon.close();
        }
        catch (SQLException se){
            System.out.println("SQL Exception: "+se);
        }
        catch(Exception ex){
            System.out.println("Other Exception: "+ex);
        }
    }
//Delete Method
    public void deleteDB(String itemID){
        try{
            Connection accCon = DriverManager.getConnection("jdbc:ucanaccess://"+accPath);
            Statement stmt = accCon.createStatement();
            String sql;
            sql = "DELETE * FROM Cart WHERE CustID = '"+custID+"' AND itemID = '"+itemID+"';";
            System.out.println(sql);
            int rs = stmt.executeUpdate(sql);
            if (rs == 1){
                System.out.println("Cart Item deleted");
            }
            else{
                System.out.println("Error deleting Cart Item");
                }
            accCon.close();
        }
        catch (SQLException se){
            System.out.println("SQL Exception: "+se);
        }
        catch(Exception ex){
            System.out.println("Other Exception: "+ex);
        }
    }
//Clear Cart Method
    public void clearDB(String custID){
        try{
            Connection accCon = DriverManager.getConnection("jdbc:ucanaccess://"+accPath);
            Statement stmt = accCon.createStatement();
            String sql;
            sql = "DELETE * FROM Cart WHERE CustID = '"+custID+"';";
            System.out.println(sql);
            int rs = stmt.executeUpdate(sql);
            if (rs == 1){
                System.out.println("Cart cleared");
            }
            else{
                System.out.println("Error clearing Cart");
                }
            accCon.close();
        }
        catch (SQLException se){
            System.out.println("SQL Exception: "+se);
        }
        catch(Exception ex){
            System.out.println("Other Exception: "+ex);
        }
    }
//Display Method
    public void display(){
        for (int i = 0; i < cartList.size(); i++){
            cartList.get(i).display();
            System.out.println("itemID in DB: " + itemID.get(i));
            System.out.println("quantity in Cart: " + quantity.get(i));
            System.out.println("located in itemTable: " + itemTable.get(i));
            System.out.println("----------------------------------");
        }
    }
}
