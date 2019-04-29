/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BusinessObjects.*;
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
*OPP Login Servlet
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/
@WebServlet(name = "OPPLoginServlet", urlPatterns = {"/OPPLoginServlet"})
public class OPPLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     /***********************
     * Variable Declarations
     ***********************/
    String uname;
    String pw;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
/********************************
*Set variables with text box data
*********************************/
               uname = request.getParameter("usernameTB");
               pw = request.getParameter("passwordTB");
       
     /***********************
     * create OPP object
     * OPP select OPP login method
     * OPP display method
     ***********************/
             OPP o1 = new OPP();
             o1.selectOPPLogin(uname);
             o1.Display();
     /***********************
     *Login Validation 
     ***********************/
             if(pw.equals("")){
                 RequestDispatcher rd = request.getRequestDispatcher("/OPPloginError.jsp");
                          rd.forward(request, response);
             }
             else if(pw.equals(o1.getPassword())){
                  HttpSession ses1;
                      ses1 = request.getSession();
                      ses1.setAttribute("o1", o1);
            
                  RequestDispatcher rd = request.getRequestDispatcher("/OPOrders.jsp");
                          rd.forward(request, response);
              }
              else{
                RequestDispatcher rd = request.getRequestDispatcher("/OPPloginError.jsp");
                          rd.forward(request, response); 
              }
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
