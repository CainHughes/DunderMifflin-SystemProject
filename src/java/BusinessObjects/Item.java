package BusinessObjects;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

/*************
*Item BO
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/

public class Item {
    
/********************
*Variable Declarations
**********************/
    String ItemID;
    String ItemName;
    int Stock;
    double Price;
    String Manu;
    String ModelNum;
    String Description;
    String[] ItemIDArray;
    String[] ItemNameArray;
    int[] StockArray;
    double[] PriceArray;
    String[] ManuArray;
    String[] ModelNumArray;
    String[] DescriptionArray;
    
/*****************
*Database location
*******************/
    String database = "C:/Users/GC3/Desktop/inventory_database.accdb";
    
    /*****************************************
     * Constructors
     * @param ItemID the item's ID
     * @param ItemName the item's name
     * @param Stock the item's amount in stock
     * @param Price the item's price
     * @param Manu the item's manufacturer
     * @param ModelNum the item's model number
     * @param Description the item's description
     ********************************************/
    public Item(String ItemID, String ItemName, int Stock, double Price, String Manu, String ModelNum, String Description){
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.Stock = Stock;
        this.Price = Price;
        this.Manu = Manu;
        this.ModelNum = ModelNum;
        this.Description = Description;
    }
    public Item(){
        this.ItemID = "0";
        this.ItemName = "";
        this.Stock = 0;
        this.Price = 0;
        this.Manu = "";
        this.ModelNum = "";
        this.Description = "";
    }
/******************
*Get and Set Methods
*******************/
    public String getItemID(){
        return ItemID;
    }
    public void setItemID(String i){
        this.ItemID = i;
    }
    public String getItemName(){
        return ItemName;
    }
    public void setItemName(String n){
        this.ItemName = n;
    }
    public int getStock(){
        return Stock;
    }
    public void setStock(int s){
        this.Stock = s;
    }
    public double getPrice(){
        return Price;
    }
    public void setPrice(double p){
        this.Price = p;
    }
    public String getManu(){
        return Manu;
    }
    public void setManu(String m){
        this.Manu = m;
    }
    public String getModelNum(){
        return ModelNum;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String d){
        this.Description = d;
    }
    public String[] getItemIDArray(){
        return ItemIDArray;
    }
