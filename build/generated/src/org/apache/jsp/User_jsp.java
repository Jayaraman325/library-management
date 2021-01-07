package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class User_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

String ID=request.getParameter("user_id");
String NAME=request.getParameter("user_name");
String EMAIL=request.getParameter("user_email");
String GENDER=request.getParameter("user_gender");
String PASS1=request.getParameter("user_pass1");
String PASS2=request.getParameter("user_pass2");
if(PASS1.equals(PASS2)){
  try
{
      Class.forName("oracle.jdbc.OracleDriver");
    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
    PreparedStatement pst= con.prepareStatement("insert into users values(?,?,?,?,?)");
    pst.setString(1, ID);
    pst.setString(2, NAME);
    pst.setString(3, EMAIL);
    pst.setString(4, GENDER);
    pst.setString(5, PASS2);
    int x=pst.executeUpdate();
    if(x!=0){
        RequestDispatcher req = request.getRequestDispatcher("listbooks1.jsp");
			req.include(request, response);
    }else
               {
        out.println("something went wrong");
    }
        
  }
  
   
catch (Exception e)
               {
    out.println(e);
}
   }
else
       {
    out.println("Password not matching");
}


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
