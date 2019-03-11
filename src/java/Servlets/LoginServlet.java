package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    String id;
    String pw;
    String dbid;
    String dbpw;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        id = request.getParameter("usernameTB");
        pw = request.getParameter("passwordTB");
        PrintWriter out = response.getWriter();
        Path path = Paths.get("accounts_database.accdb");
        String database = path.toFile().getAbsolutePath();
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con =
               DriverManager.getConnection("jdbc:ucanaccess://"+database);
               Statement stmt = con.createStatement();
               String sql ="SELECT * FROM Customer WHERE UserName = "+id+"";
               ResultSet rs = stmt.executeQuery(sql);
               while(rs.next()){
                   dbid = rs.getString("UserName");
                   dbpw = rs.getString("Password");
               }
        }
        catch(Exception e){
            
        }
        if(id.equals(dbid) && pw.equals(dbpw)){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlt</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Valid</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        else{
          RequestDispatcher rd = request.getRequestDispatcher("/LoginError.jsp");
                    rd.forward(request, response); 
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