/************************
*Electronic Select Method
************************/
    //Select Method
    public void selectElectronic(String ID){
   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Electronics WHERE ID = "+ID+"";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ItemID = rs.getString("ID");
            ItemName = rs.getString("ItemName");
            Stock = rs.getInt("Stock");
            Price = rs.getDouble("Price");
            Manu = rs.getString("Manufacturer");
            ModelNum = rs.getString("ModelNumber");
            Description = rs.getString("Description");
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
/************************
*Electronic Insert Method
************************/
    public void insertElectronic(String ItemID, String ItemName, int Stock, double Price, String Manu, String ModelNum, String Description){
 
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "INSERT into Electronics(ID, ItemName, Stock, Price, Manufacturer, ModelNumber, Description)" + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.setString(2, ItemName);
            ps.setInt(3, Stock);
            ps.setDouble(4, Price);
            ps.setString(5, Manu);
            ps.setString(6, ModelNum);
            ps.setString(7, Description);
            ps.execute();
            System.out.println("One new item was successfully added!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/************************
*Electronic Update Method
************************/
   public void updateElectronic(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "UPDATE Electronics SET ItemName =?, Stock =?, Price =?, Manufacturer =?, ModelNumber =?, Description =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Stock);
            ps.setDouble(3, Price);
            ps.setString(4, Manu);
            ps.setString(5, ModelNum);
            ps.setString(6, Description);
            ps.setString(7, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully updated!");
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Electronic Delete Method
************************/
   public void deleteElectronic(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from Electronics WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully deleted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Decoration Select Method
************************/
    public void selectDecoration(String ID){
   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Decoration WHERE ID = "+ID+"";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ItemID = rs.getString("ID");
            ItemName = rs.getString("ItemName");
            Stock = rs.getInt("Stock");
            Price = rs.getDouble("Price");
            Manu = rs.getString("Manufacturer");
            ModelNum = rs.getString("ModelNumber");
            Description = rs.getString("Description");
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
/*****************************
*Decoration Select All Method
******************************/
    public void selectAllDecoration(){
         try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Decoration";
            int i = 0;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            ItemIDArray[i] = rs.getString("ID");
            ItemNameArray[i] = rs.getString("ItemName");
            StockArray[i] = rs.getInt("Stock");
            PriceArray[i] = rs.getDouble("Price");
            ManuArray[i] = rs.getString("Manufacturer");
            ModelNumArray[i] = rs.getString("ModelNumber");
            DescriptionArray[i] = rs.getString("Description");
            i = i+1;
         }
            for(int c = 1; c < ItemIDArray.length; c++){
            System.out.println(ItemIDArray[c]);
            System.out.println(ItemNameArray[c]);
            System.out.println(StockArray[c]);
            System.out.println(PriceArray[c]);
            System.out.println(ManuArray[c]);
            System.out.println(ModelNumArray[c]);
            System.out.println(DescriptionArray[c]);
            }
         }
        catch(Exception e){
                System.out.println(e);
        }
    }
/************************
*Decoration Insert Method
************************/
    public void insertDecoration(String ItemID, String ItemName, int Stock, double Price, String Manu, String ModelNum, String Description){
 
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "INSERT into Decoration(ID, ItemName, Stock, Price, Manufacturer, ModelNumber, Description)" + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.setString(2, ItemName);
            ps.setInt(3, Stock);
            ps.setDouble(4, Price);
            ps.setString(5, Manu);
            ps.setString(6, ModelNum);
            ps.setString(7, Description);
            ps.execute();
            System.out.println("One new item was successfully added!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/************************
*Decoration Update Method
************************/
   public void updateDecoration(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "UPDATE Decoration SET ItemName =?, Stock =?, Price =?, Manufacturer =?, ModelNumber =?, Description =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Stock);
            ps.setDouble(3, Price);
            ps.setString(4, Manu);
            ps.setString(5, ModelNum);
            ps.setString(6, Description);
            ps.setString(7, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully updated!");
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Decoration Delete Method
************************/
   public void deleteDecoration(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from Decoration WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully deleted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
   
/************************
*Furniture Select Method
************************/
    public void selectFurniture(String ID){
   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Furniture WHERE ID = "+ID+"";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ItemID = rs.getString("ID");
            ItemName = rs.getString("ItemName");
            Stock = rs.getInt("Stock");
            Price = rs.getDouble("Price");
            Manu = rs.getString("Manufacturer");
            ModelNum = rs.getString("ModelNumber");
            Description = rs.getString("Description");
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
/***************************
*Furniture Select All Method
****************************/
    public void selectAllFurniture(){
         try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Furniture";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            ItemID = rs.getString("ID");
            ItemName = rs.getString("ItemName");
            Stock = rs.getInt("Stock");
            Price = rs.getDouble("Price");
            Manu = rs.getString("Manufacturer");
            ModelNum = rs.getString("ModelNumber");
            Description = rs.getString("Description");
         }
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
/************************
*Furniture Insert Method
************************/
    public void insertFurniture(String ItemID, String ItemName, int Stock, double Price, String Manu, String ModelNum, String Description){
 
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "INSERT into Furniture(ID, ItemName, Stock, Price, Manufacturer, ModelNumber, Description)" + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.setString(2, ItemName);
            ps.setInt(3, Stock);
            ps.setDouble(4, Price);
            ps.setString(5, Manu);
            ps.setString(6, ModelNum);
            ps.setString(7, Description);
            ps.execute();
            System.out.println("One new item was successfully added!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/************************
*Furniture Update Method
************************/
   public void updateFurniture(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "UPDATE Furniture SET ItemName =?, Stock =?, Price =?, Manufacturer =?, ModelNumber =?, Description =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Stock);
            ps.setDouble(3, Price);
            ps.setString(4, Manu);
            ps.setString(5, ModelNum);
            ps.setString(6, Description);
            ps.setString(7, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully updated!");
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Furniture Delete Method
************************/
   public void deleteFurniture(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from Furniture WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully deleted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Paper Select Method
************************/
    public void selectPaper(String ID){
   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from WritingPaper WHERE ID = "+ID+"";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ItemID = rs.getString("ID");
            ItemName = rs.getString("ItemName");
            Stock = rs.getInt("Stock");
            Price = rs.getDouble("Price");
            Manu = rs.getString("Manufacturer");
            ModelNum = rs.getString("ModelNumber");
            Description = rs.getString("Description");
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
/************************
*Paper Insert Method
************************/
    public void insertPaper(String ItemID, String ItemName, int Stock, double Price, String Manu, String ModelNum, String Description){
 
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "INSERT into WritingPaper(ID, ItemName, Stock, Price, Manufacturer, ModelNumber, Description)" + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.setString(2, ItemName);
            ps.setInt(3, Stock);
            ps.setDouble(4, Price);
            ps.setString(5, Manu);
            ps.setString(6, ModelNum);
            ps.setString(7, Description);
            ps.execute();
            System.out.println("One new item was successfully added!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
/************************
*Paper Update Method
************************/
   public void updatePaper(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "UPDATE WritingPaper SET ItemName =?, Stock =?, Price =?, Manufacturer =?, ModelNumber =?, Description =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Stock);
            ps.setDouble(3, Price);
            ps.setString(4, Manu);
            ps.setString(5, ModelNum);
            ps.setString(6, Description);
            ps.setString(7, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully updated!");
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
/************************
*Paper Delete Method
************************/
   public void deletePaper(){
        try{
            Connection con =
            DriverManager.getConnection("jdbc:ucanaccess://"+database);
            String sql = "DELETE from WritingPaper WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemID);
            ps.executeUpdate();
            System.out.println("One item was successfully deleted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
   }
   
/************************
*Display items Method
************************/
    public void display(){
        System.out.println("Item ID: " + this.ItemID);
        System.out.println("Item Name: " + this.ItemName);
        System.out.println("Stock: " + this.Stock);
        System.out.println("Price: $" + this.Price);
        System.out.println("Manufacturer: " + this.Manu);
        System.out.println("Model Number: " + this.ModelNum);
        System.out.println("Description: " + this.Description);
    }
/************************
*Main Method
************************/
    public static void main(String[] args){
        Item i1 = new Item();
        i1.selectAllDecoration();
    }
     
    }



