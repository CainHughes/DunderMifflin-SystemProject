
package Servlets;

import BusinessObjects.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*************
*Edit Account Servlet
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/
@WebServlet(name = "EditAccountServlet", urlPatterns = {"/EditAccountServlet"})
public class EditAccountServlet extends HttpServlet {

     /***********************
     * Variable Declarations
     ***********************/
    int accID;
    String uname;
    String pw;
    String fName;
    String lName;
    String email;
    String address;
    String cardType;
    String cardNum;
    int cn;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
/********************************
*Set variables with text box data
*********************************/
        uname = request.getParameter("custNametb");
        pw = request.getParameter("custPasstb");
        fName = request.getParameter("fnametb");
        lName = request.getParameter("lnametb");
        email = request.getParameter("emailtb");
        address = request.getParameter("addtb");
        cardNum = request.getParameter("cardNumtb");
        cardType = request.getParameter("cardTypetb");
        cn = Integer.parseInt(cardNum);
        Customer c1;
        
/**************************************************
*get customer object from session
* set customer's variables 
* update customer
* set customer object back into session with update
******************************************************/
        try{
            HttpSession ses1;
            ses1 = request.getSession();
            c1 = (Customer)ses1.getAttribute("c1");
            accID = c1.getAccID();
            System.out.println("Customer ID: " + accID);
            c1.selectCustomer(accID);
            c1.setUsername(uname);
            c1.setPassword(pw);
            c1.setFName(fName);
            c1.setLName(lName);
            c1.setEmail(email);
            c1.setAddress(address);
            c1.setCardNum(cn);
            c1.setCardType(cardType);
            c1.updateCustomer();
            HttpSession hs1;
            hs1 = request.getSession();
            hs1.setAttribute("c1", c1);
            System.out.println("Customer was added to the session");
                RequestDispatcher rd = request.getRequestDispatcher("/ViewAccount.jsp");
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

