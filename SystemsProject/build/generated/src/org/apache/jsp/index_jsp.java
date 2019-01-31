package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            h1{\n");
      out.write("                color: green;\n");
      out.write("            }\n");
      out.write("            p, a{\n");
      out.write("                color: darkblue;\n");
      out.write("            }\n");
      out.write("            .button{\n");
      out.write("                  background-color: darkblue;\n");
      out.write("                  border: none;\n");
      out.write("                  color: white;\n");
      out.write("                  padding: 15px 32px;\n");
      out.write("                  margin: 5px;\n");
      out.write("                  text-align: center;\n");
      out.write("                  display: inline-block;\n");
      out.write("                  font-size: 16x;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"loginForm\" method=\"post\" action=\"LoginServlet\">\n");
      out.write("        <h1>D.M. Office Supplies</h1>\n");
      out.write("        <p> Username:\n");
      out.write("            <input type=\"text\" name=\"usernameTB\"> </p> \n");
      out.write("        <p> Password:\n");
      out.write("            <input type=\"text\" name=\"passwordTB\"> </p> \n");
      out.write("        <p><a href=\"null\">Create Account</a>\n");
      out.write("        <a href=\"null\">Continue as guest</a></p> \n");
      out.write("        \n");
      out.write("        <input type=\"submit\" name='logBtn' value='Login' class=\"button\"> \n");
      out.write("        <input type='reset' name='resetBtn' value='Clear' class=\"button\">\n");
      out.write("        </form>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
