package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class listbooks_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<HTML>\n");
      out.write("       <HEAD>\n");
      out.write("       <TITLE>Select Data From a Database</TITLE>\n");
      out.write("       </HEAD>\n");
      out.write("       <BODY BGCOLOR=\"cyan\">\n");
      out.write("           \n");
      out.write("            <H1>Books Available</H1>\n");
      out.write("            ");

              Class.forName("oracle.jdbc.OracleDriver");                
             Connection connection = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
                Statement statement = connection.createStatement() ;
                ResultSet resultset =
                statement.executeQuery("select * from admin1") ;
            
      out.write("\n");
      out.write("                <TABLE BORDER=\"1\" width=\"100%\" cellpadding=\"5pt\">\n");
      out.write("           <TR>\n");
      out.write("                 <TH>Book_ID</TH>\n");
      out.write("                 <TH>Title</TH>\n");
      out.write("                 <TH>Author</TH>\n");
      out.write("                 <TH>Price</TH>\n");
      out.write("            \n");
      out.write("          </TR>\n");
      out.write("           ");
 while(resultset.next()){ 
      out.write("\n");
      out.write("           <TR>\n");
      out.write("                <TD> ");
      out.print( resultset.getString(1) );
      out.write("</td>\n");
      out.write("               <TD> ");
      out.print( resultset.getString(2) );
      out.write("</TD>\n");
      out.write("               <TD> ");
      out.print( resultset.getString(3) );
      out.write("</TD>\n");
      out.write("               <TD> ");
      out.print( resultset.getString(4) );
      out.write("</TD>\n");
      out.write("               \n");
      out.write("               \n");
      out.write("          </TR>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("           ");
 } 
      out.write("\n");
      out.write("               </TABLE>\n");
      out.write("               <br>\n");
      out.write("               <br>\n");
      out.write("               <b><a href=\"update.html\">Update Books</a></b>\n");
      out.write("           &nbsp;\n");
      out.write("           <b><a href=\"delete.html\">Delete Books</a></b>\n");
      out.write("         </BODY>\n");
      out.write("</HTML>");
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
