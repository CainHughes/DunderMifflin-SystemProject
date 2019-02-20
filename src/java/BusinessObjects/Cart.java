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
    
    Path accPath = Paths.get("accounts_database.accdb");
    Path invPath = Paths.get("inventory_database.accdb");
    String accDatabase = accPath.toFile().getAbsolutePath();
    String invDatabase = invPath.toFile().getAbsolutePath();
    String accSql,invSql;

//Constructor
    
    public Cart(String custID) {
        this.custID = custID;
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
                Item i1 = new Item(invRs.getString(1), invRs.getString(2), invRs.getInt(3), invRs.getDouble(4), invRs.getString(5), invRs.getString(6), invRs.getString(7));
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
            String sql = "INSERT into Decoration(custID, itemID, quantity, itemTable)" + "values(?,?,?,?)";
            PreparedStatement ps = accCon.prepareStatement(sql);
            ps.setString(1, custID);
            ps.setString(2, itemID);
            ps.setString(3, quantity);
            ps.setString(4, itemTable);
            ps.execute();
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
    public static void main(String[] args){
        Cart c1 = new Cart("1");
        c1.selectDB();
        c1.display();
    }
}
