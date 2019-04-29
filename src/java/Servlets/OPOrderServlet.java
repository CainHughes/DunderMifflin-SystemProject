
package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/*************
*OP Order Servlet
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/

@WebServlet(name = "OPOrderServlet", urlPatterns = {"/OPOrderServlet"})
public class OPOrderServlet extends HttpServlet {
     /***********************
     * Variable Declarations
     ***********************/
    String custID;
    String itemID;
    String quantity;
    String itemT;
    String ship;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
/********************************
*Set variables with text box data
*********************************/
        custID = request.getParameter("shipTB");
/********************************************
*Select cart with customer ID matching text box
**********************************************/
            try
    {
            System.out.println(custID);
            String yourDatabase = ("jdbc:ucanaccess://C:/Users/GC3/Desktop/accounts_database.accdb");
            Connection con =
            DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Cart WHERE custID = '"+custID+"'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next(); 
            custID = rs.getString("custID");
            itemID = rs.getString("itemID");
            quantity = rs.getString("quantity");
            itemT = rs.getString("itemTable");
            ship = rs.getString("shipped");
            System.out.println(ship + custID + quantity + itemT + ship);
            con.close();
           
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
 /********************************
*Update shipping from no to yes
*********************************/
                        try
    {
            ship = "yes";
            String yourDatabase = ("jdbc:ucanaccess://C:/Users/GC3/Desktop/accounts_database.accdb");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con =
            DriverManager.getConnection(yourDatabase);
            String sql = "UPDATE Cart SET itemID=?,quantity=?, itemTable=?, shipped=? WHERE custID = ?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, itemID);
             ps.setString(2, quantity);
             ps.setString(3, itemT);
             ps.setString(4, ship);
             ps.setString(5, custID);
             ps.executeUpdate();
            con.close();
       
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
           
            try{
                RequestDispatcher rd = request.getRequestDispatcher("/OPOrders.jsp");
                    rd.forward(request, response);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}